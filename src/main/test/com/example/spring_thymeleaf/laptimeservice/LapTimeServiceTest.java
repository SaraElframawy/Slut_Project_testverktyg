package com.example.spring_thymeleaf.laptimeservice;

import com.example.spring_thymeleaf.entities.LapTime;
import com.example.spring_thymeleaf.repo.LapTimeRepo;
import com.example.spring_thymeleaf.service.LapTimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)


public class LapTimeServiceTest {
    @Mock
    LapTimeRepo lapTimeRepo;
    private LapTimeService lapTimeService;


    @BeforeEach
    public void setup(){
        //MockitoAnnotations.openMocks(this);
        lapTimeService = new LapTimeService(lapTimeRepo);

    }




    @Test
    public void findLapTimes_test(){
     //given
        List<LapTime> lapTimes = new ArrayList<>();
        lapTimes.add(new LapTime(1));
        lapTimes.add(new LapTime(2));
        lapTimes.add(new LapTime(3));
        lapTimes.add(new LapTime(4));
        lapTimes.add(new LapTime(5));
        lapTimes.add(new LapTime(6));

       /* Comparator<LapTime> idLapTime = new Comparator<LapTime>() {
            @Override
            public int compare(LapTime o1, LapTime o2) {
                if (o1.getId() > o2.getId()) {
                    return -1;
                } else if (o1.getId()<o2.getId()){
                    return 1;

                }
                else{ return 0;}
            }
        }*/




         //when
        when(lapTimeRepo.findAll()).thenReturn(lapTimes);
        List<LapTime>lapTime=lapTimeService.findLapTimes();


        //then
        System.out.println("Laptimes: ");
        System.out.println(lapTime.toString());
        Assertions.assertEquals(lapTime,lapTimes);


    }
    @Test
    public void findByID_invalidID(){
        //given
        int lapTimeID = 1;
        //when
        when(lapTimeRepo.findById(lapTimeID)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,()->lapTimeService.findById(1));

    }
    @Test
    public void deleteById_validId_deletesLapTime() {
        // given
        int lapTimeId = 1;
        doNothing().when(lapTimeRepo).deleteById(lapTimeId);

        // when
        lapTimeService.deleteById(lapTimeId);

        // then
        verify(lapTimeRepo, times(1)).deleteById(lapTimeId);
    }


}
