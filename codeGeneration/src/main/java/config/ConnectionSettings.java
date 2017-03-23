package config;

public class ConnectionSettings {
    private final String url = "jdbc:mysql://localhost:3306/mobileoffice";
    private final String user = "root";
    private final String password = "1234";
    private final String schemaName = "mobileoffice";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getSchemaName() {
        return schemaName;
    }
}
