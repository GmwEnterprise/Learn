package cn.edu.cqut.myapp.domain.typehandler;

import cn.edu.cqut.myapp.enums.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

  @Override
  public void setParameter(PreparedStatement p, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
    p.setInt(i, sexEnum.getIndex());
  }

  @Override
  public SexEnum getResult(ResultSet resultSet, String s) throws SQLException {
    return SexEnum.getSexEnum(resultSet.getInt(s));
  }

  @Override
  public SexEnum getResult(ResultSet resultSet, int i) throws SQLException {
    return SexEnum.getSexEnum(resultSet.getInt(i));
  }

  @Override
  public SexEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
    return SexEnum.getSexEnum(callableStatement.getInt(i));
  }
}
