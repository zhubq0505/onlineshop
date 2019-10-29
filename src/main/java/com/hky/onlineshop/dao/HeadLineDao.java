package java.com.hky.onlineshop.dao;

import java.com.hky.onlineshop.entity.HeadLine;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HeadLineDao {
	/**
	 * 根据查询条件查询头条列表
	 * @param headLineCondition
	 * @return
	 */
	List<HeadLine> queryHeadLineList(@Param("headLineCondition") HeadLine headLineCondition);
}
