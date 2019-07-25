package com.idowran.utils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DesUtils {
	/**
	 * 基于java的DES算法
	 * 生成DES密钥
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getKeyDES() throws NoSuchAlgorithmException {
		// 获取密钥生成器的实例
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(56);	// 密钥为56位
		// 生成DES算法的密钥(每次生成的都不同)
		SecretKey key = keyGen.generateKey();
		// 编码为BASE64的字符串，为了方便存储
		return Base64Utils.byte2base64(key.getEncoded());
	}
	
	/**
	 * 将密钥字符串转换为SecretKey对象
	 * @param base64Key
	 * @return
	 * @throws IOException
	 */
	public static SecretKey loadKeyDES(String base64Key) throws IOException {
		byte[] bytes = Base64Utils.base642byte(base64Key);
		SecretKey key = new SecretKeySpec(bytes, "DES");
		return key;
	}
	
	/**
	 * DES加密
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptDES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
	
	/**
	 * DES加密
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception 
	 */
	public static byte[] decryptDES(byte[] source, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		return bytes;
	}
}
