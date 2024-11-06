package net.javaguides.organisation_service.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.organisation_service.dto.OrganisationDto;
import net.javaguides.organisation_service.entity.Organisation;
import net.javaguides.organisation_service.mapper.OrganisationMapper;
import net.javaguides.organisation_service.repository.OrganisationRepository;
import net.javaguides.organisation_service.service.OrganisationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationRepository organisationRepository;

    @Override
    public OrganisationDto saveOrganisation(OrganisationDto organisationDto) {
        Organisation organisation = OrganisationMapper.mapToOrganisation(organisationDto);
        Organisation savedOrganisation = organisationRepository.save(organisation);
        return OrganisationMapper.mapToOrganisationDto(savedOrganisation);
    }

    @Override
    public OrganisationDto getOrganisation(String code) {
        Organisation organisation = organisationRepository.getOrganisationByOrganisationCode(code);
        return OrganisationMapper.mapToOrganisationDto(organisation);
    }


}
