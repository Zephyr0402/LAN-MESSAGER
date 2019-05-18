package user;

import java.util.HashMap;
import java.util.Map;

import network.Connection;

/** User的主控类 */
public class UOnline {

	static UOnline instance = null;

	static public UOnline getInstance() {
		return UOnline.instance;
	}

	/** 所有在线的用户 */
	protected Map<String, User> users = new HashMap<String, User>();

	/** 是否在线 */
	public boolean isOnline(String username) {
		return users.containsKey(username);
	}

	/** 登录一个用户 */
	public void login(String usename, String password, Connection con) {

	}

	/** 用户上线 */
	protected User userOnline(String username) {
		return null;
	}

	/** 用户下线 */
	protected User userOffline(String username) {
		return null;
	}

}
