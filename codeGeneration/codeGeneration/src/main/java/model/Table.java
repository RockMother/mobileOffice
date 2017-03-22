package model;

import model.base.BaseNamedObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class Table extends BaseNamedObject {
    private List<Column> columns;
    private String schemaName;

    public Table(String name, String schemaName) {
        super(name);
        this.schemaName = schemaName;
        columns = new ArrayList<Column>();
    }

    public void addColumns(List<Column> columns){
        this.columns.addAll(columns);
    }

    public List<Column> getColumns() {
        return columns;
    }

    public String getSchemaName() {
        return schemaName;
    }
}
