/**
	 * 根据OPEN ID获取微信用户信息
	 * 
	 * @param accessToke
	 *            接口访问凭证
	 * @param openId
	 *            用户ID
	 * @return 微信用户对象
	 */
	public static WeixinUser getWeixinUserByOpenId(String accessToke,
			String openId) {
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToke).replace(
				"OPENID", openId);
		String resp = CommonUtil.httpRequest(requestUrl, "GET", null);
		System.out.println(resp);
		JSONObject json = JSONObject.fromObject(resp);
		WeixinUser user = null;
		if (json != null) {
			user = new WeixinUser();
			user.setCity(json.getString("city"));
			user.setCountry(json.getString("country"));
			user.setGroupid(json.getInt("groupid"));
			user.setHeadimgurl(json.getString("headimgurl"));
			user.setLanguage(json.getString("language"));
			user.setNickname(json.getString("nickname"));
			user.setOpenid(json.getString("openid"));
			user.setProvince(json.getString("province"));
			user.setRemark(json.getString("remark"));
			user.setSex(json.getInt("sex"));
			user.setSubscribe(json.getInt("subscribe"));
			user.setSubscribe_time(json.getInt("subscribe_time"));
			//user.setUnionid(json.getString("unionid"));
		}
		return user;
	}