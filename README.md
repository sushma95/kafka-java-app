# kafka-java-app

## Team Members

### Sushma Yedugani(Team Lead)

- [Sushma GitHub Profile Link](https://github.com/sushma95)
- I have created a Custom Consumer app to display the output of the custom producers.


<br>


### Deepak Malempati
- [Deepak's GitHub Profile link](https://github.com/Deepakmalempati)
- I have created ProducerCards to input card type and remove and left over cards.  
<br>

### Deepthi Tejaswani Chokka

- [Deepthi's GitHub Profile Link](https://github.com/Deepthi1003)
- I have created a Producer named DeepthiProducer.java which is  message 5 times wherein each message tells about how the structure of the sentence should be and converted the input string to Upper-Case Characters

<br>

### Dheeraj Edupuganti

- [Dheeraj's GitHub Profile Link](https://github.com/Dheeraj0327)

- I have created ProducerDheeraj which will print the intials of a given name.
 
<br>

### Maha Lakshmi Kongari
- [Maha Lakshmi's Github Profile Link](https://github.com/MAHALAKSHMIKONGARI)
- I have created Producer to communicate the message to the consumer in uppercase.  

## To start the zookeeper server:

- Open a new PowerShell As Administrator (from anywhere) and run the following command,

```zkserver```

## To start the kafka server:

- Open a new PowerShell As Administrator window in the C:\kafka_2.12-2.2.0\bin\windows folder and run the following command,

```.\kafka-server-start.bat .\server.properties```

## To start the consumer:

- Open PowerShell as Administrator in the root project folder, start the consumer app using topic test and group1,

```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar com.module3.bigdata2.Consumer test group1```

## To start the producer:

- Open PowerShell as Administrator in the root project folder, start the producer app using the below commands,

```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar com.module3.bigdata2.Producer test```

```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar com.module3.bigdata2.DeepthiProducer test```

```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar com.module3.bigdata2.ProducerCards test```

```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar com.module3.bigdata2.ProducerDheeraj test```
