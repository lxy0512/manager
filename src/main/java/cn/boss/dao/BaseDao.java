package cn.boss.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	public static Connection getConn(){
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/news");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(ResultSet rs, Statement stat){
		try {
			if(rs != null)
				rs.close();
			if(stat != null)
				stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
