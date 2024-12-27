[The project is not finished yet]

This is full stack project (Spring Boot and Angular)

                                ************************** Back-End ******************** 
- Spring Boot 3.4  , Java 17
- pom.xml ==> dependencies : Spring Web , Spring Data JPA , MySQL Driver , Spring boot DevTools
- application.properties ==> contain database configuration (URL , username , password )
- Packages :
    - Entity ==> for (User , Test , Question)
    - Repositories ==> each entity must has it's own repo interface to allow access and persist data between Java class and relational 
      database
    - Enums ==> UserRole that contain (ADMIN , USER)
    - Dto ==> Instead of dealing with Entity , using Dto for request and response (loginDto , signupDto , testDto , questionDto , 
             testDetailsDto (return testDto and list of it's questions))
    - Services ==> where write business logic and there are two Interfaces that will deal with controllers later (userService and 
              testService) and their implementations (userServiceImpl and testServiceImpl)where implement abstract methods
         * userServiceImpl : contains implementations of login , signup and create Admin account for the first run of the project
         * testServiceImpl : contains implementations of create test , get all tests , calculate time of each task depends on the 
            number of questions belongs to , add questions for each test , get All questions
    
    - Controllers ==> where handle incoming HTTP requests and determine the appropriate response to send back , there are two 
        controller , one for Users and other for (tests and questions)

                                **************** Front-End *************************
- Angular 18 , bootstrap 5.3.3 ,  Angular UI library(ng-zorro-antd 18.2.1)
- App component contains some folders:
  1 - auth folder which contain two component (login and register)
    - login form wait email and password from user and validate if this user exist in database or not , return with response contains 
      user's information (id , email , name , role)
    - if you run project for first time , admin account will be created automatically which has email 
      (admin1985@gmail.com) and password(admin1985)
    - If you log in as an admin, you will be directed to a main admin page (dashboard) with special admin navbar that contains buttons 
      (Dashboard, Create test , View Results , logout)
        -  (dashboard) that contains all available tests , you can view each test details with it's questions or add new questions
        - (Create Test) to add new test (title , description , time suitable for each question)
        - (View Results ) :
      
    - If you are user  you must register first then login , after that you will be directed to main user page with special navbar that 
       has buttons (dashboard , View Results , logout)
  2 - header component that has copies of the navbar but with different condition , each navbar will appear according to the role of 
     the logged user or non logged/registered
     - add header selector inside app Html component to be found in all pages and also add router-outlet directive which dynamically 
      load different components based on the current URL route.

  3 - modules folder : there are tow modules (admin and user) with their routing
      3.1- Admin : has two folders (components and service)
        - components include (add-questions , dshboard , create- test , view-test-details) and each component has it's path in admin- 
          routing-module
        - service : to get data from web services and can be injectable and used by admin components
      3.2- User : has also two folders (components and service)
          - components include ( dshboard ) and each component has it's path in user- 
          routing-module
        - service : to get data from web services and can be injectable and used by user components
  4 - services folder : includes tow services (auth and storage)
      4.1 - auth service : to get data from login and register web services
      4.2 - storage service : to save informations from return response to use them later like get userId , userRole , knowing if 
       admin is logged or user  in order to be directed to a specific page , logout
