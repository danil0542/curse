# Course Work

This is a Java Spring Boot project that uses Maven as the build tool, requires Java 17, and interacts with PostgreSQL.

## Prerequisites

Make sure you have the following software installed on your machine:

- [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

### Optional: Maven Wrapper

The project may include a Maven Wrapper (`mvnw` or `mvnw.cmd`) script that allows you to run Maven without a pre-installed Maven on your machine. To use it, simply run:

./mvnw clean install


or on Windows:

./mvnw.cmd clean install


## Setup

1. **Clone the repository:**

    ```
    git clone https://github.com/yourusername/your-project.git
    cd your-project
    ```

2. **Database Configuration:**

    Create a PostgreSQL database and update the `application.properties` file with your database configuration.

3. **Build and Run the Application:**

    Use Maven to build and run the application:

    ```
    mvn clean install
    mvn spring-boot:run
    ```

    Or, if you are using the Maven Wrapper:

    ```
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

    The application should now be accessible at `http://localhost:8080`.


