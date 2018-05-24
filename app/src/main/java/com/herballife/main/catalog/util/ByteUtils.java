package com.herballife.main.catalog.util;

public class ByteUtils {

    public static Byte[] toByteObjectArray(byte[] bytes) {
        Byte[] bytesObjs = new Byte[bytes.length];
        int i = 0;

        for (byte b : bytes)
            bytesObjs[i++] = b;

        return bytesObjs;
    }

    public static byte[] toByteArray(Byte[] byteObjs) {
        byte[] bytes = new byte[byteObjs.length];
        int i = 0;

        for (Byte b : byteObjs)
            bytes[i++] = b;

        return bytes;
    }
}
