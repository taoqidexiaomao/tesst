package com.cxytiandi.encrypt.algorithm;

import com.cxytiandi.encrypt.util.AesEncryptUtils;

/**
 * Aes加密算法实现
 * 
 * @author yinjihuan
 * 
 */
public class AesEncryptAlgorithm implements EncryptAlgorithm {

	@Override
	public String encrypt(String content, String encryptKey) throws Exception {
		return AesEncryptUtils.aesEncrypt(content, encryptKey);
	}

	@Override
	public String decrypt(String encryptStr, String decryptKey) throws Exception {
		return AesEncryptUtils.aesDecrypt(encryptStr, decryptKey);
	}

	public static void main(String[] args) throws Exception {
		AesEncryptAlgorithm aesEncryptAlgorithm=new AesEncryptAlgorithm();
		aesEncryptAlgorithm.encrypt("123","2132132131231");
		aesEncryptAlgorithm.decrypt("123","2132132131231");
	}
}
