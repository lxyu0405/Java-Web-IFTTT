package ifttt.types;

/*
 * 
 * ��Ϣ����
 * 
 * **/
public class Message {
	private int mno;
	private int msrc;//��Ϣ�����ߣ�ȡֵ�˿�ID��-1�ǹ���Ա������Ϣ
	private int mdes;//��Ϣ������;ȡֵ�˿�ID��-1��Ⱥ����Ϣ
	private String mdate;//��Ϣʱ��
	private String mcontent;//��Ϣ����
	public Message(){
		super();
	}
	public Message(int src,int des,String date,String content){
		this.mno = 10;
		this.msrc = src;
		this.mdes = des;
		this.mdate = date;
		this.mcontent = content;
	}
	public int getMNO(){
		return this.mno;
	}
	public void setMNO(int mno){
		this.mno = mno;
	}
	public int getMSrc(){
		return this.msrc;
	}
	public void setMSrc(int src){
		this.msrc = src;
	}
	public int getMDes(){
		return this.mdes;
	}
	public void setMDes(int des){
		this.mdes = des;
	}
	public String getMDate(){
		return this.mdate;
	}
	public void setMDate(String date){
		this.mdate = date;
	}
	public String getMContent(){
		return this.mcontent;
	}
	public void setMContent(String content){
		this.mcontent = content;
	}
}
