package com.thoughtworks.data.cart;

import android.content.Context;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.cart.entity.CartDetailEntity;
import com.thoughtworks.data.cart.mapper.CartDetailEntityMapper;
import com.thoughtworks.data.cart.mapper.CartItemInfoListMapper;
import com.thoughtworks.data.repository.DataStoreRepository;
import com.thoughtworks.data.repository.database.CartItemInfo;
import com.thoughtworks.data.repository.database.ProductInfo;
import com.thoughtworks.domain.cart.CartDetails;
import com.thoughtworks.domain.cart.CartRepository;

import java.lang.ref.WeakReference;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created on 15-06-2018.
 */
public class CartDataRepository implements CartRepository {

    private final Mapper<RealmResults<CartItemInfo>, CartDetailEntity> mCartItemInfoListMapper;
    private final Mapper<CartDetailEntity, CartDetails> mCartDetailEntityMapper;

    private final WeakReference<Context> mContext;

    private CartDataRepository(final WeakReference<Context> context) {
        mContext = context;
        mCartItemInfoListMapper = new CartItemInfoListMapper();
        mCartDetailEntityMapper = new CartDetailEntityMapper();
    }

    public static CartRepository newInstance(WeakReference<Context> context) {
        return new CartDataRepository(context);
    }

    @Override
    public boolean addToCart(int productId) {
        final Realm realm = Realm.getDefaultInstance();
        if (isAlreadyAdded(realm, productId)) return false;
        final int nextId = getNextCartId(realm);
        final ProductInfo productForId = DataStoreRepository.getProductForId(productId);
        if (productForId == null) return false;
        final CartItemInfo cartItemInfo = new CartItemInfo(nextId, productForId);
        realm.beginTransaction();
        realm.insert(cartItemInfo);
        realm.commitTransaction();
        realm.close();
        return true;
    }

    @Override
    public boolean removeFromCart(int cartId) {
        final Realm realm = Realm.getDefaultInstance();
        final CartItemInfo cartItemInfo = realm
                .where(CartItemInfo.class)
                .equalTo(CartItemInfo.ColumnName.ID, cartId)
                .findFirst();
        if (cartItemInfo == null) {
            return false;
        }
        realm.beginTransaction();
        cartItemInfo.deleteFromRealm();
        realm.commitTransaction();
        realm.close();
        return true;
    }

    @Override
    public CartDetails getCartDetails() {
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        final RealmResults<CartItemInfo> result =
                realm.where(CartItemInfo.class)
                        .findAll();
        realm.commitTransaction();
        realm.close();
        if (result == null) {
            return null;
        }
        final CartDetailEntity cartDetailEntity = mCartItemInfoListMapper.map(result);
        return mCartDetailEntityMapper.map(cartDetailEntity);
    }

    @Override
    public Integer getProductIdFromCartId(final Integer cartId) {
        final CartItemInfo result = getCartItemInfoForId(cartId);
        if (result == null) {
            return null;
        }
        return result.getProductInfo().getId();
    }

    private CartItemInfo getCartItemInfoForId(final Integer cartId) {
        if (cartId == null) {
            return null;
        }
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        final CartItemInfo result =
                realm.where(CartItemInfo.class)
                        .equalTo(CartItemInfo.ColumnName.ID, cartId)
                        .findFirst();
        realm.commitTransaction();
        realm.close();
        return result;
    }

    private int getNextCartId(final Realm realm) {
        final Number maxId = realm
                .where(CartItemInfo.class)
                .max(CartItemInfo.ColumnName.ID);
        return maxId == null ? 1 : maxId.intValue() + 1;
    }

    private boolean isAlreadyAdded(final Realm realm,
                                   final int productInfoId) {
        final CartItemInfo existingCartItem =
                realm.where(CartItemInfo.class)
                        .equalTo(CartItemInfo.ColumnName.PRODUCT_INFO
                                        + "." + ProductInfo.ColumnNames.ID,
                                productInfoId)
                        .findFirst();
        return existingCartItem != null;
    }

    public static double getCartSum(final RealmResults<CartItemInfo> data) {
        double sum = 0.0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) != null) {
                sum += data.get(i).getProductInfo().getPrice();
            }
        }
        return sum;
    }
}
