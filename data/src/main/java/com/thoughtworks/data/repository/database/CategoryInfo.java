package com.thoughtworks.data.repository.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created on 14-06-2018.
 */
public class CategoryInfo extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;

    public CategoryInfo() {
    }

    public CategoryInfo(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static final class ColumnName {
        public static final String ID = "id";
        public static final String NAME = "name";
    }
}
