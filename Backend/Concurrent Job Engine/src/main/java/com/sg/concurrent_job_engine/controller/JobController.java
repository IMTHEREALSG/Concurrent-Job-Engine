package com.sg.concurrent_job_engine.controller;

import com.sg.concurrent_job_engine.models.Job;
import com.sg.concurrent_job_engine.services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/jobs")
class JobController {
  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @PostMapping
  public ResponseEntity<String> submitJob(
          @RequestBody Job job) throws InterruptedException {

    jobService.submit(job);

    return ResponseEntity.ok(
            "Job " + job.id() + " submitted"
    );
  }
}
