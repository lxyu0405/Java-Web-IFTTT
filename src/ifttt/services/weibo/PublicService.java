package ifttt.services.weibo;

import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class PublicService extends Weibo{

	private static final long serialVersionUID = 1L;

	/**
	 * 通过地址编码获取地址名称 
	 * 
	 * 
	 */
	public JSONArray getLocationByCode (String codes) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/code_to_location.json",new PostParameter[] {
			new PostParameter("codes", codes)
		}).asJSONArray();
	}
	/**
	 * 获取省份列表 
	 * 
	 * 
	 */
	public JSONArray provinceList (String country) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_province.json",new PostParameter[] {
			new PostParameter("country", country)
		}).asJSONArray();
	}
	
	public JSONArray provinceListOfCapital (String country,String capital) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_province.json",new PostParameter[] {
			new PostParameter("country", country),
			new PostParameter("capital", capital)
		}).asJSONArray();
	}
	
	public JSONArray provinceList (String country,String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_province.json",new PostParameter[] {
			new PostParameter("country", country),
			new PostParameter("language", language)
		}).asJSONArray();
	}
	
	public JSONArray provinceList (String country,String capital,String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_province.json",new PostParameter[] {
			new PostParameter("country", country),
			new PostParameter("capital", capital),
			new PostParameter("language", language)
		}).asJSONArray();
	}
	/**
	 * 获取城市列表 
	 * 
	 * 
	 */
	public JSONArray cityList (String province) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",new PostParameter[] {
			new PostParameter("province", province)
		}).asJSONArray();
	}
	
	public JSONArray cityListOfCapital (String province,String capital) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",new PostParameter[] {
			new PostParameter("province", province),
			new PostParameter("capital", capital)
		}).asJSONArray();
	}
	
	public JSONArray cityList (String province,String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",new PostParameter[] {
			new PostParameter("province", province),
			new PostParameter("language", language)
		}).asJSONArray();
	}
	
	public JSONArray cityList (String province,String capital,String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",new PostParameter[] {
			new PostParameter("province", province),
			new PostParameter("capital", capital),
			new PostParameter("language", language)
		}).asJSONArray();
	}
	/**
	 * 获取国家列表 
	 * 
	 * 
	 */
	public JSONArray countryList () throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_country.json").asJSONArray();
	}
	
	public JSONArray countryListOfCapital (String capital) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_country.json",new PostParameter[] {
			new PostParameter("capital", capital)
		}).asJSONArray();
	}
	
	public JSONArray countryList (String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_country.json",new PostParameter[] {
			new PostParameter("language", language)
		}).asJSONArray();
	}
	
	public JSONArray countryList (String capital,String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_country.json",new PostParameter[] {
			new PostParameter("capital", capital),
			new PostParameter("language", language)
		}).asJSONArray();
	}
	
	/**
	 * 获取时区配置�?
	 * 
	 */
	public JSONObject getTomeZone () throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_timezone.json").asJSONObject();
	}

}
