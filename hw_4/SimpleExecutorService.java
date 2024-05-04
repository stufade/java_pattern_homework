package hw_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleExecutorService {
    private final List<WorkerThread> workerThreads;
    private final BlockingQueue<Runnable> taskQueue;

    public SimpleExecutorService(int numThreads) {
        this.workerThreads = new ArrayList<>(numThreads);
        this.taskQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < numThreads; i++) {
            WorkerThread workerThread = new WorkerThread();
            workerThread.start();
            workerThreads.add(workerThread);
        }
    }

    public void submit(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        for (WorkerThread workerThread : workerThreads) {
            workerThread.interrupt();
        }
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleExecutorService executorService = new SimpleExecutorService(5);

        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskNumber + " executed by thread " + Thread.currentThread().getName());
            });
        }

        Thread.sleep(100);

        executorService.shutdown();
    }
}
