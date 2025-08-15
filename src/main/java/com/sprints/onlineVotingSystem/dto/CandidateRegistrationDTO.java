package com.sprints.onlineVotingSystem.dto;

import jakarta.validation.constraints.NotBlank;

public class CandidateRegistrationDTO {

    @NotBlank(message = "Candidate name is required")
    private String candidateName;

    public CandidateRegistrationDTO() {}

    public CandidateRegistrationDTO(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
}
