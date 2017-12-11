package com.xianyo.util.scenicmodule.dao.mapper;

import com.xianyo.util.scenicmodule.dao.pojo.ScenicData;
import com.xianyo.util.scenicmodule.dao.pojo.ScenicDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScenicDataMapper {
    List<ScenicData> selectAll();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int countByExample(ScenicDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int deleteByExample(ScenicDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int deleteByPrimaryKey(Long scenicid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int insert(ScenicData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int insertSelective(ScenicData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    List<ScenicData> selectByExample(ScenicDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    ScenicData selectByPrimaryKey(Long scenicid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int updateByExampleSelective(@Param("record") ScenicData record, @Param("example") ScenicDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int updateByExample(@Param("record") ScenicData record, @Param("example") ScenicDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int updateByPrimaryKeySelective(ScenicData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenicinfo_
     *
     * @mbggenerated Wed Sep 20 12:56:34 CST 2017
     */
    int updateByPrimaryKey(ScenicData record);
}