package com.danyamesh.curse.service;

import com.danyamesh.curse.model.Job;
import com.danyamesh.curse.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JobServiceTest {
    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

    @Test
    void testCreateJob() {
        Job jobToSave = new Job();
        when(jobRepository.save(any(Job.class))).thenReturn(jobToSave);
        Job savedJob = jobService.save(jobToSave);
        assertNotNull(savedJob);
        verify(jobRepository, times(1)).save(jobToSave);
    }

    @Test
    void testGetJobById() {
        Long jobId = 1L;
        Job job = new Job();
        when(jobRepository.findById(jobId)).thenReturn(Optional.of(job));
        Optional<Job> foundJob = jobService.findById(jobId);
        assertTrue(foundJob.isPresent());
        verify(jobRepository, times(1)).findById(jobId);
    }

    @Test
    void testGetAllJobs() {
        List<Job> jobList = Arrays.asList(
                new Job(),
                new Job()
        );
        when(jobRepository.findAll()).thenReturn(jobList);
        List<Job> allJobs = jobService.findAll();
        assertNotNull(allJobs);
        assertEquals(jobList.size(), allJobs.size());
        verify(jobRepository, times(1)).findAll();
    }

    @Test
    void testUpdateJob() {
        Job jobToUpdate = new Job();
        jobService.update(jobToUpdate);
        verify(jobRepository, times(1)).save(jobToUpdate);
    }

    @Test
    void testDeleteJob() {
        Job jobToDelete = new Job();
        jobService.delete(jobToDelete);
        verify(jobRepository, times(1)).delete(jobToDelete);
    }

    @Test
    void testDeleteJobById() {
        Long jobId = 1L;
        jobService.deleteById(jobId);
        verify(jobRepository, times(1)).deleteById(jobId);
    }
}