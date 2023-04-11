package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class manageSongs  {
    public Song[] songs;
    public int numOfSongs;



   public  manageSongs() throws FileNotFoundException{
        songs= new Song[100];
        numOfSongs=0;
        text();
    }
    public void addSongs(String songName, String artist, int id, String genre, int year){
        songs[numOfSongs]= new Song(songName,artist,id,genre,year);
        numOfSongs++;
    }
    public void printSongs(){
       for (int i=0; i<line();i++){
           System.out.println(songs[i].toString());
       }
    }



public void text() throws FileNotFoundException{
        File f = new File("songs.txt");
        Scanner scF= new Scanner(f);
        int i=0;
        while(scF.hasNext()) {
            String s = scF.nextLine();
            Scanner scr = new Scanner(s);
            scr.useDelimiter(";");
            String songName, genre, artist;
            int id, year;
            songName = scr.next();
            artist = scr.next();
            id = scr.nextInt();
            genre = scr.next();
            year = scr.nextInt();
            addSongs(songName, artist, id, genre, year);
            i++;
        }
        }

    public  int line(){
        int i=0;
            File file = new File("songs.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(sc.hasNextLine()) {
                sc.nextLine();
                i++;
            }
            sc.close();
       return i;
    }



}