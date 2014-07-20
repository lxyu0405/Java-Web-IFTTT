package ifttt.controlmysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import java.util.ArrayList;

import ifttt.connectmysql.ConnectDB;
import ifttt.types.*;

public class TaskInfo {
	private Connection conn = null;
	
	public TaskInfo(){
		super();
	}
	
	//admin:client CNO's tasks
	public ArrayList<Task> adminViewAllTasks(int TCNO){
		ArrayList<Task> taskArray = new ArrayList<Task>();
		String sql = "SELECT * FROM task WHERE TCNO=" + TCNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				Task temp = new Task();
				temp.setTNO(rs.getInt(i++));
				temp.setTCNO(rs.getInt(i++));
				@SuppressWarnings("unused")
				int visible = rs.getInt(i++);
				temp.setTaskName(rs.getString(i++));
				temp.setThisType(rs.getInt(i++));
				temp.setDate(rs.getString(i++));
				temp.setSrcID(rs.getString(i++));
				temp.setSrcPassword(rs.getString(i++));
				temp.setThatType(rs.getInt(i++));
				temp.setWeiboID(rs.getString(i++));
				temp.setWeiboPassword(rs.getString(i++));
				temp.setDesID(rs.getString(i++));
				temp.setContent(rs.getString(i++));
				taskArray.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("TaskInfo.adminViewAllTasks roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return taskArray;
	}
	//client:client CNO's tasks
	public ArrayList<Task> clientViewAllTasks(int TCNO){
		ArrayList<Task> taskArray = new ArrayList<Task>();
		String sql = "SELECT * FROM task WHERE TCNO=" + TCNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				Task temp = new Task();
				temp.setTNO(rs.getInt(i++));
				temp.setTCNO(rs.getInt(i++));
				int visible = rs.getInt(i++);
				temp.setTaskName(rs.getString(i++));
				temp.setThisType(rs.getInt(i++));
				temp.setDate(rs.getString(i++));
				temp.setSrcID(rs.getString(i++));
				temp.setSrcPassword(rs.getString(i++));
				temp.setThatType(rs.getInt(i++));
				temp.setWeiboID(rs.getString(i++));
				temp.setWeiboPassword(rs.getString(i++));
				temp.setDesID(rs.getString(i++));
				temp.setContent(rs.getString(i++));
				if(visible == 1)
					taskArray.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("TaskInfo.clientViewAllTasks roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return taskArray;
	}
	
	//insert task
	public boolean newTask(Task task){
		boolean flag = false;
		conn = ConnectDB.connect();
		String sql = "INSERT INTO task(TCNO,TVisible,TName,TTimeOrMail" +
				"TDate,TsrcID,TsrcPassword,TweiboOrMail,TweiboID," +
				"TweiboPassword,TDesID,TContent) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(0, task.getTCNO());
			pstmt.setInt(1, 1);
			pstmt.setString(2, task.getTaskName());
			pstmt.setInt(3, task.getThisType());
			pstmt.setString(4, task.getDate());
			pstmt.setString(5, task.getSrcID());
			pstmt.setString(6, task.getSrcPassword());
			pstmt.setInt(7, task.getThatType());
			pstmt.setString(8, task.getWeiboID());
			pstmt.setString(9, task.getWeiboPassword());
			pstmt.setString(10, task.getDesID());
			pstmt.setString(11, task.getContent());
			if(pstmt.executeUpdate() > 0)
				flag = true;
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("TaskInfo.newTask roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
		return flag;
	}	
	//change task
	public boolean changeTaskInfo(Task task){
		boolean flag = false;
		conn = ConnectDB.connect();
		String sql = "UPDATE task SET TName=?,TTimeOrMail=?" +
				"TDate=?,TsrcID=?,TsrcPassword=?,TweiboOrMail=?,TweiboID=?," +
				"TweiboPassword=?,TDesID=?,TContent=?) WHERE TNO=?";
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(0, task.getTaskName());
			pstmt.setInt(1, task.getThisType());
			pstmt.setString(2, task.getDate());
			pstmt.setString(3, task.getSrcID());
			pstmt.setString(4, task.getSrcPassword());
			pstmt.setInt(5, task.getThatType());
			pstmt.setString(6, task.getWeiboID());
			pstmt.setString(7, task.getWeiboPassword());
			pstmt.setString(8, task.getDesID());
			pstmt.setString(9, task.getContent());
			pstmt.setInt(10, task.getTNO());
			if(pstmt.executeUpdate() > 0)
				flag = true;
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("TaskInfo.changeTaskInfo roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
		return flag;
	}	
	//client delete task
	public boolean clientDeleteTask(int TNO){
		boolean flag = false;
		String sql = "UPDATE task SET TVisible=0 WHERE TNO=" + TNO;
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
				System.out.println("TaskInfo.clientDeleteTask roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return flag;
	}
	//admin delete task
	public boolean adminDeleteTask(int TNO){
		boolean flag = false;
		String sql = "DELETE FROM task WHERE TNO=" + TNO;
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
				System.out.println("TaskInfo.adminDeleteTask roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
}
