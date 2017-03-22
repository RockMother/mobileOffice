package db;

import config.ConnectionSettings;
import model.Database;
import model.Table;
import mysql.DataTypeMapper;

import java.util.List;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class ModelExtractor {

    private ConnectionSettings settings;

    public ModelExtractor(ConnectionSettings settings){
        this.settings = settings;
    }

    public Database extractModel(){
        Database database = new Database();

        TableReader tableReader = new TableReader(settings);
        List<Table> tables = tableReader.getData();

        for (Table table : tables) {
            TableColumnsExtractor columnsExtractor = new TableColumnsExtractor(settings, new DataTypeMapper());
            table.addColumns(columnsExtractor.getData(table.getName()));
        }

        database.addTables(tables);
        return database;
    }
}
