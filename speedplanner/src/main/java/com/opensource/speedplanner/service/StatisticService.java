package com.opensource.speedplanner.service;

import com.opensource.speedplanner.model.Statistic;
import org.springframework.http.ResponseEntity;

public interface StatisticService {
    Statistic createStatistic(Statistic statistic);
    Statistic getStatisticById(Long statisticId);
    ResponseEntity<?> deleteStatistic(Long statisticId);
}