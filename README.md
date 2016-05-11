Simple Demo for May 2016 NY Tech Meeting:
- Logins into people finder
- Opens advanced search panel and searches for New York employees
- Clears Search and closes advanced search panel
- Logs out + confirms log out

***************
Computer Setup
***************
These automations are run using Selenium WebServer/TestNG requiring Maven and Java8 on your computer. 
Follow the links below to corresponding download pages.

- Download:
  - Java SDK8: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
    - After downloading/intalling the SDK (remember path it is saved too) - add it to your computers PATH variable
        - Windows: 
            - 1: Start Menu > search for CMD
            - 2: In cmd type **set PATH=%PATH%;PATH OF YOUR JAVA\bin** (i.e: c:\Programfiles\Java\jdk-1.6\bin)
            - 3: Restart cmd window and verify it is added echo %PATH%
        - MAC: 
            - 1: Open terminal
            - 2: In terminal type **sudo nano /etc/paths** - enter pw if/when prompted
            - 3: Add **PATH OF YOUR JAVA** at end of file
            - 4: CTRL - X and Y when prompted to save changes
            - 5: Restart terminal window and verify it is added in termail: echo $PATH
  - Development IDE of choice such as Eclipse or IntelliJ (I use IntelliJ and this readme will be based on IntelliJ options)
    https://www.jetbrains.com/idea/#chooseYourEdition
  - Sourcetree (optional, though recommended)
    https://www.sourcetreeapp.com/
    
************
Open Project
************
- If you opted to not use the git/sourcetree set up, click the Download Zip button and unzip the file to desired area.
- In intellij - File > Open and select project folder
  - A prompt should show up asking if you want to import as Maven project - yes
- Go into File - Project Structure and under the project tab, make sure that the SDK is set to Java 1.8, you may get a prompt to do this automatically.
  
You should now see a folder stucture similar to the github repository and you can click and play around :) 
If there are errors in the files, you will see red squigly marks under their names and bold red tags in the code. 

*********
Run Tests
*********
- Right click on the /test/java/com.AutomationDemo.en/tests/Demo_Tests.Java file and click run to run all the tests available.
    -To run an individual test, open up the Demo_Tests.Java file and click the play button next to the test you would like to run.
- If you want to run the parallel bundle tests, right click on /test/resources/Demo.xml and click run. This will run the complete group and the separated login group tests at the same time.

************************************
Troubleshooting Errors/Failed Tests:
************************************
You can see which tests pass or fail in the log at the bottom of the screen. Passed tests will have a green OK next to it, failed tests will have a red exclamation point, and tests that fail because of assertions, like mismatched titles, will have a yellow exclamation point.
- In the event that a test fails, check the log and failed screenshots for that test. The log will have an error as to why the test failed, and the screenshots can help visually pinpoint why as well. See the types of errors at the bottom for an explanation of some common errors you might see. When you are ready to rerun the failed tests:
 - Option 1: Click the rerun failed tests button in the log panel. (Red ! with a play button) This will rerun all the tests in the suite that failed.
 - Option 2: Go into that tests corresponding java file and click the green play button next to whatever test you want to rerun.
    - This option is also the way to run a single test in a suite, in instances where you don't need every test for the page run.
- A screenshot of the last screen of the test, pass or fail, can be found in /screenshots in the root project folder for easier error/result checking.
    
*Types of errors:*
- If you get an error saying "can not find element", try rerunning the test first. Sometimes the test will time out due to slow site load times.
    - If this continues, double check the corresponding WebElement is correct (sometimes code/identifiers change).
- If an assertion fails (test to make sure you are on the right page) it will say so in the intellij log and you can use the failure screenshots taken to better pinpoint the problem. (IE: Wrong page title? Wrong page?)
