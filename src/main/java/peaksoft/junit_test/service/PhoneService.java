package peaksoft.junit_test.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import peaksoft.junit_test.PhoneRepository;
import peaksoft.junit_test.exception.NotFoundException;
import peaksoft.junit_test.model.Phone;
import peaksoft.junit_test.model.dto.PhoneRequest;
import peaksoft.junit_test.model.mapper.PhoneMapper;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PhoneService {
    PhoneRepository phoneRepository;

    public Phone create(PhoneRequest request) {
        log.info("Phone successful created");
        return phoneRepository.save(PhoneMapper.mapToEntity(request));
    }

    public Phone update(Long phoneId, PhoneRequest request) {
        Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> {
                            log.error("Phone not found by id: " + phoneId);
                            return new NotFoundException("Phone not found by id: " + phoneId);
                        }
                );
        phone.setColor(request.getColor());
        phone.setRam(request.getRam());
        phone.setModel(request.getModel());
        phoneRepository.save(phone);
        log.info("Phone successful updated ");
        return phone;
    }

    public ResponseEntity<HttpStatus> delete(Long phoneId){
        Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> {
                            log.error("Phone not found by id: " + phoneId);
                            return new NotFoundException("Phone not found by id: " + phoneId);
                        }
                );
        phoneRepository.delete(phone);
        log.info("Phone successful deleted by id: "+phoneId);
        return ResponseEntity.ok().build();
    }

    public Phone findById(Long phoneId){
        Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> {
                            log.error("Phone not found by id: " + phoneId);
                            return new NotFoundException("Phone not found by id: " + phoneId);
                        }
                );
        log.info("Phone got: "+phone.toString());
        return phone;
    }

}
