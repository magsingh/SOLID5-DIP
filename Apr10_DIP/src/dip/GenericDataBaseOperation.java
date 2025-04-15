package dip;

interface Database {
	void saveUser(String user);
}

class SQLDatabase implements Database{
	@Override
	public void saveUser(String user) {
		System.out.println("Saved to SQL DB: " + user);
	}
}

class MongoDatabase implements Database{
	@Override
	public void saveUser(String user) {
		System.out.println("Saved to Mongo DB: " + user);
	}
}

class User {
	private Database db;
	public User(Database db) {
		this.db = db;
	}
	public void saveUser(String user) {
		db.saveUser(user);
	}
}

public class GenericDataBaseOperation {
	public static void main(String[] args) {
		Database db = new SQLDatabase();
		User user = new User(db);
		user.saveUser("User 1");
		
		Database mongoDb = new MongoDatabase();
		User user2 = new User(mongoDb);
		user2.saveUser("User 2");
	}

}
