package edu.nwmissouri.bigdata2.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class ProducerSentence {

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

    for (int i = 0; i <= 10; i = i + 2) {
      String message = generalMessage() + messageStructure();
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
      producer.send(rec);
    }

    String input = in.nextLine();
    while (!input.equals("exit")) {
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, "The String after converting the characters to UpperCase:"+input.toUpperCase());
      producer.send(rec);
      input = in.nextLine();
    }

    // still allow input from keyboard

   private static String generalMessage() {
    return " Structure of sentence: ";
  }

  private static String messageStructure() {
    return " Noun Verb Subject. ";
  }

    in.close();
    producer.close();

  }

  private static String createSentence() {
    return "Noun verb subject.";
  }
}