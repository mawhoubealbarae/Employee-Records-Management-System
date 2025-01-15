  FROM openjdk:17-jdk-slim
  COPY target/employee-records-management-system.jar employee-records-management-system.jar
  ENTRYPOINT ["java", "-jar", "employee-records-management-system.jar"]