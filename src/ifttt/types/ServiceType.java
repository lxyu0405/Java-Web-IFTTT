package ifttt.types;

public class ServiceType {
	//private static int count = 4;
	private int TypeNO;
	private String serviceName;
	private double servicePrice;
	public ServiceType(){
		super();
	}
	public ServiceType(String name,double price){
		this.TypeNO = 10;
		this.serviceName = name;
		this.servicePrice = price;
	}
	public void setTypeNO(int TypeNO){
		this.TypeNO = TypeNO;
	}
	public int getTypeNO(){
		return this.TypeNO;
	}
	public void setServiceName(String name){
		this.serviceName = name;
	}
	public String getServiceName(){
		return this.serviceName;
	}
	public void setServicePrice(double price){
		this.servicePrice = price;
	}
	public double getServicePrice(){
		return this.servicePrice;
	}
}
