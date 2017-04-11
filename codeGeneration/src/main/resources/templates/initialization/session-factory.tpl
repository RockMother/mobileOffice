<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="sessionFactory"
          class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="mappingResources">
            <list>
            <#list model as table>
                <value>hibernate/${table.className}.hbm.xml</value>
            </#list>
            </list>
        </property>
        <property name="hibernateProperties">
            <value>
                hibernate.dialect=org.hibernate.dialect.HSQLDialect
            </value>
        </property>
    </bean>

    <bean id="dataSource" class="com.mysql.cj.jdbc.MysqlDataSource">
        <property name="url" value="jdbc:mysql://localhost:3306/mobileoffice?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC"/>
        <property name="user" value="root"/>
        <property name="password" value="1234"/>
    </bean>
</beans>