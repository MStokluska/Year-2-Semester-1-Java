package programme;
//unfortunately it is my second static class just to hold values for registered users...i dont like doing it this way however
//i do not know how to transfer values from one class to another if the values are already within a method.
public class User {
	private static String id;
	private static String password;
	private static String id2;
	private static String password2;
	private static String id3;
	private static String password3;

	public User() {
	}

	public void setUserId1(String id) {
		this.id = id;
	}

	public void setPassword1(String password) {
		this.password = password;
	}

	public static String getId1() {
		return id;
	}

	public static String getPassword1() {
		return password;
	}

	public void setUserId2(String id) {
		id2 = id;
	}

	public void setPassword2(String password) {
		password2 = password;
	}

	public static String getId2() {
		return id2;
	}

	public static String getPassword2() {
		return password2;
	}

	public void setUserId3(String id) {
		id3 = id;
	}

	public void setPassword3(String password) {
		password3 = password;
	}

	public static String getId3() {
		return id3;
	}

	public static String getPassword3() {
		return password3;
	}
}