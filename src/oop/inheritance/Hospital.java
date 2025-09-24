package oop.inheritance;

import javax.print.Doc;

public class Hospital {

    public static void main(String[] args) {
        Doctor doc = new Doctor("Karel", 60000);
        System.out.println(doc);

        Surgeon sur = new Surgeon("Pepa", 70000);
        System.out.println(sur);

        Doctor[] personnel = {doc, sur};

        System.out.println("Je chirurg doktor? " + (sur instanceof Doctor));
        CardiacSurgeon legitOne = new CardiacSurgeon("Alfred", 50000);

        Doctor fakeOne = new CardiacSurgeon("Lukas", 50000);

        System.out.println(fakeOne);
        //jak ho donutit delat neco vic?
        int a = (int) 4.5;
        //varianta 1: ulozim do promenny, kde uz to bude umet
        CardiacSurgeon reference = (CardiacSurgeon) fakeOne;
        reference.cardiacSurgery();
        //fuj

        //pretypuj a zaroven neco udelej (to, co normlne nemuzes)
        ((CardiacSurgeon)fakeOne).cardiacSurgery();

        Doctor[] alsoPersonnel = {doc, sur, legitOne, fakeOne};

        for (int i = 0; i < alsoPersonnel.length; i++) {
            //zkuste vsichni diagnostikovat:
            alsoPersonnel[i].diagnose();
            //tohle zkazi bohuzel ten jenom doktor:
//            ((Surgeon)alsoPersonnel[i]).surgery();
            //ohlidam si, ze doopravdy muze
            if (alsoPersonnel[i] instanceof Surgeon){
                ((Surgeon)alsoPersonnel[i]).surgery();
            }
        }
    }
}
