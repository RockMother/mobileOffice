package model;

import model.base.BaseNamedObject;

/**
 * Created by kisc on 3/23/2017.
 */
public class ForeignKey extends BaseNamedObject {
    private final String tableName;
    private final String columnName;
    private final String refTableName;
    private final String refColumnName;
    private Table refTable;
    private Column refColumn;
    private Column column;
    private Table table;
    private ForeignKeyTypes foreignKeyType;

    public ForeignKey(String name, String tableName, String columnName, String refTableName, String refColumnName) {
        super(name);
        this.tableName = tableName;
        this.columnName = columnName;
        this.refTableName = refTableName;
        this.refColumnName = refColumnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getRefTableName() {
        return refTableName;
    }

    public String getRefColumnName() {
        return refColumnName;
    }

    public String getTableName() {
        return tableName;
    }

    public Table getRefTable() {
        return refTable;
    }

    public void setRefTable(Table refTable) {
        this.refTable = refTable;
    }

    public Column getRefColumn() {
        return refColumn;
    }

    public void setRefColumn(Column refColumn) {
        this.refColumn = refColumn;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    public Table getTable() {
        return table;
    }

    public void setForeignKeyType(ForeignKeyTypes foreignKeyType) {
        this.foreignKeyType = foreignKeyType;
    }

    public boolean isOneToMany(){
        return this.foreignKeyType == ForeignKeyTypes.OneToMany;
    }

    public String getKeyColumnName(){
        if (isOneToMany()){
            return String.format("%ssBy%s", this.table.getCodeName(), this.column.getClassName());
        } else {
            return String.format("%sBy%s", this.table.getCodeName(), this.refColumn.getClassName());
        }
    }
    public String getKeyColumnNameForProperties(){
        if (isOneToMany()){
            return String.format("%ssBy%s", this.table.getClassName(), this.column.getClassName());
        } else {
            return String.format("%sBy%s", this.table.getClassName(), this.refColumn.getClassName());
        }
    }
}
