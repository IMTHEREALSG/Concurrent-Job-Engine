package com.sg.concurrent_job_engine.concurrency;

import com.sg.concurrent_job_engine.models.Job;

public class Worker implements Runnable {
  private final String workerName;
  private final JobQueue jobQueue;

  public Worker(String workerName, JobQueue jobQueue) {
    this.workerName = workerName;
    this.jobQueue = jobQueue;
  }

  @Override
  public void run() {
    while(!Thread.currentThread().isInterrupted()) {
      try {
        Job job = jobQueue.take();
        System.out.println(workerName + " processing job: " + job);
        Thread.sleep(1000);
        System.out.println(workerName + " completed job: " + job);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println(workerName + " stopped.");
        break;
      }
    }
  }


}
