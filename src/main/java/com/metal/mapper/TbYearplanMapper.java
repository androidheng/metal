package com.metal.mapper;

import com.metal.pojo.TbYearplan;
import com.metal.pojo.TbYearplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbYearplanMapper {
    int countByExample(TbYearplanExample example);

    int deleteByExample(TbYearplanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbYearplan record);

    int insertSelective(TbYearplan record);

    List<TbYearplan> selectByExample(TbYearplanExample example);

    TbYearplan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbYearplan record, @Param("example") TbYearplanExample example);

    int updateByExample(@Param("record") TbYearplan record, @Param("example") TbYearplanExample example);

    int updateByPrimaryKeySelective(TbYearplan record);

    int updateByPrimaryKey(TbYearplan record);
}