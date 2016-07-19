package com.gmail.vkorshun.DAO;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by vkorshun on 28.06.2016.
 */
public class BaseDAO {
  final static Logger logger = Logger.getLogger(BaseDAO.class);

  public BaseDAO(){
  }

  protected static PlatformTransactionManager transactionManager = new org.springframework.jdbc.datasource.DataSourceTransactionManager();


  public static DataSource getDataSource() {
    DataSource datasource = null;
    try {
      Context initialContext = new InitialContext();
      datasource = (DataSource) initialContext.lookup("java:jboss/datasources/HopeDS");
      //datasource.setConnectionProperties(props);
      return datasource;
    } catch (Exception ex) {
      logger.error(ex);
      return getTestDataSource();
    }
  }

  public static DataSource getTestDataSource()  {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    try {
      Class.forName("org.firebirdsql.jdbc.FBDriver");
      dataSource.setDriverClassName(System.getProperty("hope.connection.driver"));
      dataSource.setUrl(System.getProperty("hope.connection.url"));
//      dataSource.setUsername(System.getProperty("hope.connection.user"));
//      dataSource.setUsername(System.getProperty("hope.connection.role"));
//      dataSource.setPassword(System.getProperty("hope.connection.password"));
      Properties props = new Properties();
      props.setProperty("user", System.getProperty("hope.connection.user"));
      props.setProperty("password", System.getProperty("hope.connection.password"));
      props.setProperty("encoding", "UNICODE_FSS");
//      props.setProperty("roleName","RHOPE");
      dataSource.setConnectionProperties(props);
    } catch (Exception ex) {
      logger.error(ex,ex);
    }
    return dataSource;
  }

  public static String getObjectName(BigDecimal id){
    JdbcTemplate jdbcTemplate = new JdbcTemplate(BaseDAO.getDataSource());
    List<String> result =jdbcTemplate.query("SELECT name FROM objects WHERE idobject=? ",
        new Object[]{id}, new RowMapper<String>() {
          @Override
          public String mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getString("name");
          }
        });
    return result.size()==0 ? null : result.get(0);
  }

}
