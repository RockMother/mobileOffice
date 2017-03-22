package mysql;

/**
 * Created by kiril_000 on 23.03.2017.
 */
public class DataTypeMapper {
    public String convertMysqlTypeToJavaType(String mysqlType){
        if (mysqlType.equals("varchar"))
            return "String";
        if (mysqlType.equals("bigint"))
            return "long";
        if (mysqlType.equals("int"))
            return "Integer";
        if (mysqlType.equals("bit"))
            return "boolean";
        if (mysqlType.equals("decimal"))
            return "Float";
        if (mysqlType.equals("date"))
            return "java.util.Date";
        return String.format("TYPE '%s' NOT FOUND!!!", mysqlType);
    }
}
