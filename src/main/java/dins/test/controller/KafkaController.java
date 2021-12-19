package dins.test.controller;


import dins.test.repository.entity.CopiedPerson;
import dins.test.repository.entity.Person;
import dins.test.service.CopiedPersonService;
import dins.test.service.KafkaConsumerService;
import dins.test.service.KafkaProducerService;
import dins.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class KafkaController {
    private final KafkaProducerService kafkaProducerService;
    private final KafkaConsumerService kafkaConsumerService;
    private final PersonService personService;
    private final CopiedPersonService copiedPersonService;

    @Autowired
    public KafkaController(KafkaProducerService kafkaProducerService, KafkaConsumerService kafkaConsumerService, PersonService personService, CopiedPersonService copiedPersonService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaConsumerService = kafkaConsumerService;
        this.personService = personService;
        this.copiedPersonService = copiedPersonService;
    }

    public void readAndWrite() {
        kafkaProducerService.sendMsg(personService.findAll());
    }

    public void writeToTable() {
        List<CopiedPerson> people = kafkaConsumerService.getPeople();
        copiedPersonService.saveAll(people);
    }

    public void preparePersonTable() {
        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            people.add(new Person((long) i, "name_" + i, new Date(new Date().getTime())));
        }

        personService.saveAll(people);
    }
}
