package ifttt.newservlet;

import ifttt.controlmysql.ClientInfo;
import ifttt.types.Client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SignupServlet(){
		super();
	}
	public void destory(){
		super.destroy();
	}
	public void init() throws ServletException{
		super.init();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		String usr = request.getParameter("signupname");
		String pwd = request.getParameter("signuppwd");
		String confirm = request.getParameter("signupconfirm");
		ClientInfo clientLogin = new ClientInfo();
		if(!ifttt.tools.VerifyUsrPwdFormat.verifyRowCol(usr) ||
				!ifttt.tools.VerifyUsrPwdFormat.verifyRowCol(pwd) ||
				!ifttt.tools.VerifyUsrPwdFormat.verifyRowCol(confirm))
			response.sendRedirect("signup.jsp?errortype=formaterror");
		else if(!pwd.equals(confirm))
			response.sendRedirect("signup.jsp?errortype=pwderror");
		else if(clientLogin.findClient(usr))
			response.sendRedirect("signup.jsp?errortype=usrerror");
		else{
			Client client = new Client(usr,pwd);
			boolean flag = clientLogin.addClient(client);
			if(flag)
				response.sendRedirect("login.jsp?error=false");
			else
				response.sendRedirect("errors.jsp");
		}
	}
}
