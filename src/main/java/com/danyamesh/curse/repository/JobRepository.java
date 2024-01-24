package com.danyamesh.curse.repository;

import com.danyamesh.curse.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
