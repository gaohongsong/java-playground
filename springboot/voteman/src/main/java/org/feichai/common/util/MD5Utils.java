package org.feichai.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
    public static final String ALG_NAME = "md5";
    public static final int HASH_ITERATIONS = 2;
    private static final String SALT = "feichai";
    protected MD5Utils() {
    }

    public static String encrypt(String passwd) {
        return new SimpleHash(ALG_NAME, passwd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
    }

    public static String encrypt(String username, String passwd) {
        return new SimpleHash(ALG_NAME, passwd, ByteSource.Util.bytes(
                username.toLowerCase() + SALT
        ), HASH_ITERATIONS).toHex();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("admin", "admin"));
    }
}
