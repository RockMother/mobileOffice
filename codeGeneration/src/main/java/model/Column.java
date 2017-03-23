package model;

import model.base.BaseNamedObject;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class Column extends BaseNamedObject {
    private String dataType;
    private boolean isPrimaryKey;

    public Column(String name, String dataType, boolean isPrimaryKey) {
        super(name);
        this.dataType = dataType;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getDataType() {
        return dataType;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }
}
