package com.danyamesh.curse.repository;

import com.danyamesh.curse.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
