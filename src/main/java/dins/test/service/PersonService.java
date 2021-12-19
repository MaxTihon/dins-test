package dins.test.service;

import dins.test.repository.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    void saveAll(List<Person> people);
}
