package com.sxxa.hjjczz.dao;

import com.sxxa.hjjczz.entity.THjjczzFormslistField;
import com.sxxa.hjjczz.entity.THjjczzFormslistFieldExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface THjjczzFormslistFieldMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_formslist_field
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int countByExample(THjjczzFormslistFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_formslist_field
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int deleteByExample(THjjczzFormslistFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_formslist_field
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int insert(THjjczzFormslistField record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_formslist_field
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int insertSelective(THjjczzFormslistField record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_formslist_field
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    List<THjjczzFormslistField> selectByExample(THjjczzFormslistFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_formslist_field
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int updateByExampleSelective(@Param("record") THjjczzFormslistField record, @Param("example") THjjczzFormslistFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hjjczz_formslist_field
     *
     * @mbggenerated Thu Mar 04 17:03:32 CST 2021
     */
    int updateByExample(@Param("record") THjjczzFormslistField record, @Param("example") THjjczzFormslistFieldExample example);
}