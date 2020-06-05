package com.opensource.speedplanner.service;

import com.opensource.speedplanner.model.Statistic;
import com.opensource.speedplanner.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService{

    @Autowired
    private StatisticRepository statisticRepository;


    @Override
    public Statistic createStatistic(Statistic statistic) {
        return null;
    }

    @Override
    public Statistic getStatisticById(Long statisticId) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteStatistic(Long statisticId) {
        return null;
    }
}
