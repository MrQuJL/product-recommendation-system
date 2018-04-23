package com.lyu.shopping.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.entity.Member;
import com.lyu.shopping.sysmanage.mapper.MemberMapper;
import com.lyu.shopping.sysmanage.service.MemberService;
import com.lyu.shopping.util.EncryptUtils;

/**
 * 类描述：商城会员服务层接口的实现类
 * 类名称：com.lyu.shopping.sysmanage.service.impl.MemberServiceImpl
 * @author 曲健磊
 * 2018年4月17日.下午6:55:06
 * @version V1.0
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	private static final int HASH_ITERATIONS = 1024;
	
	private static final int SALT_SIZE = 8;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Long countMember() {
		Long memberNums = this.memberMapper.countMember();
		return memberNums;
	}
	
	@Override
	public Member getMemberByMemberId(Long memberId) {
		Member member = this.memberMapper.getMemberByMemberId(memberId);
		return member;
	}
	
	@Override
	public Member loginMember(String loginName, String password) {
		if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
			return null;
		}
		Member member = new Member();
		member.setLoginName(loginName);
		
		// 调用mapper去查询符合条件的用户列表
		List<Member> userList = this.memberMapper.listMember(member);
		if (userList.isEmpty()) {
			return null;
		}
		
		// 用户列表不为空则验证密码是否正确，正确则返回该用户
		Member plainUser = userList.get(0);
		String encryptedPassword = plainUser.getPassword();
		if (validatePsd(password, encryptedPassword)) {
			return plainUser;
		}
		
		return null;
	}

	@Override
	public PageInfo<Member> listMember(Member member, PageParam pageParam) {
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
		
		List<Member> memberList = this.memberMapper.listMember(member);
		
		PageInfo<Member> pageInfo = new PageInfo<Member>(memberList);
		
		return pageInfo;
	}
	
	@Override
	public List<Member> listMember(Member member) {
		List<Member> memberList = this.memberMapper.listMember(member);
		return memberList;
	}
	
	@Override
	public boolean saveMember(Member user) {
		if (user == null) return false;
		user.setPassword(this.encryptPsd(user.getPassword()));
		user.setStatus(0);
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		user.setDelFlag(0);
		
		int rows = this.memberMapper.saveMember(user);
		if (rows > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean removeMember(Long memberId) {
		int rows = this.memberMapper.removeMember(memberId);
		if (rows > 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public boolean removeMemberBatch(List<Long> memberIds) {
		if (memberIds == null || memberIds.size() == 0) {
			return false;
		}
		// 先检查集合中的memberId是否存在
		int existMemberNums = this.memberMapper.countMemberInList(memberIds);
		if (existMemberNums != memberIds.size()) {
			return false;
		}
		
		// 批量删除
		int removeSuccessNums = this.memberMapper.removeMemberBatch(memberIds);
		
		if (removeSuccessNums == existMemberNums) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean updateMember(Member member) {
		if (member == null) return false;
		if (member.getAge() == null || member.getAge() > 999 || member.getAge() < 1) {
			return false;
		}
		if (member.getMobile() == "" || !member.getMobile().matches("1[0-9]{10}") ||
			member.getMobile().length() > 11) {
			return false;
		}
		
		// 设置商城会员的修改时间
		member.setGmtModified(new Date());
		int rows = this.memberMapper.updateMember(member);
		if (rows > 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public boolean updatePassword(Long memberId, String oldPassword,
			String newPassword, String confirmPassword) {
		// 1.确定密码用户id是否为空
		if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword) || 
			StringUtils.isEmpty(confirmPassword) || memberId == null) {
			return false; 
		}
		
		// 2.确定旧密码是否正确
		String dbPassword = this.memberMapper.getMemberByMemberId(memberId).getPassword();
		boolean flag = this.validatePsd(oldPassword, dbPassword);
		if (!flag) {
			return false;
		}
		
		// 3.确定两次输入的新密码是否一致
		if (!newPassword.equals(confirmPassword)) {
			return false;
		}
		
		// 将密码加下密
		String encryptPassword = encryptPsd(newPassword);
		int rows = this.memberMapper.updatePassword(memberId, encryptPassword);
		if (rows > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String encryptPsd(String plainPsd) {
		// 1.获取随机数
		byte[] salt = EncryptUtils.generateSalt(SALT_SIZE);
		// 2.对随机数用Hex编码
		String encodedSalt = EncryptUtils.encodeHex(salt);
		// 3.将随机数和盐通过sha1算法加密
		byte[] sha1Psd = EncryptUtils.sha1(plainPsd.getBytes(), salt, HASH_ITERATIONS);
		// 4.将上一步得到的值通过Hex来编码
		String hexSha1 = new String(Hex.encodeHex(sha1Psd));
		// 5.将第二步和第四步的值拼凑
		String encryptedPsd = encodedSalt + hexSha1;
		
		return encryptedPsd;
	}

	@Override
	public boolean validatePsd(String plainPsd, String encryptedPsd) {
		boolean flag = false;
		try {
			// 1.获取密文中的盐
			byte[] salt = Hex.decodeHex(encryptedPsd.substring(0, SALT_SIZE * 2).toCharArray());
			// 2.将盐和plainPsd加密HASH_ITERATIONS次
			byte[] sha1Psd = EncryptUtils.sha1(plainPsd.getBytes(), salt, HASH_ITERATIONS);
			// 3.用Hex来编码
			String sha1Hex = new String(Hex.encodeHex(sha1Psd));
			// 4.拼凑第三步得到的值和密文中的盐
			String psd = encryptedPsd.substring(0, SALT_SIZE * 2) + sha1Hex;
			if (psd.equals(encryptedPsd)) {
				flag = true;
			}
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}
