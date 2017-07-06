package demo;

import java.util.concurrent.ArrayBlockingQueue;

public class FixedSizeQueue<E> extends ArrayBlockingQueue<E> {

    // Size of the queue
    private int queueSize;

    // Constructor
    public FixedSizeQueue(int size) {

        // Create an ArrayBlockingQueue with fixed capacity
        super(size);
        this.queueSize = size;
    }

    // When queue is full, remove the oldest element as in FIFO
    // Synchronize it for thread-safe
    @Override
    synchronized public boolean add(E e) {

        // Check if queue is full
        if (super.size() == this.queueSize) {
            // remove one element before add another
            this.remove();
        }

        return super.add(e);
    }

}
