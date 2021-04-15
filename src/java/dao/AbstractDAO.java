package dao;

import java.sql.Connection;
import java.sql.SQLException;
import util.DBConnection;

public class AbstractDAO {
    private DBConnection db;
    private Connection connection;

    public DBConnection getDb() {
        if(this.db==null)
            this.db=new DBConnection();
        return db;
    }
    
    public void setDb(DBConnection db) {
        this.db = db;
    }

    public Connection getConnection() throws SQLException {
        if(this.connection==null  || this.connection.isClosed())
            this.connection=this.getDb().connect();
        return connection;
    }

    public void setConnection(Connection con) {
        this.connection = con;
    }
    
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
}
