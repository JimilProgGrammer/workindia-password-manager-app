package com.password.manager.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {

	private static String initVec = "encrytponInitVec";
	private static String secretKey = "AESPASSWORDMANAGERSECRET";
	
	public static String encryptText(String plainText) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(initVec.getBytes("UTF-8"));
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

		byte[] encrypted = cipher.doFinal(plainText.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	}
	
	public static String decryptText(String cipherText) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(initVec.getBytes("UTF-8"));
		SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] original = cipher.doFinal(Base64.getDecoder().decode(cipherText));

		return new String(original);
	}
	
}
