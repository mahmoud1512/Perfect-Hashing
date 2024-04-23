package org.example.HashTable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConvertToBinaryFactory<T> {
    private long generateHashCode(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            long hashCode = 0;
            for (int i = 0; i < 8; i++) {
                hashCode |= (long) (hashBytes[i] & 0xFF) << (8 * i);
            }
            return hashCode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return -1; // Error case
        }
    }

    public String factory(T key){
        if(key instanceof Long) {
            return Long.toBinaryString((Long) key);
        }
        else if(key instanceof Integer){
            return Integer.toBinaryString((Integer) key);
        }
        else if(key instanceof Double) {
            long longValue = Double.doubleToLongBits((Double) key);
            return Long.toBinaryString(longValue);
        }
        else if(key instanceof Float) {
            int intValue = Float.floatToIntBits((Float) key);
            return Integer.toBinaryString(intValue);
        }
        else if(key instanceof String) {
            long stringToLongKey = generateHashCode((String) key);
            return Long.toBinaryString(stringToLongKey);
        }
        else
            return null;
    }
}
