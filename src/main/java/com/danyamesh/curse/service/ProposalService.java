package com.danyamesh.curse.service;

import com.danyamesh.curse.model.Proposal;
import com.danyamesh.curse.repository.ProposalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProposalService implements BaseService<Proposal, Long> {
    private final ProposalRepository proposalRepository;

    @Override
    public Proposal save(Proposal entity) {
        return proposalRepository.save(entity);
    }

    @Override
    public Optional<Proposal> findById(Long aLong) {
        return proposalRepository.findById(aLong);
    }

    @Override
    public List<Proposal> findAll() {
        return proposalRepository.findAll();
    }

    @Override
    public void update(Proposal entity) {
        proposalRepository.save(entity);
    }

    @Override
    public void delete(Proposal entity) {
        proposalRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        proposalRepository.deleteById(aLong);
    }
}
