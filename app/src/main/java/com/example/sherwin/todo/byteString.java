package com.example.sherwin.todo;

/**
 * Created by Sherwin on 10/08/2017.
 */

public class byteString {
    String eyedee;
    private byteString(){}

    public static String getEyedee(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder("0x");
        if (bytes == null || bytes.length <= 0) {
            return null;
        }

        char[] buffer = new char[2];
        for (int i = 0; i < bytes.length; i++) {
            buffer[0] = Character.forDigit((bytes[i] >>> 4) & 0x0F, 16);
            buffer[1] = Character.forDigit(bytes[i] & 0x0F, 16);
            System.out.println(buffer);
            stringBuilder.append(buffer);
        }
        return stringBuilder.toString();
    }
}
