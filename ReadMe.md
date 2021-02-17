# Demo Spring applicaiton with database functionality.

RESTful Api that allows you to create users, delete users and update users.

YouTube - https://www.youtube.com/watch?v=9SGDpanrc8U&t=1s

# End Points -

### _Import the Spring AmigosCode.postman_collection.json file in postman_

1. To get students from the DB -

   GET req on localhost:8080/api/v1/student/getStudents

2. To create new users and store them in the DB -

   POST req on localhost:8080/api/v1/student
   body -  
    {
   "name": "Arjun",
   "email": "Arjun@gmail.com",
   "dob": "1995-12-17"
   }

3. To delete users from the DB -

   DELETE req on localhost:8080/api/v1/student
   body -
   {
   "name": "Arjun",
   "email": "Arjun1@gmail.com",
   "dob": "1995-12-17"
   }

4. To modify users in the DB -

   PUT req on http://localhost:8080/api/v1/student/3?name=<NAME HERE>&email=<EMAIL HERE>

# Key Points:

1. Have the spring jars from -
   https://repo.spring.io/release/org/springframework/spring/

   Owned by - http://www.luv2code.com/

2. Install PLSQL from EDB

3. In the "application.properties" file, provied your own username and password

# Important Commands for PLSQL Shell

1. \l - list of databases
2. \du - list of database roles
3. create database student;
4. grant all privileges on database "student" to <ROLE-NAME>;
5. \c student - connect to database "student"
6. \d - describe

# Important Maven commands -

(Maven must be installed!)

1. mvn clean
2. mvn install
3. To run the jar file in ./target => java -jar <FILE-NAME>.jar
4. To run the jar file in ./target on a specific port => java -jar <FILE-NAME>.jar --server.port=<PORT-NUMBER>

Notes -

1.  We are making a 4 layer architecture

              Cliet Apps (React web app, Android app etc)
                                  |
                                  v

                            Service Layer
                        (StudentService.java)
                                  |
                                  v

                              Data Layer
                        (StudentRepository.java)
                                  |
                                  v

                              Database
                              (PLSQL)

2.  We need to use @Transactional and @Modifying when we modify data in the DB. Example - delete, update

# Observations -

### These may be incorrect!

1. @Entity(Student.java) and @Configuration(StudentConfig) are executed when the application starts
2. @PostMapping handling function arguments should have @RequestBody annotation. Refer StudentController for more.
