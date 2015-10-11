The web service that can create a random classical Sudoku board and that
can validate successive moves. It also be able to recognize and indicate if the Sudoku is 
finished.
 
 
    1. To generate a board make a GET request. 
        http://127.0.0.1:8080/board/
    return a json with fields   
                  - id of the board,   
                  - board values (0 is blank cell)

    {
    "id" : 8218678219165386788,      
    "value" : "530070000600195300098000060800060003400803001700020006060000280000419005000080079",
    }
                
  it means:
                5 3 0 | 0 7 0 | 0 0 0
                6 0 0 | 1 9 5 | 0 0 0
                0 9 8 | 0 0 0 | 0 6 0
                
                8 0 0 | 0 6 0 | 0 0 3
                4 0 0 | 8 0 3 | 0 0 1
                7 0 0 | 0 2 0 | 0 0 6
                
                0 6 0 | 0 0 0 | 2 8 0
                0 0 0 | 4 1 9 | 0 0 5
                0 0 0 | 0 8 0 | 0 7 9

    2. To do a move on the board using POST request.    
      Example: http://localhost:8080/validatemove?id=888895882976226&x=1&y=3&value=7
      x,y is coordinates, id is id of the board
  could return:
          INVALID, VALID, COMPLETE 
          or exception
  
###How to start
    a. Build
        clone the git repository 
        mvn clean install  #//(at root project directory)
            
            a.1 standalone:
            {$root_folder}/su-parent/su-commons/target/sudoko.war
            this war file could be used with any appropriate server

    b. Run  
        mvn spring-boot:run -pl su-parent/su-commons/

    c.  By default the webservice runs on port 8090. To run the server on other port 
        change application.yml at {$root_project}/su-parent/su-commons/src/main/resources/

    d. To run tests:
        mvn test
    
    `NB: ControllerTestSkiped works only with started app.


###todo
    - improve algorithm
    - health check
    - persistent DB store
