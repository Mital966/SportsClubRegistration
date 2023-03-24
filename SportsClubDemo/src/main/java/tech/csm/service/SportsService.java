package tech.csm.service;

import java.util.List;

import tech.csm.model.Sports;

public interface SportsService {

	List<Sports> getAllSportsById(Integer clubId);

	Sports findSportsById(Integer sportsId);

}
