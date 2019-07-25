package com.idowran.utils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AesUtils {
	/**
	 * 生成AES密钥
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String getKeyAES() throws NoSuchAlgorithmException  {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey key = keyGen.generateKey();
		return Base64Utils.byte2base64(key.getEncoded());
	}
	/**
	 * 将密钥字符串转换为SecretKey对象
	 * @param base64Key
	 * @return
	 * @throws IOException
	 */
	public static SecretKey loadKeyAES(String base64Key) throws IOException  {
		byte[] bytes = Base64Utils.base642byte(base64Key);
		SecretKey key = new SecretKeySpec(bytes, "AES");
		return key;
	}
	
	/**
	 * AES加密
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptAES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
	
	/**
	 * AES解密
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptAES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
}
