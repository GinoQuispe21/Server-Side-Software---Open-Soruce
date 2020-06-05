package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.SectionSchedule;
import com.opensource.speedplanner.model.Subscription;
import com.opensource.speedplanner.resource.*;
import com.opensource.speedplanner.service.SubscriptionService;
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
public class SubscriptionController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/subscriptions")
    public SubscriptionResource createSubscription (@Valid @RequestBody SaveSubscriptionResource resource) {
        return convertToResource(subscriptionService.createSubscription(convertToEntity(resource)));
    }

    @GetMapping("/subscriptions/{id}")
    public SubscriptionResource getSubscriptionById(@PathVariable(name = "id") Long subscriptionId) {
        return convertToResource(subscriptionService.getSubscriptionById(subscriptionId));
    }

    @PutMapping("/subscriptions/{id}")
    public SubscriptionResource updateSubscription(@PathVariable(name = "id") Long subscriptionId, @Valid @RequestBody SaveSubscriptionResource resource) {
        return convertToResource(subscriptionService.updateSubscription(subscriptionId, convertToEntity(resource)));
    }

    @DeleteMapping("/subscriptions/{id}")
    public ResponseEntity<?> deleteSubscription(@PathVariable(name = "id") Long subscriptionId) {
        return subscriptionService.deleteSubscription(subscriptionId);
    }

    @GetMapping("/subscriptions")
    public Page<SubscriptionResource> getAllSubscription(Pageable pageable) {
        List<SubscriptionResource> subscriptions = subscriptionService.getAllSubscription(pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int subscriptionsCount = subscriptions.size();
        return new PageImpl<>(subscriptions, pageable, subscriptionsCount);
    }

    private Subscription convertToEntity(SaveSubscriptionResource resource) { return mapper.map(resource, Subscription.class); }

    private SubscriptionResource convertToResource(Subscription entity) { return mapper.map(entity, SubscriptionResource.class); }
}
