package oop.adt;

import java.util.*;

public class Queues {

    static void magicPause(int amount){
        try {
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            System.out.println(":(");
        }
    }

    public static void main(String[] args) {
//        MyQueue<String> stringMyQueue = new EverythingQueue<>();
//        stringMyQueue.offer("hello");
//        stringMyQueue.offer("world");
//        System.out.println(stringMyQueue.peek());
//        System.out.println(stringMyQueue.poll());
//        stringMyQueue.offer("test");
//        System.out.println(stringMyQueue.poll());


        //ruleta:
        EverythingQueue<Player> roulette = new EverythingQueue<>();
        roulette.offer(new Player("Petr"));
        roulette.offer(new Player("Krtek"));
        roulette.offer(new Player("Robert"));
        roulette.offer(new Player("Kerád"));
        roulette.offer(new Player("Lučišník"));
        roulette.offer(new Player("Pes"));

        while (roulette.first != roulette.last){
            System.out.println("Právě hraje: " + roulette.peek().getName());
            magicPause(2000);
            if (Math.random() <= .16) {
                System.out.println(roulette.poll().name + ".... :(");
            } else {
                System.out.println(roulette.peek().name + " ...mel stesti (zatim)");
                roulette.offer(roulette.poll());
            }
        }
        System.out.println("Last man standing: " + roulette.peek().name);

        //nativne
        Queue<Player> also = new LinkedList<>();
    }

}
class Player{
    String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}