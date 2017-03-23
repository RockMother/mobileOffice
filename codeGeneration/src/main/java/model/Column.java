package model;

import model.base.BaseNamedObject;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class Column extends BaseNamedObject {
    private final String name;
    private String dataType;
    private boolean isPrimaryKey;
    private final boolean isForeignKey;
    private Table refTable;

    public Column(String name, String dataType, boolean isPrimaryKey, boolean isForeignKey) {
        super(name);
        this.name = name;
        this.dataType = dataType;
        this.isPrimaryKey = isPrimaryKey;
        this.isForeignKey = isForeignKey;
    }

    public Column(String name, String dataType, boolean isPrimaryKey, boolean isForeignKey, Table refTable) {
        this(name, dataType, isPrimaryKey, isForeignKey);
        this.refTable = refTable;
    }

    public String getDataType() {
        return dataType;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public boolean isForeignKey() {
        return isForeignKey;
    }

    public Table getRefTable() {
        return refTable;
    }
}
