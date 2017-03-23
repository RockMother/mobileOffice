package model.base;

import utils.StringUtils;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class BaseNamedObject {
    private String name;
    private String codeName;
    private String className;
    protected BaseNamedObject(String name){
        this.name = name;
        this.codeName = StringUtils.toCamelCase(name);
        this.className = StringUtils.toPascalCase(name);
    }

    public String getName() {
        return name;
    }

    public String getCodeName(){
        return codeName;
    }

    public String getClassName() {
        return className;
    }
}
