package com.zwc.Boke.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zwc.Boke.pojo.User;
import com.zwc.Boke.sql.UserSqlProvider;
	/**
	 * Mapper通用接口
	 * @author Administrator
	 * @param <T> 类型
	 * @param <E> 表名
	 * @param <PK> 主键
	 */
public interface Mapper<T,TName extends String,PK> {	
	
	/**
	 * 查询所有列表
	 * @param tableName 表名
	 * @return
	 */
	@Select("select * from ${tableName}")	
	public List<T> list(@Param("tableName")TName tableName);
	

	/**
	 * 根据主键查询详情
	 * @param tableName 表名
	 * @param id 主键
	 * @return
	 */
	@Select("select * from ${tableName} where id = #{id}")
	public T findById(@Param("tableName")TName tableName,@Param("id")PK id);

	
	@InsertProvider(method="insert",type=UserSqlProvider.class)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(User user);
	
}
