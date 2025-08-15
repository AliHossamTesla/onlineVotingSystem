package com.sprints.onlineVotingSystem.repository;

import com.sprints.onlineVotingSystem.domain.Candidate;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {
    List<Candidate> findByCandidateNameContaining(String keyword);
}
