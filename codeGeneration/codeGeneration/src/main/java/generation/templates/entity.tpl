package mobileoffice.dao.entities;

import base.contracts.HasLongId;

public class ${className} implements HasLongId {
    <#list columns as column>
        private ${column.dataType} ${column.codeName}
    </#list>

    <#list columns as column>
        public ${column.dataType} get${column.className}(){
            return this.${column.codeName};
        }
        public void set${column.className} (${column.dataType} ${column.codeName}) {
            this.${column.codeName} = ${column.codeName};
        }
    </#list>
}