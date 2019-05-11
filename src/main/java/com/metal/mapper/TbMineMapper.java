package com.metal.mapper;

import com.metal.pojo.TbMine;
import com.metal.pojo.TbMineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMineMapper {
    int countByExample(TbMineExample example);

    int deleteByExample(TbMineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbMine record);

    int insertSelective(TbMine record);

    List<TbMine> selectByExample(TbMineExample example);

    TbMine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbMine record, @Param("example") TbMineExample example);

    int updateByExample(@Param("record") TbMine record, @Param("example") TbMineExample example);

    int updateByPrimaryKeySelective(TbMine record);

    int updateByPrimaryKey(TbMine record);
}