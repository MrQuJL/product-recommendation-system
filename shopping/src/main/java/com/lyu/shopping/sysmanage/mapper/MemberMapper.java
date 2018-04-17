package com.lyu.shopping.sysmanage.mapper;

import java.util.List;

import com.lyu.shopping.sysmanage.entity.Member;

/**
 * 类描述：商城会员mapper接口
 * 类名称：com.lyu.shopping.sysmanage.mapper.MemberMapper
 * @author 曲健磊
 * 2018年4月17日.下午6:46:52
 * @version V1.0
 */
public interface MemberMapper {
    
	/**
	 * 统计既存在于数据库中又存在于集合中的商城会员数目
	 * @param memberIds 页面上传过来的商城会员id集合
	 * @return
	 */
	int countMemberInList(List<Long> memberIds);
	
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
	 * 根据member来查询商城会员列表
	 * @param member 根据user中已有的信息查询商城会员列表
	 * @return
	 */
	List<Member> listMember(Member member);
	
	/**
	 * 新增商城会员
	 * @param member
	 * @return
	 */
	int saveMember(Member member);
	
	/**
	 * 根据商城会员id删除（逻辑删除）商城会员
	 * @param memberId 商城会员id
	 * @return
	 */
	int removeMember(Long memberId);
	
	/**
	 * 批量删除商城会员
	 * @param memberIds
	 * @return
	 */
	int removeMemberBatch(List<Long> memberIds);
	
	/**
	 * 修改商城会员的信息（不包括密码）
	 * @param member 要修改的商城会员
	 * @return
	 */
	int updateMember(Member member);
	
	/**
	 * 更新商城会员的密码
	 * @param memberId 商城会员id
	 * @param newPassword 新密码
	 * @return
	 */
	int updatePassword(Long memberId, String newPassword);
	
}