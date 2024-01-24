package com.danyamesh.curse.service;

import com.danyamesh.curse.model.Proposal;
import com.danyamesh.curse.repository.ProposalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProposalServiceTest {
    @Mock
    private ProposalRepository proposalRepository;

    @InjectMocks
    private ProposalService proposalService;

    @Test
    void testSaveProposal() {
        Proposal proposalToSave = new Proposal();
        Mockito.when(proposalRepository.save(Mockito.any())).thenReturn(proposalToSave);
        Proposal savedProposal = proposalService.save(proposalToSave);
        assertNotNull(savedProposal);
        Mockito.verify(proposalRepository, Mockito.times(1)).save(proposalToSave);
    }

    @Test
    void testFindProposalById() {
        Long proposalId = 1L;
        Proposal mockProposal = new Proposal();
        Mockito.when(proposalRepository.findById(proposalId)).thenReturn(Optional.of(mockProposal));
        Optional<Proposal> foundProposal = proposalService.findById(proposalId);
        assertTrue(foundProposal.isPresent());
        assertEquals(mockProposal, foundProposal.get());
        Mockito.verify(proposalRepository, Mockito.times(1)).findById(proposalId);
    }

    @Test
    void testFindAllProposals() {
        List<Proposal> mockProposals = Arrays.asList(new Proposal(), new Proposal());
        Mockito.when(proposalRepository.findAll()).thenReturn(mockProposals);
        List<Proposal> allProposals = proposalService.findAll();
        assertEquals(mockProposals.size(), allProposals.size());
        Mockito.verify(proposalRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testUpdateProposal() {
        Proposal proposalToUpdate = new Proposal();
        proposalService.update(proposalToUpdate);
        Mockito.verify(proposalRepository, Mockito.times(1)).save(proposalToUpdate);
    }

    @Test
    void testDeleteProposal() {
        Proposal proposalToDelete = new Proposal();
        proposalService.delete(proposalToDelete);
        Mockito.verify(proposalRepository, Mockito.times(1)).delete(proposalToDelete);
    }

    @Test
    void testDeleteProposalById() {
        Long proposalIdToDelete = 1L;
        proposalService.deleteById(proposalIdToDelete);
        Mockito.verify(proposalRepository, Mockito.times(1)).deleteById(proposalIdToDelete);
    }
}