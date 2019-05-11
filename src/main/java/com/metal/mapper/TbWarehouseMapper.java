package com.metal.mapper;

import com.metal.pojo.TbWarehouse;
import com.metal.pojo.TbWarehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWarehouseMapper {
    int countByExample(TbWarehouseExample example);

    int deleteByExample(TbWarehouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbWarehouse record);

    int insertSelective(TbWarehouse record);

    List<TbWarehouse> selectByExample(TbWarehouseExample example);

    TbWarehouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbWarehouse record, @Param("example") TbWarehouseExample example);

    int updateByExample(@Param("record") TbWarehouse record, @Param("example") TbWarehouseExample example);

    int updateByPrimaryKeySelective(TbWarehouse record);

    int updateByPrimaryKey(TbWarehouse record);
}