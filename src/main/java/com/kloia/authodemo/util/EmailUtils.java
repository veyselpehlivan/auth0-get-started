package com.kloia.authodemo.util;

public final class EmailUtils {

    public EmailUtils() {
    }

    public static String getDomain(String email) {
        return  email.substring(email.indexOf("@") + 1);
    }
}
