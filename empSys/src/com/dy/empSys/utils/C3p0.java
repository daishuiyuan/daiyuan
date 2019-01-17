package com.dy.empSys.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0 {
	public static DataSource getDataSource() {
		 ComboPooledDataSource source=new ComboPooledDataSource();
		 return source;
	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = getDataSource().getConnection();
		return connection;
	}
	
}
