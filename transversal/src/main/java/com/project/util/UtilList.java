package com.project.util;

import java.util.ArrayList;
import java.util.List;

public class UtilList {
    private UtilList() {
    }

    public static <T> List<T> defaultFrom(T object, int length) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(object);
        }
        return list;
    }
}
