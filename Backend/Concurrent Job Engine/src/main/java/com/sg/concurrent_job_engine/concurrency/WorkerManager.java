package com.sg.concurrent_job_engine.concurrency;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerManager {
  private final JobQueue jobQueue;

  private final List<Thread> workers = new ArrayList<>();

  public WorkerManager(JobQueue jobQueue) {
    this.jobQueue = jobQueue;
  }

  @PostConstruct
  public void startWorkers() {
    for (int i = 0; i < 3; i++) {
      Worker worker = new Worker("Worker-" + (i + 1), jobQueue);
      Thread workerThread = new Thread(worker);
      workers.add(workerThread);
      workerThread.start();
    }
    System.out.println("3 workers started.");
  }
}
