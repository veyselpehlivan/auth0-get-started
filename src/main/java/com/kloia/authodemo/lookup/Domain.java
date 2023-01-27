package com.kloia.authodemo.lookup;

import java.util.HashMap;

public class Domain {

    public Domain() {
    }

    private static final HashMap<String, String> domainMap = new HashMap<>();

    public static String findInDomainMap(String key) {
        return domainMap.get(key);
    }

    public static void putToDomainMap(String key, String value) {
        domainMap.put(key, value);
    }
}
