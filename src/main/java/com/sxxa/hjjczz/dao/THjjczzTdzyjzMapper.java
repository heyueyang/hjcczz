package com.sxxa.hjjczz.dao;

import com.sxxa.hjjczz.entity.THjjczzTdzyjz;
import com.sxxa.hjjczz.entity.THjjczzTdzyjzExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface THjjczzTdzyjzMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tdzyjz
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int countByExample(THjjczzTdzyjzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tdzyjz
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int deleteByExample(THjjczzTdzyjzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tdzyjz
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int insert(THjjczzTdzyjz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tdzyjz
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int insertSelective(THjjczzTdzyjz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tdzyjz
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    List<THjjczzTdzyjz> selectByExample(THjjczzTdzyjzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tdzyjz
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int updateByExampleSelective(@Param("record") THjjczzTdzyjz record, @Param("example") THjjczzTdzyjzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_tdzyjz
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int updateByExample(@Param("record") THjjczzTdzyjz record, @Param("example") THjjczzTdzyjzExample example);
}