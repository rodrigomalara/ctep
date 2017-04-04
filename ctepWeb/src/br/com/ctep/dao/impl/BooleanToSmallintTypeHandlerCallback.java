package br.com.ctep.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

public class BooleanToSmallintTypeHandlerCallback 
  implements TypeHandlerCallback {
  
  public static final Integer TRUE = 1;
  public static final Integer FALSE = 0;

  public Object getResult(ResultGetter getter) throws SQLException {
    Integer val = getter.getInt();
    if (val == null || val == FALSE) {
      return new Boolean(false);
    } else if (val == TRUE) {
      return new Boolean(true);
    } else {
      throw new SQLException ("O valor inesperado " + val + " foi encontrado. "
          + TRUE + ", " + FALSE + " ou null eram esperados.");
    }
  }

  public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
    Boolean b = (Boolean) parameter;
    if (b == null || b == false) {
      setter.setInt(FALSE);
    } else {
      setter.setInt(TRUE);
    }
  }

  public Object valueOf(String s) {
    Integer i;
    try {
      i = Integer.parseInt(s);
    } catch(NumberFormatException ex) {
      throw new RuntimeException ("A String " + s + " nao pode ser " +
      		"convertida para um valor numerico");
    }
    if (i == null || i == FALSE) {
      return new Boolean(false);
    } else if (TRUE.equals(i)) {
      return new Boolean(true);
    } else {
      throw new RuntimeException("O valor inesperado " + i + " foi encontrado. "
          + TRUE + ", " + FALSE + " ou null eram esperados.");
    }
  }
}