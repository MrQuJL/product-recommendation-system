package com.lyu.shopping.sysmanage.service.impl;

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
import com.lyu.shopping.sysmanage.dto.Category2DTO;
import com.lyu.shopping.sysmanage.entity.Category2;
import com.lyu.shopping.sysmanage.mapper.Category2Mapper;
import com.lyu.shopping.sysmanage.service.Category2Service;

/**
 * 类描述：二级类目服务接口的实现类
 * 类名称：com.lyu.shopping.sysmanage.service.impl.Category2ServiceImpl
 * @author 曲健磊
 * 2018年3月9日.上午9:33:53
 * @version V1.0
 */
@Service("category2Service")
public class Category2ServiceImpl implements Category2Service {

	/**
	 * 显示二级类目的标示，在数据库中对应的字段为1
	 */
	private static final Integer SHOW_CATEGORY1 = 1;
	
	/**
	 * 隐藏二级类目的标示，在数据库中对应的字段为0
	 */
	private static final Integer HIDE_CATEGORY1 = 0;
	
	@Autowired
	private Category2Mapper category2Mapper;
	
	@Override
	public Category2DTO getCategory2ById(Long category2Id) {
		// category2DTO中还包括一级类目的名称
		Category2DTO category2DTO = this.category2Mapper.getCategory2ById(category2Id);
		return category2DTO;
	}
	
	@Override
	public List<String> listAllCategory2Name() {
		List<String> category2Names = this.category2Mapper.listAllCategory2Name();
		return category2Names;
	}
	
	@Override
	public List<Category2DTO> listCategory2(Category2 category2) {
		List<Category2DTO> category2List = this.category2Mapper.listCategory2(category2);
		
		return category2List;
	}
	
	@Override
	public PageInfo<Category2DTO> listCategory2Page(Category2 category2, PageParam pageParam) {
		// 如果没有传入分页信息：页数和每页的size，则默认第一页，每页5条
		if (category2 == null) {
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
		// 查询二级类目列表
		List<Category2DTO> category2List = this.category2Mapper.listCategory2(category2);
		// 构造分页信息对象
		PageInfo<Category2DTO> pageInfo = new PageInfo<Category2DTO>(category2List);
		
		return pageInfo;
	}

	@Override
	public boolean showCategory2(Long category2Id) {
		int rows = this.category2Mapper.updateShowFlag(category2Id, SHOW_CATEGORY1);
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hideCategory2(Long category2Id) {
		int rows = this.category2Mapper.updateShowFlag(category2Id, HIDE_CATEGORY1);
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveCategory2(Category2 category2) {
		// 数据的合法性判断
		if (category2 == null || category2.getCategory2Name() == null 
			|| category2.getCategory2Name() == "") {
			return false;
		}
		
		// 设置与二级类目相关的初始化值
		category2.setGmtCreate(new Date());
		category2.setGmtModified(new Date());
		// 默认不删除，即删除字段为0
		category2.setDelFlag(0);
		
		int rows = this.category2Mapper.saveCategory2(category2);
		
		if (rows > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateCategory2(Category2 category2) {
		if (category2 == null || category2.getCategory2Id() == null) {
			return false;
		}
		// 设置修改的时间
		category2.setGmtModified(new Date());
		int rows = this.category2Mapper.updateCategory2(category2);
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeCategory2(Long category2Id) {
		if (category2Id == null) {
			return false;
		}
		
		int rows = this.category2Mapper.removeCategory2(category2Id);
		
		if (rows > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public boolean removeCategory2Batch(List<Long> category2Ids) {
		// 合法性判断
		if (category2Ids == null || category2Ids.size() == 0) {
			return false;
		}
		// 1.先查询集合中的id是否存在于数据库中,判断集合中的数据是否已经被删除
		int size = category2Ids.size();
		int rows = this.category2Mapper.countCategory2InList(category2Ids);
		if (size != rows) {
			return false;
		}
		
		// 3.批量删除集合中的二级类目
		rows = this.category2Mapper.removeCategory2Batch(category2Ids);
		if (rows != size) {
			return false;
		}
		
		return true;
	}

}
