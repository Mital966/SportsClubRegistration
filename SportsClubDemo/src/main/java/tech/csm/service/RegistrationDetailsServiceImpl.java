package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.RegistrationDetails;
import tech.csm.repository.RegistrationDetailsRepository;

@Service
public class RegistrationDetailsServiceImpl implements RegistrationDetailsService{

	@Autowired
	private RegistrationDetailsRepository RegistrationDetailsRepository;
	
	@Override
	public RegistrationDetails saveApplication(RegistrationDetails regDtls) {
		if(regDtls.getRegId() == null)
			regDtls.setIsActive("Yes");
		
		return RegistrationDetailsRepository.save(regDtls);
	}


	@Override
	public List<RegistrationDetails> getAllActiveApplication() {
		return RegistrationDetailsRepository.findByIsActive("Yes");
	}

	@Override
	public RegistrationDetails findDetailsById(Integer regId) {
		return RegistrationDetailsRepository.findById(regId).get();
	}


	


	


}
