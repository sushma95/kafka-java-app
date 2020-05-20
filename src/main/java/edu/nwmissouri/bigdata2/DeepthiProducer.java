package edu.nwmissouri.bigdata2.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class DeepthiProducer {

  private static Scanner in;

  public static void main(String[] argv) throws Exception {
    if (argv.length != 1) {
      System.err.println("Please specify 1 parameter (the name of the topic)");
      System.exit(-1);
    }
    String topicName = argv[0];
    in = new Scanner(System.in);
    System.out.println("Thank you for providing the topic " + topicName + "\n");
    System.out.println("Enter message (type exit to quit).\n");

    // Configure the Producer
    Properties configProperties = new Properties();
    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.ByteArraySerializer");
    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.StringSerializer");
    System.out.println("The configuration properties are: " + configProperties.toString());
    System.out.println("\nWill use this configuration to create a producer.\n");

    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

    // Make our own messages - create your custom logic here

    // Displaying message 5 times wherein each message tells about how the structure of the sentence should be.

    for (int i = 1; i <= 5; i++) {
      String message = generalMessage() + i + messageStructure();
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
      producer.send(rec);
    }

    //Converting the input string to Upper-Case Charaters

    String input = in.nextLine();
    while (!input.equals("exit")) {
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, "The String after converting the characters to UpperCase:"+input.toUpperCase());
      producer.send(rec);
      input = in.nextLine();
    }

   private static String generalMessage() {
    return "Message:";
  }

  private static String messageStructure() {
    return "->Structure of sentence: Noun Verb Subject. ";
  }

    in.close();
    producer.close();

  }

}