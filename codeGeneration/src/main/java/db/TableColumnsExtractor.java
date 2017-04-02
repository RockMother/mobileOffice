package db;

import config.ConnectionSettings;
import model.Column;
import mysql.DataTypeMapper;
import mysql.DbQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class TableColumnsExtractor extends DbDataReader<Column> {

    private final DataTypeMapper typeMapper;

    public TableColumnsExtractor(ConnectionSettings settings, DataTypeMapper typeMapper) {
        super(settings);
        this.typeMapper = typeMapper;
    }

    public List<Column> getData(String tableName) {
        return super.getData(String.format(DbQueries.ColumnQuery, settings.getSchemaName(),  tableName ));
    }

    protected Column createModel(ResultSet resultSet) throws SQLException {
        //TABLE_NAME, COLUMN_NAME, DATA_TYP, EXTRA, IsKEY
        return new Column(resultSet.getString("COLUMN_NAME"),
                typeMapper.convertMysqlTypeToJavaType(resultSet.getString("DATA_TYPE")),
                resultSet.getBoolean("IsKEY"),
                resultSet.getString("EXTRA").contains("auto_increment"),
                false);
    }
}
