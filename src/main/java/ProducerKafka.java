
import java.util.*;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


/**
 * Created by ahmadjawid on 6/13/17.
 */

public class ProducerKafka {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("metadata.broker.list", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       // props.put("partitioner.class", "example.producer.SimplePartitioner");
       // props.put("request.required.acks", "1");


        Producer producer = new KafkaProducer(props);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String message = scanner.nextLine();
            if ("q".equals(message))
                break;
            producer.send(new ProducerRecord("TOPIC_NAME", message));
        }

    producer.close();
    }
}
