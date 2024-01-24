package com.danyamesh.curse.controller;

import com.danyamesh.curse.model.Job;
import com.danyamesh.curse.service.JobService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class JobControllerTest {
    @Mock
    private JobService jobService;

    @InjectMocks
    private JobController jobController;

    @Test
    void testGetAllJobs() {
        List<Job> mockJobs = Arrays.asList(new Job(), new Job());
        Mockito.when(jobService.findAll()).thenReturn(mockJobs);
        ResponseEntity<List<Job>> responseEntity = jobController.getAllJobs();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockJobs, responseEntity.getBody());
        Mockito.verify(jobService, Mockito.times(1)).findAll();
    }

    @Test
    void testGetJobById_JobExists() {
        Long jobId = 1L;
        Job mockJob = new Job();
        Mockito.when(jobService.findById(jobId)).thenReturn(Optional.of(mockJob));
        ResponseEntity<Job> responseEntity = jobController.getJobById(jobId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockJob, responseEntity.getBody());
        Mockito.verify(jobService, Mockito.times(1)).findById(jobId);
    }

    @Test
    void testGetJobById_JobNotFound() {
        Long jobId = 1L;
        Mockito.when(jobService.findById(jobId)).thenReturn(Optional.empty());
        ResponseEntity<Job> responseEntity = jobController.getJobById(jobId);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
        Mockito.verify(jobService, Mockito.times(1)).findById(jobId);
    }

    @Test
    void testCreateJob() {
        Job jobToCreate = new Job();
        Mockito.when(jobService.save(Mockito.any())).thenReturn(jobToCreate);
        ResponseEntity<Job> responseEntity = jobController.createJob(jobToCreate);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(jobToCreate, responseEntity.getBody());
        Mockito.verify(jobService, Mockito.times(1)).save(jobToCreate);
    }

    @Test
    void testUpdateJob_JobExists() {
        Long jobId = 1L;
        Job jobToUpdate = new Job();
        Mockito.when(jobService.findById(jobId)).thenReturn(Optional.of(jobToUpdate));
        ResponseEntity<Void> responseEntity = jobController.updateJob(jobId, jobToUpdate);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.verify(jobService, Mockito.times(1)).update(jobToUpdate);
    }

    @Test
    void testUpdateJob_JobNotFound() {
        Long jobId = 1L;
        Job jobToUpdate = new Job();
        Mockito.when(jobService.findById(jobId)).thenReturn(Optional.empty());
        ResponseEntity<Void> responseEntity = jobController.updateJob(jobId, jobToUpdate);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        Mockito.verify(jobService, Mockito.never()).update(jobToUpdate);
    }

    @Test
    void testDeleteJob() {
        Long jobId = 1L;
        ResponseEntity<Void> responseEntity = jobController.deleteJob(jobId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.verify(jobService, Mockito.times(1)).deleteById(jobId);
    }
}