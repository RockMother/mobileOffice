package db;

import config.ConnectionSettings;
import model.ForeignKey;
import mysql.DbQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kisc on 3/23/2017.
 */
public class ForeignKeysExtractor extends DbDataReader<ForeignKey> {

    public ForeignKeysExtractor(ConnectionSettings settings) {
        super(settings);
    }

    public List<ForeignKey> getData() {
        return super.getData(String.format(DbQueries.ForeignKeys, settings.getSchemaName()));
    }

    @Override
    protected ForeignKey createModel(ResultSet resultSet) throws SQLException {
        //TABLE_NAME,COLUMN_NAME,CONSTRAINT_NAME, REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME
        String name = resultSet.getString("CONSTRAINT_NAME");
        String tableName = resultSet.getString("TABLE_NAME");
        String columnName = resultSet.getString("COLUMN_NAME");
        String refTableName = resultSet.getString("REFERENCED_TABLE_NAME");
        String refColumnName = resultSet.getString("REFERENCED_COLUMN_NAME");
        return new ForeignKey(name, tableName, columnName, refTableName, refColumnName);
    }
}
