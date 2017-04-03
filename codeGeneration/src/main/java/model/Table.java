package model;

import model.base.BaseNamedObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class Table extends BaseNamedObject {
    private List<Column> columns;
    private List<ForeignKey> foreignKeys;
    private boolean isView;
    private String schemaName;

    public Table(String name, boolean isView, String schemaName) {
        super(name);
        this.isView = isView;
        this.schemaName = schemaName;
        columns = new ArrayList<Column>();
        foreignKeys = new ArrayList<ForeignKey>();
    }

    public void addColumns(List<Column> columns){
        this.columns.addAll(columns);
    }

    public void addForeignKey(ForeignKey foreignKey){
        this.foreignKeys.add(foreignKey);
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<ForeignKey> getForeignKeys() {
        return foreignKeys;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public boolean isView() {
        return isView;
    }
}
