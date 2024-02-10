package peaksoft.junit_test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.junit_test.model.Phone;
import peaksoft.junit_test.model.dto.PhoneRequest;
@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

}
