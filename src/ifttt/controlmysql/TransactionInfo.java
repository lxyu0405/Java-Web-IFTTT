package ifttt.controlmysql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import java.util.ArrayList;

import ifttt.connectmysql.ConnectDB;
import ifttt.types.*;

public class TransactionInfo {
	
	private Connection conn = null;
	public TransactionInfo(){
		super();
	}
	//number of transactions
	public int transactionNum(){
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
				System.out.println("TransactionInfo.clientNum roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}
	
	//transactions of client CNO
	public ArrayList<Transaction> getTransactions(int TCNO){
		ArrayList<Transaction> transactionArray = new ArrayList<Transaction>();
		String sql = "SELECT * FROM transaction WHERE TCNO=" + TCNO;
		conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				Transaction temp = new Transaction();
				temp.setTNO(rs.getInt(i++));
				temp.setTCNO(rs.getInt(i++));
				temp.setType(rs.getInt(i++));
				temp.setAmount(rs.getDouble(i++));
				temp.setBalance(rs.getDouble(i++));
				temp.setDate(rs.getString(i++));
				transactionArray.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("TransactionInfo.getTransactions roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return transactionArray;
	}
	
	//insert transaction
	public boolean insertTransaction(Transaction transaction){
		boolean flag = false;
		conn = ConnectDB.connect();
		String sql = "INSERT INTO transaction(TCNO,TType,TAmount,TBalance,TDate) " +
				"VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(0, transaction.getTNO());
			pstmt.setInt(0, transaction.getTCNO());
			pstmt.setInt(1, transaction.getType());
			pstmt.setDouble(2, transaction.getAmount());
			pstmt.setDouble(3, transaction.getBalance());
			pstmt.setString(4, transaction.getDate());
			if(pstmt.executeUpdate() > 0)
				flag = true;
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("TransactionInfo.insertTransaction roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
		return flag;
	}
}
