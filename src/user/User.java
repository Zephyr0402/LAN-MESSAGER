package user;

public class User {
	/** 用户的唯一表示名称 */
	public final String userName;

	public User(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return userName;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public int hashCode() {
		return userName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		return userName.equals(((User) obj).userName);
	}
}