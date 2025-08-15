package com.sprints.onlineVotingSystem.controller;

import com.sprints.onlineVotingSystem.domain.Candidate;
import com.sprints.onlineVotingSystem.dto.CandidateRegistrationDTO;
import com.sprints.onlineVotingSystem.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/candidates")
public class AdminCandidateController {

    private final CandidateRepository candidateRepository;

    public AdminCandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @PostMapping
    public ResponseEntity<?> registerCandidate(@Valid @RequestBody CandidateRegistrationDTO candidateDTO) {
        // Check for duplicate name
        boolean exists = candidateRepository.findByCandidateNameContaining(candidateDTO.getCandidateName())
                                            .stream()
                                            .anyMatch(c -> c.getCandidateName().equalsIgnoreCase(candidateDTO.getCandidateName()));
        if (exists) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Candidate with this name already exists.");
        }

        Candidate candidate = new Candidate(candidateDTO.getCandidateName());
        Candidate savedCandidate = candidateRepository.save(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCandidate);
    }
}
