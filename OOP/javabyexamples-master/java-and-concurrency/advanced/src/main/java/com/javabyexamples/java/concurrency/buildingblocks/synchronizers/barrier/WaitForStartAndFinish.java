package com.javabyexamples.java.concurrency.buildingblocks.synchronizers.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitForStartAndFinish {

    public static void main(String[] args) {
        final WaitForStartAndFinish waitForStartAndFinish = new WaitForStartAndFinish();
        waitForStartAndFinish.coordinateStartAndFinish();
    }

    public void coordinateStartAndFinish() {
        final int taskCount = 3;
        final ExecutorService threadPool = Executors.newFixedThreadPool(taskCount);

        final CyclicBarrier barrier = new CyclicBarrier(taskCount,
          () -> System.out.println("All ready to continue!"));

        for (int i = 0; i < taskCount; ++i) {
            threadPool.execute(new Worker(barrier));
        }

        threadPool.shutdown();
    }

    static class Worker implements Runnable {

        private final CyclicBarrier barrier;

        Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        public void run() {
            try {
                System.out.println("Ready to start.");
                barrier.await();

                doWork();

                barrier.await();
                System.out.println("Done.");
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("Interrupted.");
            } catch (BrokenBarrierException ex) {
                System.out.println("Broken barrier.");
            }
        }

        public void doWork() {
            System.out.println("Doing work.");
        }
    }
}
