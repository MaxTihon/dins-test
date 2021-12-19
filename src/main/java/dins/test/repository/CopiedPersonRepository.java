package dins.test.repository;

import dins.test.repository.entity.CopiedPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopiedPersonRepository extends JpaRepository<CopiedPerson, Long> {
}
