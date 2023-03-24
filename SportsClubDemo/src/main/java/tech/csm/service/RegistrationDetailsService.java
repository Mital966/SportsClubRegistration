package tech.csm.service;

import java.util.List;

import tech.csm.model.RegistrationDetails;

public interface RegistrationDetailsService {

	RegistrationDetails saveApplication(RegistrationDetails regDtls);

	List<RegistrationDetails> getAllActiveApplication();

	RegistrationDetails findDetailsById(Integer regId);


	

}
