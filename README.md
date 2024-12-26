[The project is not finished yet]

This is full stack project (Spring Boot and Angular)
************************** Back-End ******************** 
- Spring Boot 3.4  , Java 17
  consist of sections :
- dependencies : Spring Web , Spring Data JPA , MySQL Driver , Spring boot DevTools 
- User : login , signup , create Admin account at the first run of the project
- Tests : create , get all , calculate time of each task depends on the number of questions belongs to
- Questions : add questions for each test , get All
- Entity : User , Test , Question
- Dto : treate with Dto for request and response for (login , signup , test , question , testDetails[return testDto and list of it's questions])
- Service Interface : for(User , test , question ) include abstract methods 
- ServiceImplementations : implement all abstract methods of each interface
- Controller : where handle incoming HTTP requests and determine the appropriate response to send back , there are two controller , one for Users and other for (tests and questions)



**************** Front-End *************************
Angular 
