package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Sports;
import tech.csm.repository.ClubRepository;
import tech.csm.repository.SportsRepository;

@Service
public class SportsServiceImpl implements SportsService {
	@Autowired
	private SportsRepository sportsRepository;
	@Autowired
	private ClubRepository clubRepository;
	
	@Override
	public List<Sports> getAllSportsById(Integer clubId) {
		return sportsRepository.findByClub(clubRepository.findById(clubId).get());
	}

	@Override
	public Sports findSportsById(Integer sportsId) {
		return sportsRepository.findById(sportsId).get();
	}

}
