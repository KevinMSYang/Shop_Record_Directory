Development Process
1. Create db script, and upload to mysql
    1.1 check the sql-scripts files
2. Update db configs in application.properties
    2.1 check the application.properties files
3. Create entity
    3.1 the attribute for the class object
4. Create DAO interface
    4.1 Data Access Object, which mean the
5. Create DAO implementation
6. Create REST controller to use DAO
7. Add a Service Layer
    7.1 Service Facade design pattern
    7.2 Intermediate layer for custom business logic
    7.3 Integrate date from multiple sources (DAO/repositories)
        7.3.1 Provide controller with a single view of the data that we integrated from multiple backend datasources
