package com.project.util;

import com.google.gson.Gson;

public class UtilJson {
    private static final Gson gson = new Gson();

    private UtilJson() {
    }

    public static Gson getGson() {
        return gson;
    }
}
