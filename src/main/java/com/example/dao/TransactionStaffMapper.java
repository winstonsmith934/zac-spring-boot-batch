package com.example.dao;

import com.example.entity.TransactionStaff;
import com.example.entity.TransactionStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TransactionStaffMapper {
    @SelectProvider(type=TransactionStaffSqlProvider.class, method="countByExample")
    int countByExample(TransactionStaffExample example);

    @DeleteProvider(type=TransactionStaffSqlProvider.class, method="deleteByExample")
    int deleteByExample(TransactionStaffExample example);

    @Delete({
        "delete from t_staff",
        "where staff_id = #{staffId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer staffId);

    @Insert({
        "insert into t_staff (staff_id, staff_code, ",
        "staff_name, staff_name_kana, ",
        "staff_division_id, staff_mailaddress, ",
        "staff_status)",
        "values (#{staffId,jdbcType=INTEGER}, #{staffCode,jdbcType=VARCHAR}, ",
        "#{staffName,jdbcType=VARCHAR}, #{staffNameKana,jdbcType=VARCHAR}, ",
        "#{staffDivisionId,jdbcType=INTEGER}, #{staffMailaddress,jdbcType=VARCHAR}, ",
        "#{staffStatus,jdbcType=TINYINT})"
    })
    int insert(TransactionStaff record);

    @InsertProvider(type=TransactionStaffSqlProvider.class, method="insertSelective")
    int insertSelective(TransactionStaff record);

    @SelectProvider(type=TransactionStaffSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="staff_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="staff_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="staff_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="staff_name_kana", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="staff_division_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="staff_mailaddress", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="staff_status", javaType=Byte.class, jdbcType=JdbcType.TINYINT)
    })
    List<TransactionStaff> selectByExample(TransactionStaffExample example);

    @Select({
        "select",
        "staff_id, staff_code, staff_name, staff_name_kana, staff_division_id, staff_mailaddress, ",
        "staff_status",
        "from t_staff",
        "where staff_id = #{staffId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="staff_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="staff_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="staff_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="staff_name_kana", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="staff_division_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="staff_mailaddress", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="staff_status", javaType=Byte.class, jdbcType=JdbcType.TINYINT)
    })
    TransactionStaff selectByPrimaryKey(Integer staffId);

    @UpdateProvider(type=TransactionStaffSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TransactionStaff record, @Param("example") TransactionStaffExample example);

    @UpdateProvider(type=TransactionStaffSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TransactionStaff record, @Param("example") TransactionStaffExample example);

    @UpdateProvider(type=TransactionStaffSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TransactionStaff record);

    @Update({
        "update t_staff",
        "set staff_code = #{staffCode,jdbcType=VARCHAR},",
          "staff_name = #{staffName,jdbcType=VARCHAR},",
          "staff_name_kana = #{staffNameKana,jdbcType=VARCHAR},",
          "staff_division_id = #{staffDivisionId,jdbcType=INTEGER},",
          "staff_mailaddress = #{staffMailaddress,jdbcType=VARCHAR},",
          "staff_status = #{staffStatus,jdbcType=TINYINT}",
        "where staff_id = #{staffId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TransactionStaff record);
}