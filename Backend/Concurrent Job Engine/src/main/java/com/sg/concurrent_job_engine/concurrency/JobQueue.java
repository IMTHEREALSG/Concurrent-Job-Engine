package com.sg.concurrent_job_engine.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import com.sg.concurrent_job_engine.models.Job;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JobQueue {

    private final BlockingQueue<Job> queue;

    public JobQueue(@Value("${job.queue.capacity}") int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void submit(Job job) throws InterruptedException {
        queue.put(job);
    }

    public Job take() throws InterruptedException {
        return queue.take();
    }

    public int size() {
        return queue.size();
    }
}
