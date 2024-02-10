package peaksoft.junit_test.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.junit_test.model.Phone;
import peaksoft.junit_test.model.dto.PhoneRequest;
import peaksoft.junit_test.service.PhoneService;

@RestController
@RequestMapping("/api/phones")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PhoneController {
    PhoneService phoneService;

    @PostMapping
    public Phone create(@RequestBody PhoneRequest request) {
        return phoneService.create(request);
    }

    @PutMapping("/{id}")
    public Phone update(@PathVariable("id") Long id, PhoneRequest request) {
        return phoneService.update(id, request);
    }

    @GetMapping("/{id}")
    public Phone findById(@PathVariable("id") Long id) {
        return phoneService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        return phoneService.delete(id);
    }

}
