package tech.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.csm.model.Club;
import tech.csm.model.Sports;

@Repository
public interface SportsRepository extends JpaRepository<Sports, Integer> {

	List<Sports> findByClub(Club club);
	
}
