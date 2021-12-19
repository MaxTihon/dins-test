package dins.test.service;

import dins.test.repository.entity.CopiedPerson;
import dins.test.repository.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class KafkaConsumerService {

    private List<Person> people = new ArrayList<>();

    @KafkaListener(topics = "person")
    public void consume(Person person) {
        people.add(person);
    }

    public List<CopiedPerson> getPeople() {
        List<CopiedPerson> copiedPeople = new ArrayList<>();

        people.forEach(person -> copiedPeople.add(new CopiedPerson(person.getId(), person.getName(), person.getTimestamp())));

        return copiedPeople;
    }

}
