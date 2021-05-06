package com.taxi.cargo.bean;

public abstract class Entity {

    private static long id = 0L;

    public static long getId() {
        return id;
    }

    public static void setId (long id) {
        Entity.id = id;
    }
}
