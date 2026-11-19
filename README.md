# Job Scheduling Management System

A Java console application that manages jobs using an array-based queue. Jobs are executed in the order they are added (First Come, First Served).

## Compile and run

Requires JDK 8 or later. From this folder run:

```
javac JobScheduling.java
java JobScheduling
```

## Features

- **Add Job**: enter a Job ID and Job Name and add it to the queue
- **Display Jobs**: show all pending jobs with their index, and mark the FRONT and REAR positions
- **Execute Job**: remove and run the job at the front of the queue
- **Search Job**: find a pending job by its Job ID
- **Exit**: close the program

## Menu

```
===== JOB SCHEDULING MANAGEMENT =====
1. Add Job
2. Display Jobs
3. Execute Job
4. Search Job
5. Exit
```

## How it works

The program stores job IDs and job names in two arrays used as a queue, with two pointers:

- `front` points to the next job to be executed
- `rear` points to the most recently added job

Adding a job moves `rear` forward by one. Executing a job removes the job at `front` and moves `front` forward. When the last job is executed, both pointers reset to -1 and the queue is empty.

| Operation | Time complexity |
|-----------|-----------------|
| Add Job | O(1) |
| Execute Job | O(1) |
| Display Jobs | O(n) |
| Search Job | O(n) |

## Limits

- The queue holds a maximum of 50 jobs.
- Job IDs are integers.
