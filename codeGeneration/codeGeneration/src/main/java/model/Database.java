package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class Database {
    private List<Table> tables;

    public Database(){
        tables = new ArrayList<Table>();
    }

    public void addTables(List<Table> tables){
        this.tables.addAll(tables);
    }

    public List<Table> getTables() {
        return tables;
    }
}
