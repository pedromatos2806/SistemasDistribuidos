package main;

import java.util.concurrent.BlockingQueue;
public class Consumidor implements Runnable{

	    private final BlockingQueue<Integer> buffer;
	    private final String name;
	    private final long delay;

	    public Consumidor(BlockingQueue<Integer> buffer, String name, long delay) {
	        this.buffer = buffer;
	        this.name = name;
	        this.delay = delay;
	    }

	    @Override
	    public void run() {
	        try {
	            while (true) {
	                int item = buffer.take(); // Bloqueia se o buffer estiver vazio
	                System.out.printf("[%s] Consuming => Item %d. Buffer size: %d\n", name, item, buffer.size());
	                Thread.sleep(delay);
	            }
	        } catch (InterruptedException e) {
	            System.out.printf("[%s] Consumer interrupted.\n", name);
	            Thread.currentThread().interrupt();
	        }
	    }
}
