package com.lyu.shopping.sysmanage.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.entity.Member;

/**
 * 类描述：处理商城会员的服务层接口
 * 类名称：com.lyu.shopping.sysmanage.service.MemberService
 * @author 曲健磊
 * 2018年4月17日.下午6:53:40
 * @version V1.0
 */
public interface MemberService {

	/**
	 * 统计所有商城会员的数目(未删除的)
	 * @return
	 */
	Long countMember();
	
	/**
	 * 通过商城会员id获取商城会员的详细信息
	 * @param memberId 商城会员id
	 * @return
	 */
	Member getMemberByMemberId(Long memberId);
	
	/**
	 * 验证用户是否存在，若存在，继续验证密码是否匹配
	 * @param loginName 用户登录名称
	 * @param password 密码
	 * @return 返回验证成功的用户信息
	 */
	Member loginMember(String loginName, String password);
	
	/**
	 * 根据用户已知信息分页查询商城会员列表
	 * @param member 用户信息
	 * @param pageParam 分页对象
	 * @return 包含用户信息的PageInfo对象
	 */
	PageInfo<Member> listMember(Member member, PageParam pageParam);
	
	/**
	 * 根据已有信息查询商城会员列表
	 * @param member
	 * @return 符合条件的商城会员列表
	 */
	List<Member> listMember(Member member);
	
	/**
	 * 新增管理严
	 * @param user 待新增的商城会员
	 * @return
	 */
	boolean saveMember(Member member);
	
	/**
	 * 根据商城会员id删除（逻辑删除）商城会员
	 * @param memberId 商城会员id
	 * @return
	 */
	boolean removeMember(Long memberId);
	
	/**
	 * 批量删除商城会员
	 * @param memberIds 商城会员id集合
	 * @return
	 */
	boolean removeMemberBatch(List<Long> memberIds);
	
	/**
	 * 修改商城会员信息（不包括密码）
	 * @param member 要修改的商城会员
	 * @return
	 */
	boolean updateMember(Member member);
	
	/**
	 * 修改商城会员密码
	 * @param memberId 商城会员id
	 * @param newPassword 新密码
	 * @return 修改是否成功
	 */
	boolean updatePassword(Long memberId, String oldPassword,
		String newPassword, String confirmPassword);
	
	/**
	 * 采用sha1加密算法将密码加密
	 * @param plainPsd 未经过加密的密码
	 * @return 加密后的面膜
	 */
	String encryptPsd(String plainPsd);

	/**
	 * 验证密码是否正确
	 * @param plainPsd 未加密的密码
	 * @param encryptedPsd 加密之后的密码
	 * @return 密码是否正确 true 正确 false 错误
	 */
	boolean validatePsd(String plainPsd, String encryptedPsd);
	
}
