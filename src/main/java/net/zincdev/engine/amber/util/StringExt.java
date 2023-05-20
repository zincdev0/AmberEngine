package net.zincdev.engine.amber.util;

import java.util.Random;

public class StringExt {
    public static String RandomString(int charStart, int charEnd, int length) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            int rangedRandom = charStart + (int)(random.nextFloat() * (charEnd - charStart + 1));
            buffer.append((char)rangedRandom);
        }
        return buffer.toString();
    }
}
