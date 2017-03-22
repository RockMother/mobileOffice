<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>

    <class name="mobileoffice.dao.entities.${className}" table="${name}" schema="${schemaName}">
        <id name="id" column="id"/>
        <#list columns as column>
            <property name="${column.codeName}" column="${column.name}"/>
        </#list>
    </class>
</hibernate-mapping>