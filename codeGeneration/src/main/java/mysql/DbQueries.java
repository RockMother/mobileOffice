package mysql;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class DbQueries {
    public static final String TableQuery = "select TABLE_NAME from information_schema.TABLES where TABLE_SCHEMA = '%s'";
    public static final String ColumnQuery = "select TABLE_NAME, " +
            "COLUMN_NAME, " +
            "DATA_TYPE, " +
            "EXTRA, " +
            "CASE WHEN COLUMN_KEY = \"PRI\" THEN 1 ELSE 0 END AS IsKEY " +
            "from information_schema.COLUMNS where TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s'";
   public static final String ForeignKeys = "SELECT \n" +
            "  TABLE_NAME,COLUMN_NAME,CONSTRAINT_NAME, REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME\n" +
            "FROM\n" +
            "INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_SCHEMA = '%s' AND CONSTRAINT_NAME != 'PRIMARY'";
}
