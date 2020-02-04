package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {
<<<<<<< HEAD
	
    private static final DBController dbcontroller = new DBController();
    private static final String DB_PATH = System.getProperty("user.home") + "/" + "jarmdb.db";
=======
>>>>>>> branch 'Jarm-1-Datenbankmodell' of https://github.com/kunibertgangnam/Jarm

<<<<<<< HEAD
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Fehler beim Laden des JDBC-Treibers");
            e.printStackTrace();
        }
    }
    
    private DBController(){
    	try {
			initDBConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static DBController getInstance(){
        return dbcontroller;
    }
    
    public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
    }
    
    private void initDBConnection() throws SQLException {
    	createTables();
    }
    
    private void createTables() throws SQLException{
    	try (Connection con = getConnection(); 
    			Statement stmt = con.createStatement()){
			
=======
	private static final DBController dbcontroller = new DBController();
	// private static Connection connection;
	private static final String DB_PATH = System.getProperty("user.home") + "/" + "jarmdb.db";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.err.println("Fehler beim Laden des JDBC-Treibers");
			e.printStackTrace();
		}
	}

	private DBController() {
		initDBConnection();
	}

	public static DBController getInstance() {
		return dbcontroller;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
	}

	private void initDBConnection() {

		createTables();

//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            public void run() {
//                try {
//                    if (!connection.isClosed() && connection != null) {
//                        connection.close();
//                        if (connection.isClosed())
//                            System.out.println("Connection to Database closed");
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
	}

	private void createTables() throws SQLException {
		try {
			Statement stmt = getConnection().createStatement();
>>>>>>> branch 'Jarm-1-Datenbankmodell' of https://github.com/kunibertgangnam/Jarm
			stmt.execute(DBCreation.CREATE_USER_TABLE);
			stmt.execute(DBCreation.CREATE_PROJECT_TABLE);
			stmt.execute(DBCreation.CREATE_PROJECT_USER_TABLE);
			stmt.execute(DBCreation.CREATE_PROJECT_TODO_TABLE);
			stmt.execute(DBCreation.CREATE_PROJECT_TODO_USER_TABLE);
			stmt.execute(DBCreation.CREATE_PROJECT_MESSAGE_TABLE);

			System.out.println("Tables created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(DB_PATH);
	}
}
