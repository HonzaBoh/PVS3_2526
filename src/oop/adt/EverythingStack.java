package oop.adt;

import java.util.EmptyStackException;

public class EverythingStack<E> {
    EverythingStackLink<E> top;

    void push(E value) {
        //stack je prazdny:
        EverythingStackLink<E> newTop = new EverythingStackLink<>();
        newTop.value = value;
        if (top != null) {
            newTop.next = top;
        }
        top = newTop;
    }

    E pop(){
        if (top == null){
            return null;
        }
        E toReturn = top.value;
        top = top.next;
        return toReturn;
    }

    E peek(){
        if (top == null){
            return null;
        }
        return top.value;
    }

}

class EverythingStackLink<E> {
    E value;
    EverythingStackLink<E> next;
}
