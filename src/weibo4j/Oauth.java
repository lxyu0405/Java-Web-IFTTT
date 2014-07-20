package weibo4j;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import weibo4j.http.AccessToken;
import weibo4j.http.BASE64Encoder;
import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class Oauth extends Weibo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7003420545330439247L;
	// ----------------------------针对站内应用处理SignedRequest获取accesstoken----------------------------------------
	public String access_token;
	public String user_id;

	public String getToken() {
		return access_token;
	}

	/*
	 * 解析站内应用post的SignedRequest split为part1和part2两部�?
	 */
	public String parseSignedRequest(String signed_request) throws IOException,
			InvalidKeyException, NoSuchAlgorithmException {
		String[] t = signed_request.split("\\.", 2);
		// 为了�?url encode/decode 不冲突，base64url 编码方式会将
		// '+'�?/'转换�?-'�?_'，并且去掉结尾的'='�?因此解码之前�?��还原到默认的base64编码，结尾的'='可以用以下算法还�?
		int padding = (4 - t[0].length() % 4);
		for (int i = 0; i < padding; i++)
			t[0] += "=";
		String part1 = t[0].replace("-", "+").replace("_", "/");

		SecretKey key = new SecretKeySpec(WeiboConfig
				.getValue("client_SERCRET").getBytes(), "hmacSHA256");
		Mac m;
		m = Mac.getInstance("hmacSHA256");
		m.init(key);
		m.update(t[1].getBytes());
		String part1Expect = BASE64Encoder.encode(m.doFinal());

		sun.misc.BASE64Decoder decode = new sun.misc.BASE64Decoder();
		String s = new String(decode.decodeBuffer(t[1]));
		if (part1.equals(part1Expect)) {
			return ts(s);
		} else {
			return null;
		}
	}

	/*
	 * 处理解析后的json解析
	 */
	public String ts(String json) {
		try {
			JSONObject jsonObject = new JSONObject(json);
			access_token = jsonObject.getString("oauth_token");
			user_id = jsonObject.getString("user_id");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return access_token;

	}

	/*----------------------------Oauth接口--------------------------------------*/

	public AccessToken getAccessTokenByCode(String code) throws WeiboException {
		return new AccessToken(client.post(
				WeiboConfig.getValue("accessTokenURL"),
				new PostParameter[] {
						new PostParameter("client_id", WeiboConfig
								.getValue("client_ID")),
						new PostParameter("client_secret", WeiboConfig
								.getValue("client_SERCRET")),
						new PostParameter("grant_type", "authorization_code"),
						new PostParameter("code", code),
						new PostParameter("redirect_uri", WeiboConfig
								.getValue("redirect_URI")) }, false));
	}

	public String authorize(String response_type,String state) throws WeiboException {
		return WeiboConfig.getValue("authorizeURL").trim() + "?client_id="
				+ WeiboConfig.getValue("client_ID").trim() + "&redirect_uri="
				+ WeiboConfig.getValue("redirect_URI").trim()
				+ "&response_type=" + response_type
				+ "&state="+state;
	}
	public String authorize(String response_type,String state,String scope) throws WeiboException {
		return WeiboConfig.getValue("authorizeURL").trim() + "?client_id="
				+ WeiboConfig.getValue("client_ID").trim() + "&redirect_uri="
				+ WeiboConfig.getValue("redirect_URI").trim()
				+ "&response_type=" + response_type
				+ "&state="+state
				+ "&scope="+scope;
	}
}
