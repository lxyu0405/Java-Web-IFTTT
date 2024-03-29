package weibo4j;

import weibo4j.model.PostParameter;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class Place extends Weibo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/****************å¨æ?è¯»å************************/
	/**
	 * æ³¨ï¼æ²¡æåå®
	 * 
	 * è·åå½åç»å½ç¨æ·ä¸å¶å¥½åçä½ç½®å¨æ?
	 */
	public StatusWapper friendsTimeLine () throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig.getValue("baseURL") + "place/friends_timeline.json"));
	}
	
	
	/****************ç¨æ·è¯»å************************/
	/**
	 * è·åLBSä½ç½®æå¡åçç¨æ·ä¿¡æ¯ 
	 * 
	 * 
	 */
	public JSONObject userInfoInLBS (String uid) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "place/users/show.json",new PostParameter[] {
			new PostParameter("uid", uid)
		}).asJSONObject();
	}
	
	public JSONObject userInfoInLBS (String uid,int base_app) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "place/users/show.json",new PostParameter[] {
			new PostParameter("uid", uid),
			new PostParameter("base_app", base_app)
		}).asJSONObject();
	}
	
	/**
	 * è·åç¨æ·ç­¾å°è¿çå°ç¹åè¡¨
	 * 
	 *   æ³¨ï¼æ²¡æåå®
	 */
	public JSONObject checkinsList (String uid) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "place/users/checkins.json",new PostParameter[] {
			new PostParameter("uid", uid)
		}).asJSONObject();
	}
	
	/**
	 * è·åç¨æ·çç§çåè¡?
	 * 
	 * æ³¨ï¼æ²¡æåå®
	 */
	
	public JSONObject photoList (String uid) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "place/users/photos.json",new PostParameter[] {
			new PostParameter("uid", uid)
		}).asJSONObject();
	}
	
	/**
	 * è·åç¨æ·çç¹è¯åè¡?
	 * 
	 * æ³¨ï¼æ²¡æåå®
	 */
	
	public JSONObject tipsList (String uid) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "place/users/tips.json",new PostParameter[] {
			new PostParameter("uid", uid)
		}).asJSONObject();
	}
	
	/****************å°ç¹è¯»å************************/
	/**
	 * è·åå°ç¹è¯¦æ 
	 * 
	 * 
	 */
	public JSONObject poisShow (String poiid) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "place/pois/show.json",new PostParameter[] {
			new PostParameter("poiid", poiid)
		}).asJSONObject();
	}
	
	public JSONObject poisShow (String poiid,int base_app) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "place/pois/show.json",new PostParameter[] {
			new PostParameter("poiid", poiid),
			new PostParameter("base_app",base_app)
		}).asJSONObject();
	}
	
	/**
	 * è·åå¨æä¸ªå°ç¹ç­¾å°çäººçåè¡¨ 
	 * 
	 * æ³¨ï¼æ²¡åå®?	 */
	public JSONObject poisUsersList (String poiid) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "place/pois/show.json",new PostParameter[] { 
			new PostParameter("poiid", poiid) }).asJSONObject();
	}
	
	/**
	 * è·åå¨æä¸ªå°ç¹ç¹è¯çåè¡¨ 
	 * 
	 * æ³¨ï¼æ²¡åå®?	 */
	public User poisTipsList (String poiid) throws WeiboException {
		return new User(client.get(WeiboConfig.getValue("baseURL") + "place/pois/tips.json",new PostParameter[] { 
			new PostParameter("poiid", poiid) }).asJSONObject());
	}
	
}
