package db;

import config.ConnectionSettings;
import model.Table;
import mysql.DbQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TableReader extends DbDataReader<Table> {
    public TableReader(ConnectionSettings settings){
        super(settings);
    }

    protected Table createModel(ResultSet resultSet) throws SQLException {
        return new Table(resultSet.getString(1), settings.getSchemaName());
    }

    public List<Table> getData() {
        //TABLE_NAME
        return super.getData(String.format(DbQueries.TableQuery, settings.getSchemaName()));
    }
}
