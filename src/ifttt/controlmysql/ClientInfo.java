package ifttt.controlmysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import java.util.ArrayList;

import ifttt.connectmysql.ConnectDB;
import ifttt.types.Client;

public class ClientInfo {
	
	private Connection conn = null;
	
	public ClientInfo(){
		super();
	}
	//login
	public boolean login(Client client){
		boolean flag  = false;
		String sql = "SELECT * FROM client AS C WHERE C.CName=? AND C.CPassword=?";
		conn = ConnectDB.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, client.getCName());
			stmt.setString(2, client.getCPassword());
			rs = stmt.executeQuery();
			while(rs.next()){
				flag = true;
			}
			conn.setAutoCommit(true);
			stmt.close();
			rs.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.login roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean findClient(String username){
		boolean flag  = false;
		String sql = "SELECT * FROM client WHERE CName=?";
		conn = ConnectDB.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			while(rs.next()){
				flag = true;
			}
			conn.setAutoCommit(true);
			stmt.close();
			rs.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.findClient roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
	//register client
	public boolean addClient(Client client){
		boolean flag  = false;
		Client clientTemp = new Client(client.getCName(),client.getCPassword());
		String sql = "INSERT INTO client(CName,CPassword,CBalance,CLevel) " +
				"VALUES (?,?,?,?)";
		conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(0, clientTemp.getCNO());
			pstmt.setString(1, clientTemp.getCName());
			pstmt.setString(2, clientTemp.getCPassword());
			pstmt.setDouble(3, 100);//初始金额为100RMB
			pstmt.setDouble(4, 0);//初始积分为0
			if(pstmt.executeUpdate() > 0){
				flag = true;
			}
			conn.setAutoCommit(true);
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.addClient roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return flag;
	}
	//client number
	public int clientNum(){
		int count=0;
		conn = ConnectDB.connect();
		String sql = "SELECT COUNT(*) FROM client";
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
				System.out.println("ClientInfo.clientNum roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}
	//view individual information by user name
	public Client viewIndividualInfo(String usr){
		Client client = new Client();
		String sql = "SELECT * FROM client WHERE CName =" + usr;
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				client.setCNO(rs.getInt(1));
				client.setCName(rs.getString(2));
				client.setCPassword(rs.getString(3));
				client.setCBalance(rs.getDouble(4));
				client.setCLevel(rs.getDouble(5));
			}
			conn.setAutoCommit(true);
			stmt.close();
			rs.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.viewIndividualInfo roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return client;
	}
	//view individual information
	public Client viewIndividualInfo(int CNO){
		Client client = new Client();
		String sql = "SELECT * FROM client WHERE CNO =" + CNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				client.setCNO(rs.getInt(1));
				client.setCName(rs.getString(2));
				client.setCPassword(rs.getString(3));
				client.setCBalance(rs.getDouble(4));
				client.setCLevel(rs.getDouble(5));
			}
			conn.setAutoCommit(true);
			stmt.close();
			rs.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.viewIndividualInfo roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return client;
	}
	//change client information
	public boolean alterIndividualInfo(Client client){
		boolean flag = false;
		String sql = "UPDATE client SET CPassword=? WHERE CNO=?";
		conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(0, client.getCPassword());
			pstmt.setInt(1, client.getCNO());
			if(pstmt.executeUpdate() > 0){
				flag = true;
			}
			conn.setAutoCommit(true);
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.alterIndividualInfo roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return flag;
	}
	//all client information
	public ArrayList<Client> allClient(){
		ArrayList<Client> list = new ArrayList<Client>();
		String sql = "SELECT * FROM client";
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				Client temp = new Client();
				temp.setCNO(rs.getInt(i++));
				temp.setCName(rs.getString(i++));
				temp.setCPassword(rs.getString(i++));
				temp.setCBalance(rs.getDouble(i++));
				temp.setCLevel(rs.getDouble(i++));
				list.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.alterIndividualInfo roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return list;
	}
}
