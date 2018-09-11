package com.test.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	/**
	 * ���߳��л�ȡ����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		//���߳��л�ȡconneciton
		Connection conn = tl.get();
		if(conn==null){
			conn=ds.getConnection();
			//�͵�ǰ�̰߳�
			tl.set(conn);
		}
		return conn;
	}

	// ��ȡ����Դ
	public static DataSource getDataSource() throws PropertyVetoException {
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setUser("root");
		ds.setPassword("root");
		ds.setJdbcUrl("jdbc:mysql://47.100.50.104:3306/stu?useUnicode=true&characterEncoding=UTF-8");
		ds.setInitialPoolSize(10);
		ds.setMaxIdleTime(30);
		ds.setMaxPoolSize(100);
		ds.setMinPoolSize(10);
		ds.setMaxStatements(200);
		return ds;
	}

	// �ͷ���Դ
	public static void closeResource( Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
	}
	
	// �ͷ���Դ
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResource(st, rs);
		closeConn(conn);
	}

	// �ͷ� connection
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				//���߳̽��
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	// �ͷ� statement ctrl + shift + f ��ʽ������
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}
	}

	// �ͷŽ����
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
	
	
	//��������
	public static void startTransaction() throws SQLException{
		getConnection().setAutoCommit(false);
	}
	
	/**
	 * �����ύ���ͷ�����
	 */
	public static void commitAndClose(){
		Connection conn = null;
		try {
			conn=getConnection();
			//�����ύ
			conn.commit();
			//�ر���Դ
			conn.close();
			//����涨
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����ع����ͷ���Դ
	 */
	public static void rollbackAndClose(){
		Connection conn = null;
		try {
			conn=getConnection();
			//����ع�
			conn.rollback();
			//�ر���Դ
			conn.close();
			//����涨
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
