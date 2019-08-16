ref: 
https://qiita.com/rubytomato@github/items/118817023845b4284553


mvn clean package
mvn clean package -Dmaven.test.skip=true
java -jar application\target\mmsbs.jar
curl -X GET http://localhost:8088/memo/id/1
