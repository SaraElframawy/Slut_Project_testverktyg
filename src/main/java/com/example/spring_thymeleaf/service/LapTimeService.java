package com.example.spring_thymeleaf.service;

import com.example.spring_thymeleaf.entities.LapTime;
import com.example.spring_thymeleaf.repo.LapTimeRepo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LapTimeService {

    private final LapTimeRepo lapTimeRepo; //this is database that needs to be mocked

    public LapTimeService(LapTimeRepo lapTimeRepo) {
        this.lapTimeRepo = lapTimeRepo;
    }

    public List<LapTime> findLapTimes() {
        List<LapTime> lapTimes = lapTimeRepo.findAll();
       // lapTimes.stream().sorted().collect(Collectors.toList());
        // TODO: Sort and limit to only 5 best times
        //in the case of ordering a class we use method to verify
        // that those values "lap times" are going to be in double so sort them in descending order
        lapTimes.sort(Comparator.comparingDouble(LapTime::getLapTime));
        //Lap-time is a method on lap time that returns double number
        //Here I create a list of the best time lap that will take
        // the sorted lap time and put it in a list again with limit 6

        List<LapTime> bestLapTime = lapTimes.stream().limit(5).collect(Collectors.toList());
        //collecting all the sorted doubles and listed on new list
        return  bestLapTime;
    }

    public LapTime findById(int id) {
        return lapTimeRepo.findById(id).orElseThrow();
    }

    public LapTime addLapTime(String lapTime) {
        return lapTimeRepo.save(new LapTime(Double.parseDouble(lapTime)));
    }

    public void deleteById(int id) {
        lapTimeRepo.deleteById(id);
    }

    public void deleteAll() {
        lapTimeRepo.deleteAll();
    }
}
