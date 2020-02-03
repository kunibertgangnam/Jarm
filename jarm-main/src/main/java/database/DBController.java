package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {
	
    private static final DBController dbcontroller = new DBController();
    private static Connection connection;
    private static final String DB_PATH = System.getProperty("user.home") + "\\" + "jarmdb.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Fehler beim Laden des JDBC-Treibers");
            e.printStackTrace();
        }
    }
    
    private DBController(){
    	initDBConnection();
    }
    
    public static DBController getInstance(){
        return dbcontroller;
    }
    
    public Connection getConnection() {
    	if (connection == null) throw new RuntimeException("no valid db connection");
    	return connection;
    }
    
    private void initDBConnection() {
        try {
            if (connection != null)
                return;
            System.out.println("Creating Connection to Database...");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
            if (!connection.isClosed())
                System.out.println("...Connection established");
            
            createTables();
        } catch (SQLException e) {
        	e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    if (!connection.isClosed() && connection != null) {
                        connection.close();
                        if (connection.isClosed())
                            System.out.println("Connection to Database closed");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void createTables() {
    	try {
			Statement stmt = connection.createStatement();
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
