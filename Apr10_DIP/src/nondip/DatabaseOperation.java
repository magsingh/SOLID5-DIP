package nondip;

class SQLDatabase {
	public void saveUser(String user) {
		System.out.println("Saved to SQL DB: " + user);
	}
}

class User {
	private SQLDatabase sqlDb;
	public User() {
		sqlDb = new SQLDatabase();
	}
	public void saveUser(String user) {
		sqlDb.saveUser(user);
	}
}

public class DatabaseOperation {
	public static void main(String[] args) {
		User user = new User();
		user.saveUser("User 1");

	}

}

/* Here User class has hard dependency on SQLDatabase. If later, instead of SQLDatabase, required to use MongoDB the
 * User class would need change. To avoid this, we use Dependency Inversion Principle- a high level concrete class should
 * not depend on a low level concrete class. Instead, both should depend on abstractions. (See dip package code)
 */
