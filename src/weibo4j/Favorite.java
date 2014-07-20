package weibo4j;

import java.util.List;

import weibo4j.model.Favorites;
import weibo4j.model.FavoritesTag;
import weibo4j.model.Paging;
import weibo4j.model.PostParameter;
import weibo4j.model.Tag;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class Favorite extends Weibo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2298934944028795652L;

	/*----------------------------收藏接口----------------------------------------*/
	/**
	 * 获取当前登录用户的收藏列�?
	 * 
	 * @return list of the Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/favorites">favorites</a>
	 * @since JDK 1.5
	 */
	public List<Favorites> getFavorites() throws WeiboException {
		return Favorites.constructFavorites(client.get(WeiboConfig
				.getValue("baseURL") + "favorites.json"));
	}

	/**
	 * 获取当前登录用户的收藏列�?
	 * 
	 * @param page
	 *            、count
	 * @return list of the Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/favorites">favorites</a>
	 * @since JDK 1.5
	 */
	public List<Favorites> getFavorites(Paging page) throws WeiboException {
		return Favorites.constructFavorites(client.get(
						WeiboConfig.getValue("baseURL") + "favorites.json",
						null, page));
	}
	/**
	 * 获取当前登录用户的收藏列表ID
	 * 
	 * @return list of the Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/favorites">favorites</a>
	 * @since JDK 1.5
	 */
	public JSONObject getFavoritesIds() throws WeiboException {
		return client.get(WeiboConfig
				.getValue("baseURL") + "favorites/ids.json").asJSONObject();
	}
	/**
	 * 获取当前登录用户的收藏列表ID
	 * 
	 * @return list of the Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/favorites">favorites</a>
	 * @since JDK 1.5
	 */
	public JSONObject getFavoritesIds(Paging page) throws WeiboException {
		return client.get(WeiboConfig
				.getValue("baseURL") + "favorites/ids.json",null,page).asJSONObject();
	}
	/**
	 * 根据收藏ID获取指定的收藏信�?
	 * 
	 * @param id
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/show">favorites/show</a>
	 * @since JDK 1.5
	 */
	public Favorites showFavorites(String id) throws WeiboException {
		return new Favorites(client.get(WeiboConfig.getValue("baseURL")
				+ "favorites/show.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * 根据标签获取当前登录用户该标签下的收藏列�?
	 * 
	 * @param tid
	 * @return list of the favorite Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/by_tags">favorites/by_tags</a>
	 * @since JDK 1.5
	 */
	public List<Favorites> getFavoritesByTags(String tid) throws WeiboException {
		return Favorites.constructFavorites(client.get(
				WeiboConfig.getValue("baseURL") + "favorites/by_tags.json",
				new PostParameter[] { new PostParameter("tid", tid) }));
	}

	/**
	 * 根据标签获取当前登录用户该标签下的收藏列�?
	 * 
	 * @param tid
	 * @param page
	 * @return list of the favorite Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/show">favorites/show</a>
	 * @since JDK 1.5
	 */
	public List<Favorites> getFavoritesByTags(String tid, Paging page)
			throws WeiboException {
		return Favorites.constructFavorites(client.get(
				WeiboConfig.getValue("baseURL") + "favorites/by_tags.json",
				new PostParameter[] { new PostParameter("tid", tid) }, page));
	}

	/**
	 * 获取当前登录用户的收藏标签列�?
	 * 
	 * @param page
	 * @return list of the favorite tags
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/tags">favorites/tags</a>
	 * @since JDK 1.5
	 */
	public List<FavoritesTag> getFavoritesTags() throws WeiboException {
		return Tag.constructTag(client.get(WeiboConfig
				.getValue("baseURL") + "favorites/tags.json"));

	}

	/**
	 * 添加�?��微博到收藏里
	 * 
	 * @param 要收藏的微博ID
	 *            �?
	 * @return Favorites status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/create">favorites/create</a>
	 * @since JDK 1.5
	 */
	public Favorites createFavorites(String id) throws WeiboException {
		return new Favorites(client.post(WeiboConfig.getValue("baseURL")
				+ "favorites/create.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * 取消收藏�?��微博
	 * 
	 * @param 要取消收藏的微博ID
	 *            �?
	 * @return Favorites status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/destroy">favorites/destroy</a>
	 * @since JDK 1.5
	 */
	public Favorites destroyFavorites(String id) throws WeiboException {
		return new Favorites(client.post(WeiboConfig.getValue("baseURL")
				+ "favorites/destroy.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * 批量删除收藏
	 * 
	 * @param ids
	 *            要取消收藏的收藏ID，用半角逗号分隔，最多不超过10个�?
	 * @return destroy list of Favorites status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/destroy_batch">favorites/destroy_batch</a>
	 * @since JDK 1.5
	 */
	public Boolean destroyFavoritesBatch(String ids) throws WeiboException {
		try {
			return client
					.post(WeiboConfig.getValue("baseURL")
							+ "favorites/destroy_batch.json",
							new PostParameter[] { new PostParameter("ids", ids) })
					.asJSONObject().getBoolean("result");
		} catch (JSONException e) {
			throw new WeiboException(e);
		}
	}

	/**
	 * 更新�?��收藏的收藏标�?
	 * 
	 * @param id
	 *            要需要更新的收藏ID
	 * @return update tag of Favorites status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/tags/update">favorites/tags/update</a>
	 * @since JDK 1.5
	 */
	public Favorites updateFavoritesTags(String id) throws WeiboException {
		return new Favorites(client.post(WeiboConfig.getValue("baseURL")
				+ "favorites/tags/update.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * 更新�?��收藏的收藏标�?
	 * 
	 * @param id
	 *            要需要更新的收藏ID
	 * @param tags
	 *            �?��更新的标签内容，必须做URLencode，用半角逗号分隔，最多不超过2条�?
	 * @return update tag of Favorites status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/tags/update">favorites/tags/update</a>
	 * @since JDK 1.5
	 */
	public Favorites updateFavoritesTags(String id, String tags)
			throws WeiboException {
		return new Favorites(client.post(WeiboConfig.getValue("baseURL")
				+ "favorites/tags/update.json", new PostParameter[] {
				new PostParameter("id", id), new PostParameter("tags", tags) }));
	}

	/**
	 * 更新当前登录用户�?��收藏下的指定标签
	 * 
	 * @param id
	 *            �?��更新的标签ID�?
	 * @return update tags of Favorites status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/tags/update_batch">favorites/tags/update_batch</a>
	 * @since JDK 1.5
	 */
	public JSONObject updateFavoritesTagsBatch(String tid, String tag)
			throws WeiboException {
		return client.post(
				WeiboConfig.getValue("baseURL")
						+ "favorites/tags/update_batch.json",
				new PostParameter[] { new PostParameter("tid", tid),
						new PostParameter("tag", tag) }).asJSONObject();
	}

	/**
	 * 删除当前登录用户�?��收藏下的指定标签
	 * 
	 * @param id
	 *            �?��删除的标签ID。�?
	 * @return destroy tags of Favorites status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/favorites/tags/destroy_batch">favorites/tags/destroy_batch</a>
	 * @since JDK 1.5
	 */
	public Boolean destroyFavoritesTagsBatch(String ids) throws WeiboException {
		try {
			return client
					.post(WeiboConfig.getValue("baseURL")
							+ "favorites/destroy_batch.json",
							new PostParameter[] { new PostParameter("ids", ids) })
					.asJSONObject().getBoolean("result");
		} catch (JSONException e) {
			throw new WeiboException(e);
		}
	}
}
