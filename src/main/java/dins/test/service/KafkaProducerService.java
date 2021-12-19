package dins.test.service;

import dins.test.repository.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;


@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<Long, Person> kafkaTemplate;

    public void sendMsg(List<Person> people) {
        for (Person person : people) {
            ListenableFuture<SendResult<Long, Person>> future = kafkaTemplate.send("person", person);
            future.addCallback(System.out::println, System.err::println);
        }

    }
}
