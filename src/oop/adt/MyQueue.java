package oop.adt;

import java.util.Queue;

public interface MyQueue<E> {

    /**
     * Vlozi neco do fronty
     * @param input to, co ma vlozit
     */
    void offer(E input);

    /**
     * Vezme prvek z fronty a odstrani jej z fronty, metoda FIFO
     * @return 'prvni' pridany prvek do fronty
     */
    E poll();

    /**
     * Vezme prvek z fronty, metoda FIFO
     * @return 'prvni' pridany prvek do fronty
     */
    E peek();
}
