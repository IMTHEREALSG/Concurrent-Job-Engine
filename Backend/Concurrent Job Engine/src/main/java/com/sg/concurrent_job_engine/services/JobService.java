package com.sg.concurrent_job_engine.services;

import com.sg.concurrent_job_engine.concurrency.JobQueue;
import com.sg.concurrent_job_engine.models.Job;
import org.springframework.stereotype.Service;

@Service
public class JobService {

  private final JobQueue jobQueue;

  public JobService(JobQueue jobQueue) {
    this.jobQueue = jobQueue;
  }

  public void submit(Job job) throws InterruptedException {
    jobQueue.submit(job);
  }
}
