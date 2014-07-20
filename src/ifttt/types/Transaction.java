package ifttt.types;

/*
 * 
 * 事务类型，每次交易信息
 * 
 * **/
public class Transaction {
	private int TNO;//事务ID
	private int TCNO;//顾客ID
	private int TType;//事务类型:1-收入(充钱);-1-消费
	private double TAmount;//事务花费
	private double TBalance;//执行事务后，余额
	private String TDate;//事务执行时间
	
	public Transaction(){
		super();
	}
	public Transaction(int ttype,double tamount,double tbalance,String tdate){
		this.TCNO = 100;
		this.TType = ttype;
		this.TAmount = tamount;
		this.TBalance = tbalance;
		this.TDate = tdate;
	}
	public int getTNO(){
		return this.TNO;
	}
	public void setTNO(int tno){
		this.TNO = tno;
	}
	public int getTCNO(){
		return this.TCNO;
	} 
	public void setTCNO(int tcno){
		this.TCNO = tcno;
	}
	public int getType(){
		return this.TType;
	}
	public void setType(int type){
		this.TType = type;
	}
	public double getAmount(){
		return this.TAmount;
	}
	public void setAmount(double amount){
		this.TAmount = amount;
	}
	public double getBalance(){
		return this.TBalance;
	}
	public void setBalance(double balance){
		this.TBalance = balance;
	}
	public String getDate(){
		return this.TDate;
	}
	public void setDate(String date){
		this.TDate = date;
	}
}
