package mysql;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class DbQueries {
    public static final String TableQuery = "select TABLE_NAME from information_schema.TABLES where TABLE_SCHEMA = '%s'";
    public static final String ColumnQuery = "select TABLE_NAME, COLUMN_NAME, DATA_TYPE from information_schema.COLUMNS where TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s'";
}
