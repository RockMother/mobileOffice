package model;

import model.base.BaseNamedObject;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class Column extends BaseNamedObject {
    private String dataType;

    public Column(String name, String dataType) {
        super(name);
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
