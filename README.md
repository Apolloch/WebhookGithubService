# JavDoc checker for pull_requests
this is a Javaee webservice for automatically getting files from a pull request in Java projects and run an analyse on the javadoc.

# How to run it :
  1) the server :
      you need to have a machine with Jdk 8 and maven.
      in the root folder of this project , open a terminal and run mvn jetty:run
      
 2) the Webhook :
      open the github project on which you want to run this tool.Go to settings -> webhook -> add webhook :
      for the Payload URL field :
      if you have a public adress then past it with a /githubwebhook at the end (untested the not sure of the procedure).
      if you do not (like me) then :
        download this fancy tool called ngrok :https://ngrok.com/download.
        It permits to open your localhost to the internet.run this command where you download ngrok :  ./ngrok http 8080
        copy the URL it gaves to you and paste it in the Payload URL field.
        
3) the Config :
  the config file is /src/main/java/webhook/Config.java you can play with some of the variables (all are documented).
  You should especially watch TMP_DIR , RESULT_DIRECTORY that are actually configured for my computer and SRC_DIR that depends of your project)
  
# How to use it
  once the uppon part is done , your machine will downloads the files of the last pull request you received.
  for the instant you to do the analyse manually by running the class fr.univlille1.m2iagl.bacquetdurey.main.Start
  
  to see the result of this analyse go the adress http://localhost:8080/githubwebhook ( or {ngroklink}/githubwebhook)
