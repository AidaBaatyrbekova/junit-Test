package peaksoft.junit_test.model.mapper;

import peaksoft.junit_test.model.Phone;
import peaksoft.junit_test.model.dto.PhoneRequest;

import java.time.LocalDate;

public class PhoneMapper {

    public static Phone mapToEntity(PhoneRequest request) {
        return Phone.builder()
                .model(request.getModel())
                .color(request.getColor())
                .ram(request.getRam())
                .createDate(LocalDate.now())
                .build();
    }
}
