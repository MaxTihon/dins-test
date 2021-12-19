package dins.test.service;

import dins.test.repository.CopiedPersonRepository;
import dins.test.repository.entity.CopiedPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopiedPersonServiceImpl implements CopiedPersonService {
    private final CopiedPersonRepository copiedPersonRepository;

    @Autowired
    public CopiedPersonServiceImpl(CopiedPersonRepository copiedPersonRepository) {
        this.copiedPersonRepository = copiedPersonRepository;
    }

    @Override
    public List<CopiedPerson> findAll() {
        return copiedPersonRepository.findAll();
    }

    @Override
    public void saveAll(List<CopiedPerson> people) {
        copiedPersonRepository.saveAll(people);
    }
}
