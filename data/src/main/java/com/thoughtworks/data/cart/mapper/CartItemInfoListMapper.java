package com.thoughtworks.data.cart.mapper;

import com.thoughtworks.data.cart.CartDataRepository;
import com.thoughtworks.data.cart.entity.CartDetailEntity;
import com.thoughtworks.data.cart.entity.CartItemEntity;
import com.thoughtworks.data.repository.database.CartItemInfo;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created on 16-06-2018.
 */
public class CartItemInfoListMapper
        implements com.thoughtworks.data.Mapper<RealmResults<CartItemInfo>, CartDetailEntity> {

    @Override
    public CartDetailEntity map(final RealmResults<CartItemInfo> input) {
        final ArrayList<CartItemEntity> result =
                new ArrayList<>(input.size());
        final CartItemInfoMapper itemMapper = new CartItemInfoMapper();
        for (int i = 0; i < input.size(); i++) {
            result.add(itemMapper.map(input.get(i)));
        }
        return new CartDetailEntity(result,
                CartDataRepository.getCartSum(input));
    }
}
