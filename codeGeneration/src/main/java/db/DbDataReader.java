package db;

import config.ConnectionSettings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class DbDataReader<T> {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private final String url;
    private final String user;
    private final String password;
    ConnectionSettings settings;

    public DbDataReader(ConnectionSettings settings) {
        this.url = settings.getUrl();
        this.user = settings.getUser();
        this.password = settings.getPassword();
        this.settings = settings;
    }

    protected abstract T createModel(ResultSet resultSet) throws SQLException;

    List<T> getData(String query) {
        List<T> result = new ArrayList<T>();
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                T model = createModel(rs);
                result.add(model);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return result;
    }
}
