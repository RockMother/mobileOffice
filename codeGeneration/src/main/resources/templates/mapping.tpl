<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>

    <class name="${packageName}.${model.className}" table="${model.name}" schema="${model.schemaName}">
        <id name="id" column="id"/>
        <#list model.columns as column>
        <property name="${column.codeName}" column="${column.name}"/>
        </#list>
    </class>
</hibernate-mapping>