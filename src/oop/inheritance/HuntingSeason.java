package oop.inheritance;

import java.util.ArrayList;
import java.util.Random;

public class HuntingSeason {

    static void doRandomJob(Hunter hunter){
        Random r = new Random();

        switch(r.nextInt(1,4)){
            case 1:
                hunter.hunt();
                break;
            case 2:
                ((Soldier) hunter).killBandits();
                break;
            case 3:
                ((Witcher) hunter).slayMonster();
                break;
        }
    }



    public static void main(String[] args) {
//        Hunter hunter = new Hunter("Theodore Roosvelt");
//        hunter.hunt();
//
//        System.out.println(hunter.name + " má " + hunter.gold);
//
//        Soldier soldier = new Soldier("Solid Snake");
//        soldier.hunt();
//        soldier.killBandits();
//
//        System.out.println(soldier.name + " má " + soldier.gold);
//
//        Witcher witcher = new Witcher("Vesemir");
//        witcher.hunt();
//        witcher.killBandits();
//        witcher.slayMonster();
//
//        System.out.println(witcher.name + " má " + witcher.gold);

//    Hunter randomak = new Witcher("Eskel");
//    Soldier another = new Soldier("Eskel");
//    randomak.hunt();
//
//    ((Witcher) randomak).slayMonster();
//    ((Witcher) another).slayMonster();

        ArrayList<Hunter> hunters = new ArrayList<>();
        hunters.add(new Hunter("Hornet"));
        hunters.add(new Soldier("George S Patton"));
        hunters.add(new Soldier("Robert Duvall"));
        hunters.add(new Witcher("Geralt"));
        hunters.add(new Witcher("Coën"));

        for(Hunter hunter : hunters){
            doRandomJob(hunter);
        }
    }
}
