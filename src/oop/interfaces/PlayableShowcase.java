package oop.interfaces;

import java.util.Comparator;

public class PlayableShowcase {
    public static void main(String[] args) {
        //je mi jedno, co ty metody delaji, ale oboji je playable
        Playable[] media = {new Video("Neco.avi"), new Audio("Song.mp3")};
        media[0].play();
        media[1].play();
    }
}
class Video implements Playable {

    String fileName;

    public Video(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void play() {
        System.out.println("Booting video player...");
        System.out.println("Playing video...");
    }

    @Override
    public void printFormat() {
        //"neco.mp4" -> "mp4"
        System.out.println("Format: " + this.fileName.split("\\.")[this.fileName.split("\\.").length-1]);
    }

    @Override
    public String toString() {
        return "Video{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
class Audio implements Playable{
    String fileName;

    public Audio(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void play() {
        System.out.println("plin plin plon");
    }

    @Override
    public void printFormat() {
        System.out.println("Is it mp3? " + fileName.endsWith("mp3"));
    }
}