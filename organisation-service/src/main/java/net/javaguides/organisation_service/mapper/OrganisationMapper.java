package net.javaguides.organisation_service.mapper;

import net.javaguides.organisation_service.dto.OrganisationDto;
import net.javaguides.organisation_service.entity.Organisation;

public class OrganisationMapper {


    public static Organisation mapToOrganisation(OrganisationDto organisationDto){
        Organisation organisation = new Organisation(
                organisationDto.getId(),
                organisationDto.getOrganisationName(),
                organisationDto.getOrganisationCode(),
                organisationDto.getOrganisationDesc(),
                organisationDto.getCreationDate()
        );
        return organisation;
    }

    public static OrganisationDto mapToOrganisationDto(Organisation organisation){
        OrganisationDto organisationDto = new OrganisationDto(
                organisation.getId(),
                organisation.getOrganisationName(),
                organisation.getOrganisationCode(),
                organisation.getOrganisationDesc(),
                organisation.getCreationDate()
        );
        return organisationDto;
    }
}
