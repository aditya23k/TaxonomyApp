# TaxonomyApp

Build a taxonomy service – Should consume text and increment the most commonly used words and their frequency.
It should be developed in two parts:
  •	one approach using in memory cache with thread safety constructure
  •	second approach to store the words and frequency in the database
  
There should be two rest apis :
  1.	Consume text to be parsed for taxonomy. 
  2.	Api to give list of words and frequency
Focus on performance, efficient use of data structures and thread safety!

# How to run the code

1. Download the repository and open it as a Gradle-Groovy project
2. Run a standard bootRun
3. Head over POSTMAN
4. Set the command to POST and past the following link :http://localhost:8080/parse. In the body, paste the desired text.
5. Click SEND
6. Set the command now to GET and the paste the following link :http://localhost:8080/frequency.
7. The result shown will be the individual words and their frequencies.


# Drawbacks of the Code Repository & Future Improvements

1. As the scope of the project indicates, this code at present doesn't access either a Databse or a Cache. Data should be
   accessed from the cache and the database and the respective updates of the words and their frequencies should be made as such
   without using a hashmap

2. The following code is not Thread Safe, doesn't focus much on performace and uses an inefficient data structure.

   







