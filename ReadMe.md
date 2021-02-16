Demo Spring applicaiton with database functionality.
YouTube - https://www.youtube.com/watch?v=9SGDpanrc8U&t=1s

Key Points:

1. Have the spring jars
2. Install PLSQL from EDB

Important Commands for PLSQL Shell

1. \l - list of databases
2. \du - list of database roles
3. create database student;
4. grant all privileges on database "student" to <ROLE-NAME>;
5. \c student - connect to database "student"
6. \d - describe

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

Observations -

# These may be incorrect!

1. @Entity(Student.java) and @Configuration(StudentConfig) are executed when the application starts
2. @PostMapping handling function arguments should have @RequestBody annotation. Refer StudentController for more.
