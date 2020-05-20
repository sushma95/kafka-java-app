package edu.nwmissouri.bigdata2;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

/**
 * Created by sunilpatil on 12/28/15. Modified by Deepak Malempati on 05/20/2020.
 */
public class ProducerCards {
  private static Scanner scan;

  public static void main(String[] argv) throws Exception {
    if (argv.length != 1) {
      System.err.println("Please re-enter the name of topic");
      System.exit(-1);
    }
    String topic = argv[0];
    scan = new Scanner(System.in);
    System.out.println("Your topic name is: " + topic + "\n");
    System.out.println("Enter your card: \n");

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


    String inputline = scan.nextLine();
   
    while (!inputline.equals("exit")) {
      ProducerRecord<String, String> record1 = new ProducerRecord<String, String>(topic, "Your card is"+inputline);
      producer.send(record1);
      inputline = scan.nextLine();
    }

    scan.close();
    producer.close();
  }
}