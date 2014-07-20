package ifttt.controlmysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import java.util.ArrayList;

import ifttt.connectmysql.ConnectDB;
import ifttt.types.*;

public class MessageInfo {
	
	private Connection conn = null;
	
	public MessageInfo(){
		super();
	}
	//view client CNO 's message
	public ArrayList<Message> adminViewAllMessages(int MDesNO){
		ArrayList<Message> messageArray = new ArrayList<Message>();
		String sql = "SELECT * FROM message WHERE MDes=" + MDesNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				Message temp = new Message();
				temp.setMNO(rs.getInt(i++));
				@SuppressWarnings("unused")
				int visible = rs.getInt(i++);
				temp.setMSrc(rs.getInt(i++));
				temp.setMDes(rs.getInt(i++));
				temp.setMDate(rs.getString(i++));
				temp.setMContent(rs.getString(i++));
				messageArray.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("MessageInfo.allMessages roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return messageArray;
	}
	
	public ArrayList<Message> viewAllMessages(){
		ArrayList<Message> messageArray = new ArrayList<Message>();
		String sql = "SELECT * FROM message ";
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				Message temp = new Message();
				temp.setMNO(rs.getInt(i++));
				@SuppressWarnings("unused")
				int visible = rs.getInt(i++);
				temp.setMSrc(rs.getInt(i++));
				temp.setMDes(rs.getInt(i++));
				temp.setMDate(rs.getString(i++));
				temp.setMContent(rs.getString(i++));
				messageArray.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("MessageInfo.viewAllMessages roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return messageArray;
	}
	
	public ArrayList<Message> clientViewAllMessages(int MDesNO){
		ArrayList<Message> messageArray = new ArrayList<Message>();
		String sql = "SELECT * FROM message WHERE MDes=" + MDesNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				Message temp = new Message();
				temp.setMNO(rs.getInt(i++));
				int visible = rs.getInt(i++);
				temp.setMSrc(rs.getInt(i++));
				temp.setMDes(rs.getInt(i++));
				temp.setMDate(rs.getString(i++));
				temp.setMContent(rs.getString(i++));
				if(visible == 1)
					messageArray.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("MessageInfo.allMessages roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return messageArray;
	}
	//insert message
	public boolean newMessage(Message mes){
		boolean flag = false;
		conn = ConnectDB.connect();
		String sql = "INSERT INTO message(MVisible,MSrc,MDes,MDate,MContent) " +
				"VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(0, transaction.getTNO());
			pstmt.setInt(0, 1);
			pstmt.setInt(1, mes.getMSrc());
			pstmt.setInt(2, mes.getMDes());
			pstmt.setString(3, mes.getMDate());
			pstmt.setString(4, mes.getMContent());
			if(pstmt.executeUpdate() > 0)
				flag = true;
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("MessageInfo.newMessage roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
		return flag;
	}	
	//view message
	public Message getMessage(int MNO){
		Message messageTemp = new Message();
		String sql = "SELECT * FROM message WHERE MNO=" + MNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				messageTemp.setMNO(rs.getInt(i++));
				@SuppressWarnings("unused")
				int visible = rs.getInt(i++);
				messageTemp.setMSrc(rs.getInt(i++));
				messageTemp.setMDes(rs.getInt(i++));
				messageTemp.setMDate(rs.getString(i++));
				messageTemp.setMContent(rs.getString(i++));
				System.out.println("MessageInfo.getMessage:fetch message successfully");
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("MessageInfo.getMessages roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return messageTemp;
	}
	//client delete message
	public boolean clientDeleteMessage(int MNO){
		boolean flag = false;
		String sql = "UPDATE message SET MVisible=0 WHERE MNO=" + MNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0)
				flag = true;
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("MessageInfo.clientDeleteMessages roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return flag;
	}
	//admin delete message
	public boolean adminDeleteMessage(int MNO){
		boolean flag = false;
		String sql = "DELETE FROM message WHERE MNO=" + MNO;
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
				System.out.println("MessageInfo.adminDeleteMessage roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
}
