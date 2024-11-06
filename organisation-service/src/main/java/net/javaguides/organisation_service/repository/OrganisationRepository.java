package net.javaguides.organisation_service.repository;

import net.javaguides.organisation_service.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

    Organisation getOrganisationByOrganisationCode(String organisationCode);

}
