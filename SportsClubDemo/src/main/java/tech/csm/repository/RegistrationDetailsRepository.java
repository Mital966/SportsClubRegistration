package tech.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.csm.model.RegistrationDetails;

@Repository
public interface RegistrationDetailsRepository extends JpaRepository<RegistrationDetails, Integer>{

	List<RegistrationDetails> findByIsActive(String isActive);

}
