package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.SectionSchedule;
import com.opensource.speedplanner.resource.SaveSectionScheduleResource;
import com.opensource.speedplanner.resource.SaveStatisticResource;
import com.opensource.speedplanner.resource.SectionScheduleResource;
import com.opensource.speedplanner.resource.StatisticResource;
import com.opensource.speedplanner.service.SectionScheduleService;
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
public class SectionScheduleController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SectionScheduleService sectionScheduleService;

    @PostMapping("/sectionSchedules")
    public SectionScheduleResource createSectionSchedule(@Valid @RequestBody SaveSectionScheduleResource resource) {
        return convertToResource(sectionScheduleService.createSectionSchedule(convertToEntity(resource)));
    }

    @GetMapping("/sectionSchedules/{id}")
    public SectionScheduleResource getSectionScheduleById(@PathVariable(name = "id") Long sectionScheduleId) {
        return convertToResource(sectionScheduleService.getSectionScheduleById(sectionScheduleId));
    }

    @PutMapping("/sectionSchedules/{id}")
    public SectionScheduleResource updateSectionSchedule(@PathVariable(name = "id") Long sectionScheduleId, @Valid @RequestBody SaveSectionScheduleResource resource) {
        return convertToResource(sectionScheduleService.updateSectionSchedule(sectionScheduleId, convertToEntity(resource)));
    }

    @DeleteMapping("/sectionSchedules/{id}")
    public ResponseEntity<?> deleteSectionSchedules(@PathVariable(name = "id") Long sectionSchedulesId) {
        return sectionScheduleService.deleteSectionSchedule(sectionSchedulesId);
    }

    @GetMapping("/sectionSchedules")
    public Page<SectionScheduleResource> getAllSectionSchedule(Pageable pageable) {
        List<SectionScheduleResource> sectionSchedule = sectionScheduleService.getAllSectionSchedule(pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int sectionSchedulesCount = sectionSchedule.size();
        return new PageImpl<>(sectionSchedule, pageable, sectionSchedulesCount);
    }

    private SectionSchedule convertToEntity(SaveSectionScheduleResource resource) { return mapper.map(resource, SectionSchedule.class); }

    private SectionScheduleResource convertToResource(SectionSchedule entity) { return mapper.map(entity, SectionScheduleResource.class); }
}
