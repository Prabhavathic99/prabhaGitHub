package net.javaguides.organisation_service.service;

import net.javaguides.organisation_service.dto.OrganisationDto;

public interface OrganisationService {

    OrganisationDto saveOrganisation(OrganisationDto organisationDto);

    OrganisationDto getOrganisation(String code);

}
