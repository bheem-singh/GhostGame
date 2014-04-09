Answer of the question in the specification:
According to the implemented logic numbness is the word which will give certain win to the manual player.

DETAILS:

Technical:
The main technologies used by the solution are as follows::
1. Java 6
2. RESTful webservice (RESTEasy)
3. jQuery
4. JSON 
5. AJAX
The applicaiton was developed application in linux (Ubuntu) environment.
 
General:
1. Extract the jar file GhostGame.jar.
2. The root folder is GhostGame.
3. The project is a standard web project.
4. Solution has been designed in form of various classes. It is according to the specifications document Ghost Game coding challenge - Java.doc. Code comprises of package named com.exercise; (path: GhostGame/src/main/java/com/exercise) having following classes:
 i. GameWebService: RESTFul webservice for the game
 ii. Player: Interface declaring a method (playNextMove) for game player
 iii. AutoPlayer: Class representing a player in form of a computer logic. Implements Player interface
 iv. PlayerFactory: Class representing a player factory.
 v. MoveResult: Class representing result of the move 
 vi. Dictionary: Class representing dictionary.
 Please note: For dictionary data Dictionary class refers WORD.LST in GhostGame/src/main/resources/com/exercise. word.lst is copy of supplied file ZIP - Ghost Game coding challenge - Java (word list).
 vii. TreeNode: Class representing n-ary tree node (and n-ary tree) for a string. This is used in the logic.
5. Junit test cases are also there in form of following classes (path: GhostGame/src/test/java/com/exercise):
 i. DictionaryTest: For testing Dictionary class.
 ii. TreeNode: For testing TreeNode class.
 iii. AutoPlayer: For testing AutoPlayer class.
 (For dictionary data above tests refer WORD.LST in GhostGame/src/main/resources/com/exercise)
6. The front end is implemented in form of a JSP (containing html and jQuery stuff) named index.jsp (default page). (path: GhostGame/src/main/webapp/index.jsp)

Deployment and running:
1. Code is already compiled and the war file GhostGame.war has been provided separately.
2. Deploy the above war file on tomcat server. (Place GhostGame.war into <tomcat roo>/webapps folders. The war should also work on other web server.)
3. Access the application with url: http://localhost:8080/GhostGame (update url according to the server where application is deployed).
4. Page consists of following:
 a. Text: Welcome to the game of Ghost
 b. Text: Your turn, please press a valid key to enter your alphabet
 c. Text: Word string:
5. On entering an alphabet "Word string" text is updated and request is sent to server through AJAX and RESTFul webservice. And finally information from JSON response is used to display the "Word string" after move from server logic.
   (The web service url is "http://localhost:8080/GhostGame/game/word/<word string>". To test web service replace <word string> by some value and update url according to the server where application is deployed. You should be able to see JSON response.)
6. Button with label 'Stop and start a new game' or 'Start a new game' is also shown so that user can start a new game. 
7. The minimum word size for a result is 5. But if a word string of size less than 5 doesn't make any word then game will be over.

Fresh build:
In order to take fresh build and run Junit test cases following command needs to be executed inside the GhostGame folder:
mvn clean install
(Assuming that maven is installed and the computer is connected to the internet.)

Project can also be build and executed through other IDEs e.g. IntelliJ or Eclipse using mvn idea:idea and mvn eclipse:eclipse respectively. 
