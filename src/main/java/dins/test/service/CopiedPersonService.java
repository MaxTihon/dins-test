package dins.test.service;

import dins.test.repository.entity.CopiedPerson;

import java.util.List;

public interface CopiedPersonService {
    List<CopiedPerson> findAll();
    void saveAll(List<CopiedPerson> people);
}
