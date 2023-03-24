package tech.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.csm.model.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

}
