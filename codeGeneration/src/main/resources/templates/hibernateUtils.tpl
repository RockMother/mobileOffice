<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
                    http://www.springframework.org/schema/util
                    http://www.springframework.org/schema/util/spring-util-2.5.xsd">


    <util:list id="entity-mappings" value-type="java.lang.String">
        <#list model as table>
        <value>${settings.entityFolder}/${table.className}.hbm.xml</value>
        </#list>
    </util:list>
</beans>