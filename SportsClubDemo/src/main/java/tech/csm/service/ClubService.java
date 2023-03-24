package tech.csm.service;

import java.util.List;

import tech.csm.model.Club;

public interface ClubService {

	List<Club> getAllClubs();

	Club getClubById(Integer clubId);


}
