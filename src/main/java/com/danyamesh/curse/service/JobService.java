package com.danyamesh.curse.service;

import com.danyamesh.curse.model.Job;
import com.danyamesh.curse.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobService implements BaseService<Job, Long> {
    private final JobRepository jobRepository;

    @Override
    public Job save(Job entity) {
        return jobRepository.save(entity);
    }

    @Override
    public Optional<Job> findById(Long aLong) {
        return jobRepository.findById(aLong);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void update(Job entity) {
        jobRepository.save(entity);
    }

    @Override
    public void delete(Job entity) {
        jobRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        jobRepository.deleteById(aLong);
    }
}
