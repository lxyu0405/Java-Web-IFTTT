package ifttt.types;
/*
 * 
 * 任务类型
 * 
 * **/
public class Task {
	private int TNO;//任务ID
	private int TCNO;//顾客ID
	private String taskName;//任务名称
	private int timeOrMail;//0-time;1-mail
	private String date;//任务时间
	private String srcID;//收邮件ID
	private String srcPassword;//收邮件pwd
	private int weiboOrMail;//0-weibo;1-mail
	private String weiboID;//微博ID
	private String weiboPassword;//微博pwd
	private String desID;//发邮件ID
	private String content;//邮件或者微博内容
	
	public Task(){
		super();
	}
	public Task(int TCNO,String taskName,int timeOrMail,String date,String srcID,String srcPassword,
			int weiboOrMail,String weiboID,String weiboPassword,String desID,String content){
		this.TNO = 0;
		this.TCNO = TCNO;
		this.taskName = taskName;
		this.timeOrMail = timeOrMail;
		this.date = date;
		this.srcID = srcID;
		this.srcPassword = srcPassword;
		this.weiboOrMail = weiboOrMail;
		this.weiboID = weiboID;
		this.weiboPassword = weiboPassword;
		this.desID = desID;
		this.content = content;
	}
	public int getTNO(){
		return this.TNO;
	}
	public void setTNO(int TNO){
		this.TNO = TNO;
	}
	public int getTCNO(){
		return this.TCNO;
	}
	public void setTCNO(int TCNO){
		this.TCNO = TCNO;
	}
	public String getTaskName(){
		return this.taskName;
	}
	public void setTaskName(String taskName){
		this.taskName = taskName;
	}
	public int getThisType(){
		return this.timeOrMail;
	}
	public void setThisType(int timeOrMail){
		this.timeOrMail = timeOrMail;
	}
	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getSrcID(){
		return this.srcID;
	}
	public void setSrcID(String srcID){
		this.srcID = srcID;
	}
	public String getSrcPassword(){
		return this.srcPassword;
	}
	public void setSrcPassword(String srcPassword){
		this.srcPassword = srcPassword;
	}
	public int getThatType(){
		return this.weiboOrMail;
	}
	public void setThatType(int weiboOrType){
		this.weiboOrMail = weiboOrType;
	}
	public String getWeiboID(){
		return this.weiboID;
	}
	public void setWeiboID(String weiboID){
		this.weiboID = weiboID;
	}
	public String getWeiboPassword(){
		return this.weiboPassword;
	}
	public void setWeiboPassword(String weiboPassword){
		this.weiboPassword = weiboPassword;
	}
	public String getDesID(){
		return this.desID;
	}
	public void setDesID(String desID){
		this.desID = desID;
	}
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content = content;
	}

}
