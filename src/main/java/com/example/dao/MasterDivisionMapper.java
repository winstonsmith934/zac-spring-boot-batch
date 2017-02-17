package com.example.dao;

import com.example.entity.MasterDivision;
import com.example.entity.MasterDivisionExample;
import java.util.Date;
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

public interface MasterDivisionMapper {
    @SelectProvider(type=MasterDivisionSqlProvider.class, method="countByExample")
    int countByExample(MasterDivisionExample example);

    @DeleteProvider(type=MasterDivisionSqlProvider.class, method="deleteByExample")
    int deleteByExample(MasterDivisionExample example);

    @Delete({
        "delete from m_division",
        "where division_id = #{divisionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer divisionId);

    @Insert({
        "insert into m_division (division_id, division_name, ",
        "create_time, update_time)",
        "values (#{divisionId,jdbcType=INTEGER}, #{divisionName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(MasterDivision record);

    @InsertProvider(type=MasterDivisionSqlProvider.class, method="insertSelective")
    int insertSelective(MasterDivision record);

    @SelectProvider(type=MasterDivisionSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="division_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="division_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<MasterDivision> selectByExample(MasterDivisionExample example);

    @Select({
        "select",
        "division_id, division_name, create_time, update_time",
        "from m_division",
        "where division_id = #{divisionId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="division_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="division_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    MasterDivision selectByPrimaryKey(Integer divisionId);

    @UpdateProvider(type=MasterDivisionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MasterDivision record, @Param("example") MasterDivisionExample example);

    @UpdateProvider(type=MasterDivisionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MasterDivision record, @Param("example") MasterDivisionExample example);

    @UpdateProvider(type=MasterDivisionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MasterDivision record);

    @Update({
        "update m_division",
        "set division_name = #{divisionName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where division_id = #{divisionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MasterDivision record);
}