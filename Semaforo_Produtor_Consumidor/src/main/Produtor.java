package main;

import java.util.concurrent.BlockingQueue;

public class Produtor implements Runnable {
	private final BlockingQueue<Integer> buffer;
	private final String name;
	private final long delay;
	private int counter = 0;

	public Produtor(BlockingQueue<Integer> buffer, String name, long delay) {
		this.buffer = buffer;
		this.name = name;
		this.delay = delay;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int item = ++counter;
				buffer.put(item); // Bloqueia se o buffer estiver cheio
				System.out.printf("[%s] Producing => Item %d. Buffer size: %d\n", name, item, buffer.size());
				Thread.sleep(delay);
			}
		} catch (InterruptedException e) {
			System.out.printf("[%s] Producer interrupted.\n", name);
			Thread.currentThread().interrupt();
		}
	}
}
