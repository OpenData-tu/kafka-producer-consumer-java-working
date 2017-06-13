
import java.util.*;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * Created by ahmadjawid on 6/13/17.
 */

public class ProducerKafka {
    public static void main(String[] args) {
//        long events = Long.parseLong(args[0]);
//        Random rnd = new Random();

        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
       // props.put("partitioner.class", "example.producer.SimplePartitioner");
       // props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);

        //Producer<String, String> producer = new Producer<String, String>(config);
        Producer producer = new Producer(config);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String message = scanner.nextLine();
            if ("q".equals(message))
                break;
            producer.send(new KeyedMessage("TOPIC_NAME", message));
        }





//        for (long nEvents = 0; nEvents < events; nEvents++) {
//            long runtime = new Date().getTime();
//            String ip = "192.168.2." + rnd.nextInt(255);
//            String msg = runtime + ",www.example.com," + ip;
//            KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, msg);
//            producer.send(data);
//        }
        producer.close();
    }
}