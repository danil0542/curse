# Course Work

This is a Java Spring Boot project that uses Maven as the build tool, requires Java 17, and interacts with PostgreSQL.

### Functional Requirements:

- Registration and Authorization:
Users can create accounts as clients or freelancers.
Clients and freelancers can log into their accounts using email and password.
- Search and Filtering:
Clients can search for freelancers by project categories, skills, ratings, etc.
Freelancers can search for projects by categories, budgets, deadlines, etc.
- Project Creation and Management:
Clients can create new projects, set budgets, describe requirements, and conditions.
Freelancers can view available projects and submit proposals for execution.
- Communication:
Clients and freelancers can communicate within each project, exchanging messages and files.
- Rating and Reviews:
Clients can rate the work of freelancers and leave reviews after project completion.
Freelancers can rate clients.

### Non-functional Requirements:

- Performance:
The system should respond to user requests in no more than 2 seconds.
- Security:
Data transmission between the user and the server must be encrypted using the HTTPS protocol.
Users should have access rights to their own data but not to the data of other users.
- Reliability:
The system should ensure 99% service availability throughout the month.
- Scalability:
The system should be able to scale to handle growing user traffic without a noticeable decrease in performance.
- Compatibility:
The system should work correctly on different web browsers (Chrome, Firefox, Safari, Edge) and devices of different sizes (tablets, mobile phones, desktop computers).

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


