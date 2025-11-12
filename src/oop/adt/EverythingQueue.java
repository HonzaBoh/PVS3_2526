package oop.adt;

public class EverythingQueue<E> implements MyQueue<E>{
    EverythingLink<E> first, last;

    @Override
    public void offer(E input) {
        //jdu do fronty jako prvni
        EverythingLink<E> toAdd = new EverythingLink<>();
        toAdd.value = input;

        if (first == null){
            //ted jsem prvni oi posledni ve fronte
            first = toAdd;
            last = toAdd;
        } else {
            //ve fronte uz nekdo je
            last.next = toAdd;
            //==ten, kdo je za poslednim, jsem ja
            last = toAdd;
        }
    }

    @Override
    public E poll() {
        E toReturn = first.value;
        first = first.next;
        return toReturn;
    }

    @Override
    public E peek() {
        return first.value;
    }
}
class EverythingLink<E>{
    E value;
    EverythingLink<E> next;
}
