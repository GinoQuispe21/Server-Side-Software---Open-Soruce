package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.Statistic;
import com.opensource.speedplanner.resource.SaveStatisticResource;
import com.opensource.speedplanner.resource.StatisticResource;
import com.opensource.speedplanner.service.StatisticService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StatisticController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private StatisticService statisticService;

    @PostMapping("/statistics")
    public StatisticResource createStatistic(@Valid @RequestBody SaveStatisticResource resource) {
        return convertToResource(statisticService.createStatistic(convertToEntity(resource)));
    }

    @GetMapping("/statistics/{id}")
    public StatisticResource getStatisticById(@PathVariable(name = "id") Long statisticId) {
        return convertToResource(statisticService.getStatisticById(statisticId));
    }

    @PutMapping("/statistics/{id}")
    public StatisticResource updateStatistic(@PathVariable(name = "id") Long statisticId, @Valid @RequestBody SaveStatisticResource resource) {
        return convertToResource(statisticService.updateStatistic(statisticId, convertToEntity(resource)));
    }

    @DeleteMapping("/statistics/{id}")
    public ResponseEntity<?> deleteStatistic(@PathVariable(name = "id") Long statisticId) {
        return statisticService.deleteStatistic(statisticId);
    }

    @GetMapping("/statistics")
    public Page<StatisticResource> getAllStatistic(Pageable pageable) {
        List<StatisticResource> statistic = statisticService.getAllStatistic(pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int statisticsCount = statistic.size();
        return new PageImpl<>(statistic, pageable, statisticsCount);
    }

    private Statistic convertToEntity(SaveStatisticResource resource) { return mapper.map(resource, Statistic.class); }

    private StatisticResource convertToResource(Statistic entity) { return mapper.map(entity, StatisticResource.class); }
}
