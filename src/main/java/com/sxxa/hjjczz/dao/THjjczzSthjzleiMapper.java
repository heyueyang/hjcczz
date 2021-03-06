package com.sxxa.hjjczz.dao;

import com.sxxa.hjjczz.entity.THjjczzSthjzlei;
import com.sxxa.hjjczz.entity.THjjczzSthjzleiExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface THjjczzSthjzleiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int countByExample(THjjczzSthjzleiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int deleteByExample(THjjczzSthjzleiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int insert(THjjczzSthjzlei record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int insertSelective(THjjczzSthjzlei record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    List<THjjczzSthjzlei> selectByExample(THjjczzSthjzleiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int updateByExampleSelective(@Param("record") THjjczzSthjzlei record, @Param("example") THjjczzSthjzleiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_sthjzlei
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int updateByExample(@Param("record") THjjczzSthjzlei record, @Param("example") THjjczzSthjzleiExample example);
}