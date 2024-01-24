package com.danyamesh.curse.controller;

import com.danyamesh.curse.model.Job;
import com.danyamesh.curse.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@Slf4j
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        try {
            List<Job> jobs = jobService.findAll();
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            log.error("Error occurred while fetching all jobs", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        try {
            Optional<Job> job = jobService.findById(jobId);
            return job.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            log.error("Error occurred while fetching job by ID: " + jobId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        try {
            Job createdJob = jobService.save(job);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
        } catch (Exception e) {
            log.error("Error occurred while creating a new job", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<Void> updateJob(@PathVariable Long jobId, @RequestBody Job job) {
        try {
            if (jobService.findById(jobId).isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            job.setId(jobId);
            jobService.update(job);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error occurred while updating job with ID: " + jobId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long jobId) {
        try {
            jobService.deleteById(jobId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error occurred while deleting job with ID: " + jobId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
