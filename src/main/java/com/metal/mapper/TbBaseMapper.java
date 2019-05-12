package com.metal.mapper;

import com.metal.pojo.TbBase;
import com.metal.pojo.TbBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBaseMapper {
    int countByExample(TbBaseExample example);

    int deleteByExample(TbBaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbBase record);

    int insertSelective(TbBase record);

    List<TbBase> selectByExample(TbBaseExample example);

    TbBase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbBase record, @Param("example") TbBaseExample example);

    int updateByExample(@Param("record") TbBase record, @Param("example") TbBaseExample example);

    int updateByPrimaryKeySelective(TbBase record);

    int updateByPrimaryKey(TbBase record);

	List<TbBase> findHistoryData(@Param("mid") Integer mid, @Param("date")  String date);
	List<TbBase> findEveryMonth( @Param("date")  String date,@Param("mid") Integer mid);
}