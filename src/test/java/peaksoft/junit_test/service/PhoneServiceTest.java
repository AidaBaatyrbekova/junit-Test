package peaksoft.junit_test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import peaksoft.junit_test.PhoneRepository;
import peaksoft.junit_test.model.Phone;
import peaksoft.junit_test.model.dto.PhoneRequest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PhoneServiceTest {
    @InjectMocks
    private PhoneService phoneService;
    @Mock
    private PhoneRepository repository;

    @Test
    void createPhone() {
        phoneService.create(PhoneRequest.builder().build());
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Phone.class));
    }

    @Test
    void updatePhone(){
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(Phone.builder().build()));
        phoneService.update(1L,PhoneRequest.builder().build());
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Phone.class));
    }

    @Test
    void deletePhone(){
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(Phone.builder().build()));
        phoneService.delete(1L);
        Mockito.verify(repository,Mockito.times(1)).delete(Mockito.any(Phone.class));
    }

    @Test
    void findPhoneById(){
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(Phone.builder().build()));
        phoneService.findById(1L);
        Mockito.verify(repository,Mockito.times(1)).findById(Mockito.anyLong());
    }

}
