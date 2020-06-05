package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.Profile;
import com.opensource.speedplanner.repository.ProfileRepository;
import com.opensource.speedplanner.resource.ProfileResource;
import com.opensource.speedplanner.resource.RoleResource;
import com.opensource.speedplanner.resource.SaveProfileResource;
import com.opensource.speedplanner.resource.SaveRoleResource;
import com.opensource.speedplanner.service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfileService profileService;

    @PostMapping("/users/{userId}/profiles")
    public ProfileResource createProfile(@PathVariable(name = "userId")Long userId ,
                                   @Valid @RequestBody SaveProfileResource resource){
        return convertToResource(profileService.createProfile(userId,convertToEntity(resource)));
    }

    @PutMapping("/users/{userId}/profiles/{profileId}")
    public  ProfileResource updateProfile(@PathVariable(name = "userId") Long userId ,
                                          @PathVariable(name = "profileId") Long profileId,
                                          @Valid @RequestBody SaveProfileResource resource){
        return convertToResource(profileService.updateProfile(userId,profileId, convertToEntity(resource)));
    }
    
    @DeleteMapping("/users/{userId}/profiles/{profileId}")
    public ResponseEntity<?> deleteProfile(@PathVariable(name = "userId")Long userId ,
                                           @PathVariable(name = "profileId")Long profileId){
        return profileService.deleteProfile(userId,profileId);
    }

    private Profile convertToEntity(SaveProfileResource resource){
        return  mapper.map(resource, Profile.class);
    }

    private ProfileResource convertToResource(Profile entity){
        return mapper.map(entity, ProfileResource.class);
    }
}
