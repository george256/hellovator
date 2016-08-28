package com.objects;

import java.util.concurrent.Semaphore;

public abstract class Agent {
    Semaphore permit = new Semaphore(1, true);
    private AgentThread thread;

    private class AgentThread extends Thread {
        public void run() {
            while(!currentThread().isInterrupted()) {
                try {
                    permit.acquire();
                } catch (InterruptedException e) {
                    currentThread().interrupt();
                }
                while(decide());
            }
        }
    }

    public synchronized void startThread() {
        if(thread == null) {
            thread = new AgentThread();
            thread.start();
        }
    }

    public abstract boolean decide();
}
