package ${packageName}

import base.contracts.HasLongId;

public class ${model.className} implements HasLongId {
    <#list model.columns as column>
        private ${column.dataType} ${column.codeName}
    </#list>

    <#list model.columns as column>
        public ${column.dataType} get${column.className}(){
            return this.${column.codeName};
        }

        public void set${column.className} (${column.dataType} ${column.codeName}) {
            this.${column.codeName} = ${column.codeName};
        }
    </#list>
}