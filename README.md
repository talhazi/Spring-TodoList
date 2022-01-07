# TodoList App
The system itself is a RESTful server for managing people and tasks.

## Project Points
1. Each task has exactly one person owning it, always.
2. The status of each task is either  done  or  active.
3. Each person has zero or more tasks.
4. Users should not be able to get the system into any illegal state (a.k.a data corruption).
5. Data stored in some permanent storage (H2 Database).

## The System Diagram
![system-diagram]

## Running The Project
1. Clone repo:
   `git clone https://github.com/talhazi/Spring-TodoList.git`
2. Open the folder [as IntelliJ IDEA project](https://www.jetbrains.com/help/idea/import-project-or-module-wizard.html) with Java 11.
3. RUN.
4. To the API specification and managing requests go to: [Swagger-UI](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config).
5. To follow the Database go to: [H2-console](http://localhost:8080/h2-console/), and add the following fields: <br/>
   Driver Class: `org.h2.Driver`<br/> JDBC URL: `jdbc:h2:file:./todoDB`

## Built With
* [Spring Framwork](https://spring.io/)

## Dependencies
* [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
* [H2 Database](http://www.h2database.com/html/main.html)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

## Contact
Tal Hazi <> [talhazi114@gmail.com](mailto:talhazi114@gmail.com) <br/>
Dan Amsalem <> [danams@post.bgu.ac.il](mailto:danams@post.bgu.ac.il)

[system-diagram]: system-diagram.png
