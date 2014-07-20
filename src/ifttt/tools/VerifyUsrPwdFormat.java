package ifttt.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyUsrPwdFormat {
	public static boolean verifyRowCol(String a){//检验输入格式
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}	
}
