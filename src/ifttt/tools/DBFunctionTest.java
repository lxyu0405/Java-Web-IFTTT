package ifttt.tools;

import java.util.ArrayList;

import ifttt.controlmysql.*;
import ifttt.types.*;

public class DBFunctionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//test for fetching all infomation of table client
		  
		ClientInfo clientDAO = new ClientInfo();
		ArrayList<Client> clientList = clientDAO.allClient();
		System.out.println(clientList.size());		
		for(int i = 0; i < clientList.size();i++){
			Client temp = clientList.get(i);
			System.out.println(temp.getCNO()+"\t"+temp.getCPassword());
		}
		
		//test for using String to store MEDIUMTEXT type information in table message&task
		  
		MessageInfo messageDAO = new MessageInfo();
		ArrayList<Message> messageList = messageDAO.adminViewAllMessages(2);
		System.out.println(messageList.size());		
		for(int i = 0; i < messageList.size();i++){
			Message temp = messageList.get(i);
			System.out.println(temp.getMSrc()+"\t"+temp.getMDes()+"\t"+temp.getMDate());
			System.out.println(temp.getMContent());
		}
		
		Client clientTemp1 = new Client("111220077","111220077");
		Client clientTemp2 = new Client("damn","hard");
		ClientInfo clientLogin = new ClientInfo();
		System.out.println(clientLogin.login(clientTemp1));
		System.out.println(clientLogin.login(clientTemp2));
		
	}

}
