package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Club;
import tech.csm.model.Sports;
import tech.csm.repository.ClubRepository;

@Service
public class ClubrServiceImpl implements ClubService {

	@Autowired
	private ClubRepository clubRepository;
	
	@Override
	public List<Club> getAllClubs() {
		return clubRepository.findAll();
	}

	@Override
	public Club getClubById(Integer clubId) {
		return clubRepository.findById(clubId).get();
	}

	

	

}
