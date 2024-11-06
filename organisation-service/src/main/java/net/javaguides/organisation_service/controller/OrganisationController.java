package net.javaguides.organisation_service.controller;

import lombok.AllArgsConstructor;
import net.javaguides.organisation_service.dto.OrganisationDto;
import net.javaguides.organisation_service.service.OrganisationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organisations")
@AllArgsConstructor
public class OrganisationController {

    private OrganisationService organisationService;

    @PostMapping("new")
    public ResponseEntity<OrganisationDto> addNewOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto savedOrganisation = organisationService.saveOrganisation(organisationDto);
        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganisationDto> getOrganisationDetail(@PathVariable String code){
        OrganisationDto organisationDto = organisationService.getOrganisation(code);
        return new ResponseEntity<>(organisationDto,HttpStatus.OK);
    }
}
