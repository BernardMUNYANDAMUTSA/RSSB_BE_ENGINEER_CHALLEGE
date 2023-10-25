package com.tekana.ewallet.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PasswordEncryption {
	
	public static String encryptPassword(String password) {
        try {
            // Create an MD5 hash generator
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convert the password to a byte array
            byte[] passwordBytes = password.getBytes();

            // Generate the MD5 hash
            byte[] digest = md.digest(passwordBytes);

            // Convert the byte array to a hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle any errors related to the NoSuchAlgorithmException
            throw new RuntimeException("Error encrypting password", e);
        }
	}
}
