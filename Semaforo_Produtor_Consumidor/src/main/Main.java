package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    static final int  BUFFER_SIZE = 10;
    final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        // Instancia produtores
        Thread p1 = new Thread(new Produtor(buffer, "Producer 1", 500));
        Thread p2 = new Thread(new Produtor(buffer, "Producer 2", 400));

        // Instancia consumidores
        Thread[] consumers = {
            new Thread(new Consumidor(buffer, "Consumer 1", 700)),
            new Thread(new Consumidor(buffer, "Consumer 2", 400)),
            new Thread(new Consumidor(buffer, "Consumer 3", 500)),
            new Thread(new Consumidor(buffer, "Consumer 4", 550)),
            new Thread(new Consumidor(buffer, "Consumer 5", 600))
        };

        // Inicia consumidores
        for (Thread c : consumers) c.start();

        // Inicia produtores
        p1.start();
        p2.start();
    }
}
