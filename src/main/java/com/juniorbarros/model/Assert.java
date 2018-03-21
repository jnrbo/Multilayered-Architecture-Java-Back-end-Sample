package com.juniorbarros.model;

/**
 * Created by juniorbarros on 03/08/2017.
 */
public class Assert {

    public static void notNull(Object object, String message) {
        if (object == null) {
            exception(message);
        }
    }

    public static void notEmpty(CharSequence text, String message) {
        if (text == null || text.length() == 0) {
            exception(message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            exception(message);
        }
    }

    public static void isFalse(boolean expression, String message) {
        isTrue(!expression, message);
    }

    public static void size(Long size, Long compare, String message) {
        isTrue(size.equals(compare), message);
    }

    public static void size(int size, int compare, String message) {
        isTrue(size == compare, message);
    }

    private static void exception(String message) {
        throw new RuntimeException(message);
    }

}
