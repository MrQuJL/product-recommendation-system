package com.lyu.shopping.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.dto.Category1DTO;
import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.mapper.Category1Mapper;
import com.lyu.shopping.sysmanage.mapper.Category2Mapper;
import com.lyu.shopping.sysmanage.service.Category1Service;

/**
 * 类描述：一级类目服务接口的实现类
 * 类名称：com.lyu.shopping.sysmanage.service.impl.Category1ServiceImpl
 * @author 曲健磊
 * 2018年3月4日.下午8:56:46
 * @version V1.0
 */
@Service("category1Service")
public class Category1ServiceImpl implements Category1Service {

	/**
	 * 显示一级类目的标示，在数据库中对应的字段为1
	 */
	private static final Integer SHOW_CATEGORY1 = 1;
	
	/**
	 * 隐藏一级类目的标示，在数据库中对应的字段为0
	 */
	private static final Integer HIDE_CATEGORY1 = 0;
	
	/**
	 * 是否是因为一级类目下有子类目而导致的删除失败，true表示由子类目，false表示无子类目
	 */
	public static boolean childFlag = false;
	
	@Autowired
	private Category1Mapper category1Mapper;
	
	@Autowired
	private Category2Mapper category2Mapper;
	
	@Override
	public List<String> listAllCategory1Name() {
		List<String> category1Names = this.category1Mapper.listAllCategory1Name();
		return category1Names;
	}
	
	@Override
	public Category1 getCategory1ById(Long category1Id) {
		
		Category1 category1 = this.category1Mapper.getCategory1ById(category1Id);
		
		return category1;
	}
	
	@Override
	public List<Category1> listCategory1(Category1 category1) {
		
		// 查询一级类目列表
		List<Category1> category1List = this.category1Mapper.listCategory1(category1);
		
		return category1List;
	}
	
	@Override
	public List<Category1DTO> listCategory1DTO(Category1 category1) {
		
		List<Category1DTO> category1DTOList = this.category1Mapper.listCategory1DTO(category1);
		
		return category1DTOList;
	}
	
	@Override
	public PageInfo<Category1> listCategory1Page(Category1 category1, PageParam pageParam) {
		// 如果没有传入分页信息：页数和每页的size，则默认第一页，每页5条
		if (category1 == null) {
			return null;
		}
		if (pageParam == null || pageParam.getPageNo() == null ||
			pageParam.getPageSize() == null) {
			pageParam = new PageParam();
			pageParam.setPageNo(1);
			pageParam.setPageSize(5);
		}
		
		// 开启分页
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
		// 查询一级类目列表
		List<Category1> category1List = this.category1Mapper.listCategory1(category1);
		// 构造分页信息对象
		PageInfo<Category1> pageInfo = new PageInfo<Category1>(category1List);
		
		return pageInfo;
	}

	@Override
	public boolean showCategory1(Long category1Id) {
		int rows = this.category1Mapper.updateShowFlag(category1Id, SHOW_CATEGORY1);
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hideCategory1(Long category1Id) {
		int rows = this.category1Mapper.updateShowFlag(category1Id, HIDE_CATEGORY1);
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveCategory1(Category1 category1) {
		// 数据的合法性判断
		if (category1 == null || category1.getCategory1Name() == null 
			|| category1.getCategory1Name() == "") {
			return false;
		}
		
		// 设置与一级类目相关的初始化值
		category1.setGmtCreate(new Date());
		category1.setGmtModified(new Date());
		// 默认不删除，即删除字段为0
		category1.setDelFlag(0);
		
		int rows = this.category1Mapper.saveCategory1(category1);
		
		if (rows > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateCategory1(Category1 category1) {
		if (category1 == null || category1.getCategory1Id() == null) {
			return false;
		}
		// 设置修改的时间
		category1.setGmtModified(new Date());
		int rows = this.category1Mapper.updateCategory1(category1);
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public List<Long> hasSubCategory2(List<Long> category1Ids) {
		List<Long> hitCategory1List = new ArrayList<Long>();
		// 合法性判断
		if (category1Ids == null || category1Ids.size() == 0) {
			return null;
		}
		
		for (Long category1Id : category1Ids) {
			int rows = this.category2Mapper.countCategory2UnderCategory1(category1Id);
			if (rows > 0) {
				hitCategory1List.add(category1Id);
			}
		}
		
		return hitCategory1List;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean removeCategory1(Long category1Id) {
		// 默认没有子类目
		Category1ServiceImpl.childFlag = false;
		
		if (category1Id == null) {
			return false;
		}
		// 在删除一级类目之前先判断一级类目下是否有子类目
		int category2Num = this.category2Mapper.countCategory2UnderCategory1(category1Id);
		if (category2Num > 0) {
			// 存在二级类目则不能删除一级类目
			Category1ServiceImpl.childFlag = true;
			return false;
		}
		
		int rows = this.category1Mapper.removeCategory1(category1Id);
		
		if (rows > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public boolean removeCategory1Batch(List<Long> category1Ids) {
		// 合法性判断
		if (category1Ids == null || category1Ids.size() == 0) {
			return false;
		}
		// 1.先查询集合中的id是否存在于数据库中,判断集合中的数据是否已经被删除
		int size = category1Ids.size();
		int rows = this.category1Mapper.countCategory1InList(category1Ids);
		if (size != rows) {
			return false;
		}
		
		// 2.批量删除集合中的一级类目
		rows = this.category1Mapper.removeCategory1Batch(category1Ids);
		if (rows != size) {
			return false;
		}
		
		return true;
	}

}
