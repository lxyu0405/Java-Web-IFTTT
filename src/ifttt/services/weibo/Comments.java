package ifttt.services.weibo;

import weibo4j.model.Comment;
import weibo4j.model.CommentWapper;
import weibo4j.model.Paging;
import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.util.WeiboConfig;

public class Comments extends Weibo{

	private static final long serialVersionUID = 3321231200237418256L;

	/**
	 * 根据微博ID返回某条微博的评论列�?
	 * 
	 * @param id
	 *            �?��查询的微博ID
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/show">comments/show</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentById(String id) throws WeiboException {
		return Comment.constructWapperComments(client.get(
				WeiboConfig.getValue("baseURL") + "comments/show.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * 根据微博ID返回某条微博的评论列�?
	 * 
	 * @param id
	 *            �?��查询的微博ID
	 * @param count
	 *            单页返回的记录条数，默认�?0�?
	 * @param page
	 *            返回结果的页码，默认�?�?
	 * @param filter_by_author
	 *            作�?筛�?类型�?：全部�?1：我关注的人�?：陌生人，默认为0�?
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/show">comments/show</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentById(String id, Paging page,
			Integer filter_by_author) throws WeiboException {
		return Comment.constructWapperComments(client.get(
				WeiboConfig.getValue("baseURL") + "comments/show.json",
				new PostParameter[] {
						new PostParameter("id", id),
						new PostParameter("filter_by_author", filter_by_author.toString()) }, page));
	}

	/**
	 * 获取当前登录用户�?��出的评论列表
	 * 
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/by_me">comments/by_me</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentByMe() throws WeiboException {
		return Comment.constructWapperComments(client.get(WeiboConfig
				.getValue("baseURL") + "comments/by_me.json"));
	}

	/**
	 * 获取当前登录用户�?��出的评论列表
	 * 
	 * @param count
	 *            单页返回的记录条数，默认�?0
	 * @param page
	 *            返回结果的页码，默认�?
	 * @param filter_by_source
	 *            来源筛�?类型�?：全部�?1：来自微博的评论�?：来自微群的评论，默认为0
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/by_me">comments/by_me</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentByMe(Paging page, Integer filter_by_source)
			throws WeiboException {
		return Comment.constructWapperComments(client.get(
				WeiboConfig.getValue("baseURL") + "comments/by_me.json",
				new PostParameter[] { new PostParameter("filter_by_author",
						filter_by_source.toString()) }, page));
	}

	/**
	 * 获取当前登录用户�?��收到的评论列�?
	 * 
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/to_me">comments/to_me</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentToMe() throws WeiboException {
		return Comment.constructWapperComments(client.get(WeiboConfig
				.getValue("baseURL") + "comments/to_me.json"));
	}

	/**
	 * 获取当前登录用户�?��收到的评论列�?
	 * 
	 * @param count
	 *            单页返回的记录条数，默认�?0�?
	 * @param page
	 *            返回结果的页码，默认�?�?
	 * @param filter_by_author
	 *            作�?筛�?类型�?：全部�?1：我关注的人�?：陌生人，默认为0�?
	 * @param filter_by_source
	 *            来源筛�?类型�?：全部�?1：来自微博的评论�?：来自微群的评论，默认为0�?
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/to_me">comments/to_me</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentToMe(Paging page, Integer filter_by_source,
			Integer filter_by_author) throws WeiboException {
		return Comment.constructWapperComments(client.get(
				WeiboConfig.getValue("baseURL") + "comments/to_me.json",
				new PostParameter[] {
						new PostParameter("filter_by_source", filter_by_source
								.toString()),
						new PostParameter("filter_by_author", filter_by_author
								.toString()) }, page));
	}

	/**
	 * 获取当前登录用户的最新评论包括接收到的与发出�?
	 * 
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/timeline">comments/timeline</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentTimeline() throws WeiboException {
		return Comment.constructWapperComments(client.get(WeiboConfig
				.getValue("baseURL") + "comments/timeline.json"));
	}

	/**
	 * 获取当前登录用户的最新评论包括接收到的与发出�?
	 * 
	 * @param count
	 *            单页返回的记录条数，默认�?0�?
	 * @param page
	 *            返回结果的页码，默认�?�?
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/timeline">comments/timeline</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentTimeline(Paging page) throws WeiboException {
		return Comment.constructWapperComments(client.get(
				WeiboConfig.getValue("baseURL") + "comments/timeline.json",
				null, page));
	}

	/**
	 * 获取�?��的提到当前登录用户的评论，即@我的评论
	 * 
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/mentions">comments/mentions</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentMentions() throws WeiboException {
		return Comment.constructWapperComments(client.get(WeiboConfig
				.getValue("baseURL") + "comments/mentions.json"));
	}

	/**
	 * 获取�?��的提到当前登录用户的评论，即@我的评论
	 * 
	 * @param count
	 *            单页返回的记录条数，默认�?0�?
	 * @param page
	 *            返回结果的页码，默认�?�?
	 * @param filter_by_author
	 *            作�?筛�?类型�?：全部�?1：我关注的人�?：陌生人，默认为0�?
	 * @param filter_by_source
	 *            来源筛�?类型�?：全部�?1：来自微博的评论�?：来自微群的评论，默认为0�?
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/mentions">comments/mentions</a>
	 * @since JDK 1.5
	 */
	public CommentWapper getCommentMentions(Paging page,
			Integer filter_by_source, Integer filter_by_author)
			throws WeiboException {
		return Comment.constructWapperComments(client.get(
				WeiboConfig.getValue("baseURL") + "comments/mentions.json",
				new PostParameter[] {
						new PostParameter("filter_by_source", filter_by_source
								.toString()),
						new PostParameter("filter_by_author", filter_by_author
								.toString()) }, page));
	}

