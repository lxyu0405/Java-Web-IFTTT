package ifttt.types;

/*
 * �˿����ͣ��˿���Ϣ
 * 
 * **/
public class Client {
	//private static int count = 101;
	private int cno;//�˿�ID
	private String cname;//�˿�name
	private String cpassword;//�˿�pwd
	private double cbalance;//�˿����
	private double clevel;//�˿ͻ��ֵȼ�������Ա10000����ͨ�û���ʼΪ10
	public Client(){
		super();
	}
	public Client(String cname,String cpassword){
		//this.cno = count;
		this.cname = cname;
		this.cpassword = cpassword;
	}
	public Client(int cno,String cname,String cpassword,double cbalance,double clevel){
		this.cno = cno;
		this.cname = cname;
		this.cpassword = cpassword;
		this.cbalance = cbalance;
		this.clevel = clevel;
	}
	public void setCNO(int cno){
		this.cno = cno;
	}
	public int getCNO(){
		return this.cno;
	}
	public void setCName(String cname){
		this.cname = cname;
	}
	public String getCName(){
		return this.cname;
	}
	public void setCPassword(String cpassword){
		this.cpassword = cpassword;
	}
	public String getCPassword(){
		return this.cpassword;
	}
	public void setCBalance(double cbalance){
		this.cbalance = cbalance;
	}
	public double getCBalance(){
		return this.cbalance;
	}
	public void setCLevel(double clevel){
		this.clevel = clevel;
	}
	public double getCLevel(){
		return this.clevel;
	}
	
}
