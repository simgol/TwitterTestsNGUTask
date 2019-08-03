repository: git@github.com:simgol/TwitterTestsNGUTask.git

driver/browser: FireFox

tests:
1. "Verification if a logged user can add a new tweet"
2. "Verification if a logged user is able to follow and unfollow a profile"

run tests from the terminal/command line by executing the following command (it has to be executed from the location of testng.xml or passing in the command line the path to the testng.xml file): 
java -cp "{Path to the project}/dependencies/*:{Path to the project}/out/production/TwitterTestsNGUTask/" org.testng.TestNG testng.xml 
e.g.
java -cp "/home/sgl/IdeaProjects/TwitterTestsNGUTask/dependencies/*:/home/sgl/IdeaProjects/TwitterTestsNGUTask/out/production/TwitterTestsNGUTask/" org.testng.TestNG testng.xml
