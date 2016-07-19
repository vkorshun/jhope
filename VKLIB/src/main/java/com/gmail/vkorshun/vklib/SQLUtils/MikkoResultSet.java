package com.gmail.vkorshun.vklib.SQLUtils;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vkorshun on 04.06.2016.
 */
public class MikkoResultSet {
  private ResultSet resultSet;

  public MikkoResultSet(){
    this.resultSet = null;
  }

  public MikkoResultSet(ResultSet resultSet){
    this.resultSet = resultSet;
  }

  public ResultSet getResultSet() {
    return resultSet;
  }

  public void setResultSet(ResultSet resultSet) {
    this.resultSet = resultSet;
  }

  public String getAnsiString(String fieldName) throws SQLException, UnsupportedEncodingException {
    return  new String(resultSet.getString(fieldName).getBytes("ISO_8859_1"),"windows-1251");
  }

  public String getDosString(String fieldName) throws SQLException, UnsupportedEncodingException {
    return  new String(resultSet.getString(fieldName).getBytes("ISO_8859_1"),"cp866");
  }

  public String getRawString(String fieldName) throws SQLException, UnsupportedEncodingException {
    return  new String(resultSet.getString(fieldName).getBytes("ISO_8859_1"),"ISO_8859_1");
  }

}
