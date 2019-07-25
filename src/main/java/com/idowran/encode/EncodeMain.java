package com.idowran.encode;

import com.idowran.utils.HashUtils;

public class EncodeMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String encodeString = HashUtils.sha1("admin");
		System.out.println(encodeString);
	}
}
