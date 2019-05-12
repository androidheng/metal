package com.metal.mapper;

import com.metal.pojo.TbData;
import com.metal.pojo.TbDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDataMapper {
    int countByExample(TbDataExample example);

    int deleteByExample(TbDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbData record);

    int insertSelective(TbData record);

    List<TbData> selectByExample(TbDataExample example);

    TbData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbData record, @Param("example") TbDataExample example);

    int updateByExample(@Param("record") TbData record, @Param("example") TbDataExample example);

    int updateByPrimaryKeySelective(TbData record);

    int updateByPrimaryKey(TbData record);
    
    List<TbData> findPeiData(@Param("mid") Integer mid, @Param("wid") Integer wid);
    List<TbData> findYunDay(@Param("date") String date);
    List<TbData> findYunMonth(@Param("date") String date);
    List<TbData> findYunYear(@Param("date") String date);
    List<TbData> findDay(@Param("date") String date,@Param("mid") Integer mid, @Param("wid") Integer wid);
    List<TbData> findMonth(@Param("date") String date,@Param("mid") Integer mid, @Param("wid") Integer wid);
    List<TbData> findYear(@Param("date") String date,@Param("mid") Integer mid, @Param("wid") Integer wid);
    
    
}