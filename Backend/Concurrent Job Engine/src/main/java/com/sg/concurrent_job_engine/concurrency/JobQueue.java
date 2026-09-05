package com.sg.concurrent_job_engine.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import com.sg.concurrent_job_engine.models.Job;


public class JobQueue {

    private final BlockingQueue<Job> queue;

    public JobQueue(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void enqueue(Job job) throws InterruptedException {
        queue.put(job);
    }

    public Job dequeue() throws InterruptedException {
        return queue.take();
    }

    public int size() {
        return queue.size();
    }
}
