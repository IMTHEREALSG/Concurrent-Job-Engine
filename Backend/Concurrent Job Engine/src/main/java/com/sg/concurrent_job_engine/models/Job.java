package com.sg.concurrent_job_engine.models;

import java.time.Instant;

public record Job(int id, String name, String description, Instant createdAt) {

}