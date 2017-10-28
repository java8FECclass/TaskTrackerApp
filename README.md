# TaskTrackerApp
OOSD JAVA CLASS TASK TRACKER |10 - 27 - 2017
Steps to Create & Run Web App
IF YOU GET STUCK AT ANY POINT !!! 
-> FOLLOW THE INSTRUCTIONS CLOSELY.

1. Install Eclipse

          Download and install the Eclipse IDE for java. Or Any editor of your choice.
  
          Download from here -  https://www.eclipse.org/downloads/ - and setup as Java EE.

2. Setup Your DATABASE.

          Download Mysql Community Installer.msi from here
          https://dev.mysql.com/downloads/installer/
          Run MSI Comm. Installer -> Select Development -> Execute. 
          
          Setup DB & Tables. 
  
          Populate Created Tables with DataBase Information
  
3. Install Tomcat Server 

          https://tomcat.apache.org/download-70.cgi
          
          Under Binary Distributions-> CORE-> Select .Zip File At Top 
          Once download is complete Create-A-Folder named "tools" inside of C://Workspace 
          -> Extract .zip file-> Copy Server Files To C://Workspace/tools Folder.

4. Import the TaskTrackerApp From Git.

          In Eclipse 
          
          File -> Import -> Git -> Projects From Git > Clone URI.
          
          Enter the Github repository url.
          
          Select the branch dev.

5. Getting Ready To Run App

          Open Eclipse Window With TaskTrackerApp In The Package Explorer View Window
          
          Right Click on TaskTrackerApp -> Run AS -> Maven Install -> Wait for the process to finish. 
          
          Right Click on TaskTrackerApp -> Run On Server -> Manually Define New Server
          
          Select Apache Server -> Select TomCat 7.0 -> 
          
          Click Browse To Select your "tools" Folder you Created in Step 3. -> Select OK -> Select Finish.
          
          Wait for your App to load. 
          
          
          
          
6. Successfully Running Your App

          Now That You Have Your App Running 
          
          Login Using Some Credentials 
          
          Have fun


          