	/**
	 * 根据评论ID批量返回评论信息
	 * 
	 * @param cids
	 *            �?��查询的批量评论ID，用半角逗号分隔，最�?0
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/show_batch">comments/show_batch</a>
	 * @since JDK 1.5
	 */
	public JSONArray getCommentShowBatch(String cids) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "comments/show_batch.json",
				new PostParameter[] { new PostParameter("cids", cids) }).asJSONArray();
	}

	/**
	 * 对一条微博进行评�?
	 * 
	 * @param comment
	 *            评论内容，必须做URLencode，内容不超过140个汉�?
	 * @param id
	 *            �?��评论的微博ID
	 * @return Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/create">comments/create</a>
	 * @since JDK 1.5
	 */
	public Comment createComment(String comment, String id)
			throws WeiboException {
		return new Comment(client.post(WeiboConfig.getValue("baseURL")
				+ "comments/create.json", new PostParameter[] {
				new PostParameter("comment", comment),
				new PostParameter("id", id) }));
	}

	/**
	 * 对一条微博进行评�?
	 * 
	 * @param comment
	 *            评论内容，必须做URLencode，内容不超过140个汉�?
	 * @param id
	 *            �?��评论的微博ID
	 * @param comment_ori
	 *            当评论转发微博时，是否评论给原微博，0：否�?：是，默认为0�?
	 * @return Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/create">comments/create</a>
	 * @since JDK 1.5
	 */
	public Comment createComment(String comment, String id, Integer comment_ori)
			throws WeiboException {
		return new Comment(client.post(WeiboConfig.getValue("baseURL")
				+ "comments/create.json", new PostParameter[] {
				new PostParameter("comment", comment),
				new PostParameter("id", id),
				new PostParameter("comment_ori", comment_ori.toString()) }));
	}

	/**
	 * 回复�?��评论 
	 * @param comment 评论内容，必须做URLencode，内容不超过140个汉�?
	 * 
	 * @param cid
	 *            �?��回复的评论ID
	 * @param id
	 *            �?��评论的微博ID
	 * @return Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/reply">comments/reply</a>
	 * @since JDK 1.5
	 */
	public Comment replyComment(String cid, String id, String comment)
			throws WeiboException {
		return new Comment(client.post(WeiboConfig.getValue("baseURL")
				+ "comments/reply.json", new PostParameter[] {
				new PostParameter("cid", cid), 
				new PostParameter("id", id),
				new PostParameter("comment", comment) }));
	}

	/**
	 * 回复�?��评论
	 * 
	 * @param comment
	 *            评论内容，必须做URLencode，内容不超过140个汉�?
	 * @param cid
	 *            �?��回复的评论ID
	 * @param id
	 *            �?��评论的微博ID
	 * @param without_mention
	 *            回复中是否自动加入�?回复@用户名�?�?：是�?：否，默认为0�?
	 * @param comment_ori
	 *            当评论转发微博时，是否评论给原微博，0：否�?：是，默认为0�?
	 * @return Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/reply">comments/reply</a>
	 * @since JDK 1.5
	 */
	public Comment replyComment(String cid, String id, String comment,
			Integer without_mention, Integer comment_ori) throws WeiboException {
		return new Comment(
				client.post(
						WeiboConfig.getValue("baseURL") + "comments/reply.json",
						new PostParameter[] {
								new PostParameter("comment", comment),
								new PostParameter("id", id),
								new PostParameter("cid", cid),
								new PostParameter("without_mention",without_mention.toString()),
								new PostParameter("comment_ori", comment_ori.toString()) }));
	}

	/**
	 * 删除�?��评论
	 * 
	 * @param cid
	 *            要删除的评论ID，只能删除登录用户自己发布的评论
	 * @return Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/destroy">comments/destroy</a>
	 * @since JDK 1.5
	 */
	public Comment destroyComment(String cid) throws WeiboException {
		return new Comment(client.post(WeiboConfig.getValue("baseURL")
				+ "comments/destroy.json",
				new PostParameter[] { new PostParameter("cid", cid) }));
	}

	/**
	 * 根据评论ID批量删除评论
	 * 
	 * @param ids
	 *            �?��删除的评论ID，用半角逗号隔开，最�?0�?
	 * @return list of Comment
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/comments/destroy_batch">comments/destroy_batch</a>
	 * @since JDK 1.5
	 */
	public JSONArray destoryCommentBatch(String cids) throws WeiboException {
		return client.post(
						WeiboConfig.getValue("baseURL")
								+ "comments/destroy_batch.json",
						new PostParameter[] { new PostParameter("cids", cids) }).asJSONArray();
	}
}
