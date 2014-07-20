package ifttt.types;

/*
 * 
 * �������ͣ�ÿ�ν�����Ϣ
 * 
 * **/
public class Transaction {
	private int TNO;//����ID
	private int TCNO;//�˿�ID
	private int TType;//��������:1-����(��Ǯ);-1-����
	private double TAmount;//���񻨷�
	private double TBalance;//ִ����������
	private String TDate;//����ִ��ʱ��
	
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
