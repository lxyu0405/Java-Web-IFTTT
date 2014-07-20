package weibo4j;

import java.util.List;
import weibo4j.model.PostParameter;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.School;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class Account extends Weibo{

	private static final long serialVersionUID = 3816005087976772682L;

	/**
	 * OAuth授权之后，获取授权用户的UID
	 * 
	 * @return uid
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/account/get_uid">account/get_uid</a>
	 * @since JDK 1.5
	 */
	public JSONObject getUid() throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "account/get_uid.json").asJSONObject();
	}

	/**
	 * 获取当前登录用户的隐私设�?
	 * 
	 * @param uid
	 * @return User's privacy
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/account/get_privacy">account/get_privacy</a>
	 * @since JDK 1.5
	 */
	public JSONObject getAccountPrivacy() throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "account/get_privacy.json")
				.asJSONObject();
	}

	/**
	 * 获取�?��学校列表
	 * 
	 * @return list of school
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/account/profile/school_list">account/profile/school_list</a>
	 * @since JDK 1.5
	 */
	public List<School> getAccountPrpfileSchoolList() throws WeiboException {
		return School.constructSchool(client.get(WeiboConfig
				.getValue("baseURL") + "account/profile/school_list.json"));
	}

	/**
	 * 获取�?��学校列表
	 * 
	 * @param province
	 *            ,city,area,type,capital,keyword,count
	 * @return list of school
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/account/profile/school_list">account/profile/school_list</a>
	 * @since JDK 1.5
	 */
	public List<School> getAccountPrpfileSchoolList(Integer province,
			Integer city, Integer area, Integer type, String capital,
			String keyword, Integer count) throws WeiboException {
		return School.constructSchool(client.get(
				WeiboConfig.getValue("baseURL")
						+ "account/profile/school_list.json",
				new PostParameter[] {
						new PostParameter("province", province.toString()),
						new PostParameter("city", city.toString()),
						new PostParameter("area", area.toString()),
						new PostParameter("type", type.toString()),
						new PostParameter("capital", capital),
						new PostParameter("keyword", keyword),
						new PostParameter("count", count.toString()) }));
	}

	/**
	 * 获取当前登录用户的API访问频率限制情况
	 * 
	 * @return ratelimit
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/account/rate_limit_status">account/rate_limit_status</a>
	 * @since JDK 1.5
	 */
	public RateLimitStatus getAccountRateLimitStatus() throws WeiboException {
		return new RateLimitStatus(client.get(WeiboConfig
				.getValue("baseURL") + "account/rate_limit_status.json"));
	}
}
