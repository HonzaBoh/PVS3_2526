package oop.adt;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StringMyStack implements MyStack {
    private static final int RESIZE_FACTOR = 2;

    private String[] data;
    private int top;

    public StringMyStack(int size) {
        this.data = new String[size];
        top = -1;
    }

    @Override
    public void push(String value) {
        if(top >= data.length - 1){
            data = Arrays.copyOf(data, RESIZE_FACTOR);
        }

        data[top + 1] = value;
        top++;

//        data[++top] = value;
    }

    @Override
    public String pop() {
        if(isEmpty()){
            System.out.println("Empty Stack");
            throw new EmptyStackException();
        }

        String toReturn = data[top];
        top--;
        return toReturn;

        // return data[top--];
    }

    @Override
    public String peek() {
        if(isEmpty()){
            System.out.println("Empty Stack");
            throw new EmptyStackException();
        }

        return data[top];
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        MyStack zasobnik = new StringMyStack(10_000);


        for (int i = 1; i < 10_000; i++) {
            zasobnik.push(String.format("page %d", i));
//            zasobnik.push("page " + i);
        }
        while(!zasobnik.isEmpty()){
            System.out.println(zasobnik.pop());
        }

    }
}
