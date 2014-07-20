package ifttt.types;

/*
 * 
 * 消息类型
 * 
 * **/
public class Message {
	private int mno;
	private int msrc;//消息发送者；取值顾客ID，-1是管理员发的消息
	private int mdes;//消息接受者;取值顾客ID，-1是群发信息
	private String mdate;//消息时间
	private String mcontent;//消息内容
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
