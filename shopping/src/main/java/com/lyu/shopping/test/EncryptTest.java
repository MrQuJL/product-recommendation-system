package com.lyu.shopping.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * 类描述：测试各种加密算法
 * 类名称：com.lyu.shopping.test.EncryptTest
 * @author 曲健磊
 * 2018年2月25日.下午5:39:24
 * @version V1.0
 */
public class EncryptTest {
	
	@Test
	public void testMD5() {
		String plainPsd = "123456";
		System.out.println(DigestUtils.md5Hex(plainPsd.getBytes()));
	}
	
	@Test
	public void testSha1() {
		String plainPsd = "123456";
		System.out.println(DigestUtils.sha1Hex(plainPsd.getBytes()));
	}
	
	@Test
	public void testBASE64Encode() {
		String plainPsd = "123456";
		System.out.println(Base64.encodeBase64String(plainPsd.getBytes()));
	}
	
	@Test
	public void testBASE64Decode() {
		String plainPsd = "MTIzNDU2";
		System.out.println(new String(Base64.decodeBase64(plainPsd)));
	}
	
	@Test
	public void testHexEncode() {
		String plainPsd = "123456";
		System.out.println(Hex.encodeHex(plainPsd.getBytes()));
	}
	
	@Test
	public void testHexDecode() {
		String plainPsd = "313233343536";
		try {
			System.out.println(new String(Hex.decodeHex(plainPsd.toCharArray())));
		} catch (DecoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 加密操作
	 */
	@Test
	public void testEncryptPassword() {
		String plainPsd = "123";
		// 1. 用SecureRandom生成一个随机数
		byte[] salt = new byte[8];
		SecureRandom securityRandom = new SecureRandom();
		securityRandom.nextBytes(salt);
		// 2.用Hex来对随机数进行编码
		String encodedSalt = Hex.encodeHexString(salt);
		// 3.将随机数和密码用不可逆加密算法加密1024次
		byte[] result = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			digest.update(salt);
			
			result = digest.digest(plainPsd.getBytes());
			
			for (int i = 1; i < 1024; i++) {
				digest.reset();
				result = digest.digest(result);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 4.将上一步得到的字节数组用Hex编码
		String sha1Psd = Hex.encodeHexString(result);
		// 5.将第二步和第四步得到的值拼凑
		String encryptedPsd = encodedSalt + sha1Psd;
		System.out.println(encryptedPsd);
	}
	
	/**
	 * 验证密码操作
	 */
	@Test
	public void testPsdValidator() {
		String password = "123456";
		String encryptedPsd = "de9c629a5906bf2dacebdb52e847a587a03c8fc84639c47d6c2a0614";
		byte[] result = null;
		try {
			// 1.从密码中截取加密后的盐并解码
			byte[] salt = Hex.decodeHex(encryptedPsd.substring(0, 16).toCharArray());
			// 2.将获取到的盐和输入的密码加密1024
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			digest.update(salt);
			
			result = digest.digest(password.getBytes());
			
			for (int i = 1; i < 1024; i++) {
				digest.reset();
				result = digest.digest(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3.将上一步得到的字节数组用Hex编码
		String sha1Psd = Hex.encodeHexString(result);
		// 4.将加密后的盐和第三步的结果拼凑
		String encryptPsd = encryptedPsd.substring(0, 16) + sha1Psd;
		System.out.println(encryptPsd);
	}
	
}
