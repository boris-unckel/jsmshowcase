JSM Showcase

JSM Showcase is a small project to show how a EJB remote call from a separate WAR file is dealt with.
Pre-requisites
1) JDK 11
2) Maven 3.6.x
3) WildFly 22 or above

Steps to reproduce

- git clone 
- mvn clean install
- Copy ear and war to wildfly_home/standalone/deployments
- edit wildfly_home/bin/standalone.conf
  
  uncomment SECMGR="true"
  
  add JAVA_OPTS="$JAVA_OPTS -Dorg.wildfly.security.manager.log-only=true"
  
- edit wildfly_home/standalone/configuration/standalone-full.xml
- add in section ``` <subsystem xmlns="urn:jboss:domain:logging:8.0"> ```

```
    <logger category="net.unckel">
        <level name="ALL"/>
    </logger>
    <logger category="org.wildfly.security.access">
        <level name="TRACE"/>
    </logger>
```
- start server with wildfly_home/bin/standalone.sh -c standalone-full.xml

- observe wildfly_home/standalone/log/server.log for details (not shown on console)
