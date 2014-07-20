package weibo4j;

import weibo4j.model.Paging;
import weibo4j.model.PostParameter;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.util.WeiboConfig;

public class Suggestion extends Weibo{
/**
	 * 
	 */
	private static final long serialVersionUID = 1861364044145921824L;
	//---------------------------------推荐接口---------------------------------------------------
	/**
	 * 返回系统推荐的热门用户列�?
	 * 
	 * @return list of the users
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/suggestions/users/hot">suggestions/users/hot</a>
	 * @since JDK 1.5
	 */
	
	public JSONArray suggestionsUsersHot() throws WeiboException{
		return client.get(WeiboConfig.getValue("baseURL")+"suggestions/users/hot.json").asJSONArray();
	}
	
	public JSONArray suggestionsUsersHot(String category) throws WeiboException{
		return client.get(WeiboConfig.getValue("baseURL")+"suggestions/users/hot.json",new PostParameter[]{
			new PostParameter("category", category)
		}).asJSONArray();
	}
	/**
	 * 获取用户可能感兴趣的�?
	 * 
	 * @return list of the user's id
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/suggestions/users/may_interested">suggestions/users/may_interested</a>
	 * @since JDK 1.5
	 */
	public JSONArray suggestionsUsersMayInterested() throws WeiboException{
		return client.get(WeiboConfig.getValue("baseURL")+"suggestions/users/may_interested.json").asJSONArray();
	}
	public JSONArray suggestionsUsersMayInterested(int count,int page) throws WeiboException{
		return client.get(WeiboConfig.getValue("baseURL")+"suggestions/users/may_interested.json",new PostParameter[]{
			new PostParameter("count", count),
			new PostParameter("page", page)
		}).asJSONArray();
	}
	/**
	 * 根据�?��微博正文推荐相关微博用户
	 * 
	 * @return list of the users
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/suggestions/users/by_status">suggestions/users/by_status</a>
	 * @since JDK 1.5
	 */
	public UserWapper suggestionsUsersByStatus(String content) throws WeiboException{
		return User.constructWapperUsers(client.get(WeiboConfig.getValue("baseURL")+"suggestions/users/by_status.json",new PostParameter[]{
			new PostParameter("content", content)
		}));
	}
	public UserWapper suggestionsUsersByStatus(String content,int num) throws WeiboException{
		return User.constructWapperUsers(client.get(WeiboConfig.getValue("baseURL")+"suggestions/users/by_status.json",new PostParameter[]{
			new PostParameter("content", content),
			new PostParameter("num", num)
		}));
	}
	/**
	 * 获取微博精�?推荐
	 * 
	 * @return list of the status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/suggestions/statuses/hot">suggestions/statuses/hot</a>
	 * @since JDK 1.5
	 */
	public StatusWapper suggestionsStatusesHot(int type,int isPic) throws WeiboException{
		return Status.constructWapperStatus(client.get(WeiboConfig.getValue("baseURL")+"suggestions/statuses/hot.json",new PostParameter[]{
			new PostParameter("type", type),
			new PostParameter("is_pic", isPic)
		}));
	}
	public StatusWapper suggestionsStatusesHot(int type,int isPic,Paging page) throws WeiboException{
		return Status.constructWapperStatus(client.get(WeiboConfig.getValue("baseURL")+"suggestions/statuses/hot.json",new PostParameter[]{
			new PostParameter("type", type),
			new PostParameter("is_pic", isPic)
		},page));
	}
	/**
	 * 返回系统推荐的热门收�?
	 * 
	 * @return list of the status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/suggestions/favorites/hot">suggestions/favorites/hot</a>
	 * @since JDK 1.5
	 */
	public JSONArray suggestionsFavoritesHot() throws WeiboException{
		return client.get(WeiboConfig.getValue("baseURL")+"suggestions/favorites/hot.json").asJSONArray();
	}
	public JSONArray suggestionsFavoritesHot(int page,int count) throws WeiboException{
		return client.get(WeiboConfig.getValue("baseURL")+"suggestions/favorites/hot.json",new PostParameter[]{
			new PostParameter("page", page),
			new PostParameter("count", count)
		}).asJSONArray();
	}
	/**
	 * 把某人标识为不感兴趣的人  
	 * 
	 * @return user
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/suggestions/users/not_interested">suggestions/users/not_interested</a>
	 * @since JDK 1.5
	 */
	public User suggestionsUsersNot_interested(String uid) throws WeiboException{
		return new User(client.post(WeiboConfig.getValue("baseURL")+"suggestions/users/not_interested.json",new PostParameter[]{
			new PostParameter("uid", uid)
		}).asJSONObject());
	}
}
