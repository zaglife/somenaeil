package com.main;

import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class Connection_Pool extends HttpServlet{
	@Override
	public void init() {
		driver();
		pool();
	}
	public void driver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
	}
	public void pool() {
		String url="jdbc:oracle:thin:@175.203.68.186.1521:orcl";
		String user="somenaeil";
		String pw = "byte1026";
		ConnectionFactory conn = new DriverManagerConnectionFactory(url,user,pw);
		
		PoolableConnectionFactory pool = new PoolableConnectionFactory(conn,null);
		
		GenericObjectPoolConfig<PoolableConnection> poolcon = 
				new GenericObjectPoolConfig<PoolableConnection>();
		poolcon.setTimeBetweenEvictionRunsMillis(60000L*5L);
		poolcon.setTestWhileIdle(true);
		poolcon.setMinIdle(5);
		poolcon.setMaxTotal(100);
		GenericObjectPool<PoolableConnection> conpool = 
				new GenericObjectPool<PoolableConnection>(pool,poolcon);
		pool.setPool(conpool);
		try {
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver =(PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:"); 
			driver.registerPool("somenaeil", conpool);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("커넥션 풀 실패");
		}
		
	}
}



