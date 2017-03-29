<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd">


<#list model as table>
<bean id="${table.codeName}DataService" class="${settings.dataServicesPackageName}.${table.className}DataServiceImpl">
    <constructor-arg ref="${table.codeName}Repository"/>
</bean>
</#list>

</beans>