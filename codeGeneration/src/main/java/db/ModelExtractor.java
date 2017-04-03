package db;

import config.ConnectionSettings;
import model.*;
import model.base.BaseNamedObject;
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
            TableColumnsExtractor columnsExtractor = new TableColumnsExtractor(settings, table.isView(), new DataTypeMapper());
            table.addColumns(columnsExtractor.getData(table.getName()));
        }
        ForeignKeysExtractor foreignKeysExtractor = new ForeignKeysExtractor(settings);
        List<ForeignKey> foreignKeys = foreignKeysExtractor.getData();

        ForeignKeyProcess(tables, foreignKeys);

        database.addTables(tables);
        return database;
    }

    private void ForeignKeyProcess(List<Table> tables, List<ForeignKey> foreignKeys) {
        for (ForeignKey key : foreignKeys) {
            Table table = findByName(tables, key.getTableName());
            Column column = findByName(table.getColumns(), key.getColumnName());
            Table refTable = findByName(tables, key.getRefTableName());
            Column refColumn = findByName(refTable.getColumns(), key.getRefColumnName());
            key.setColumn(column);
            key.setTable(table);
            key.setRefTable(refTable);
            key.setRefColumn(refColumn);
            refTable.addForeignKey(key);
            key.setForeignKeyType(ForeignKeyTypes.OneToMany);
            if (table.getName().endsWith("rsp")) {
                ForeignKey additionalKey = new ForeignKey(key.getName(),
                        key.getTableName(),
                        key.getColumnName(),
                        key.getRefTableName(), key.getRefColumnName());
                additionalKey.setTable(refTable);
                additionalKey.setRefTable(table);
                additionalKey.setRefColumn(column);
                additionalKey.setColumn(refColumn);
                additionalKey.setForeignKeyType(ForeignKeyTypes.ManyToOne);
                table.addForeignKey(additionalKey);
            }
/*            else if (table.getName().endsWith("rsp")) {
                ForeignKey additionalKey = new ForeignKey(key.getName(),
                        key.getTableName(),
                        key.getColumnName(),
                        key.getRefTableName(), key.getRefColumnName());
                additionalKey.setTable(refTable);
                additionalKey.setRefTable(table);
                additionalKey.setRefColumn(column);
                additionalKey.setColumn(refColumn);
                additionalKey.setForeignKeyType(ForeignKeyTypes.ManyToOne);
                refTable.addForeignKey(additionalKey);
            }*/

        }
    }

    private <T extends BaseNamedObject>  T findByName(List<T> objects, String name){
        for (T obj : objects) {
            if (obj.getName().equals(name)) {
                return obj;
            }
        }
        return null;
    }

}
