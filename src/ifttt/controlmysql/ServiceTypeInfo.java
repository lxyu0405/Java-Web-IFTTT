package ifttt.controlmysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import java.util.ArrayList;

import ifttt.connectmysql.ConnectDB;
import ifttt.types.*;

public class ServiceTypeInfo {
	private Connection conn = null;
	public ServiceTypeInfo(){
		super();
	}
	//service number
	public int serviceNum(){
		int count=0;
		conn = ConnectDB.connect();
		String sql = "SELECT COUNT(*) FROM servicetype";
		try{
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				count = rs.getInt(1) ;
			}
			conn.setAutoCommit(true);
			stmt.close() ;
			rs.close() ;
		}catch(Exception e){
			try {
				conn.rollback();
				System.out.println("ServiceTypeInfo.serviceNum roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}
	//insert
	public boolean newService(ServiceType serv){
		boolean flag = false;
		conn = ConnectDB.connect();
		String sql = "INSERT INTO servicetype(TypeName,TypePrice) " +
				"VALUES(?,?)";
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(0, transaction.getTNO());
			pstmt.setString(0, serv.getServiceName());
			pstmt.setDouble(1, serv.getServicePrice());
			if(pstmt.executeUpdate() > 0)
				flag = true;
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("ServiceTypeInfo.newService roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
		return flag;
	}
	//view
	public ArrayList<ServiceType> allService(){
		ArrayList<ServiceType> serviceTypeArray = new ArrayList<ServiceType>();
		String sql = "SELECT * FROM servicetype";
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				ServiceType temp = new ServiceType();
				temp.setTypeNO(rs.getInt(i++));
				temp.setServiceName(rs.getString(i++));
				temp.setServicePrice(rs.getDouble(i++));
				serviceTypeArray.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ServiceTypeInfo.allServices roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return serviceTypeArray;
	}
	//change
	public boolean changeServiceInfo(ServiceType serv){
		boolean flag = false;
		String sql = "UPDATE servicetype SET TypeName=?,TypePrice=? WHERE TypeNO=?";
		conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(0, serv.getServiceName());
			pstmt.setDouble(1, serv.getServicePrice());
			pstmt.setInt(2, serv.getTypeNO());
			if(pstmt.executeUpdate() > 0)
				flag = true;
			conn.setAutoCommit(true);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("ServiceTypeInfo.changeServiceInfo roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
	//delete
	public boolean deleteService(int TypeNO){
		boolean flag = false;
		String sql = "DELETE FROM servicetype WHERE TypeNO=" + TypeNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0)
				flag = true;
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("deleteService roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
}
