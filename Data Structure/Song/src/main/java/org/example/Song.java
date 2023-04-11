package org.example;
public class Song {
 public String songName;
 public String artist;
 public int id;
 public String genre;
 public int year;

 Song() {
 }

 Song(String songName, String artist, int id, String genre, int year) {
  this.id = id;
  this.year = year;
  this.songName = songName;
  this.genre = genre;
  this.artist = artist;
 }

 @Override
 public String toString() {
  return "Song{" +
          "songName='" + songName + '\'' +
          ", artist='" + artist + '\'' +
          ", id=" + id +
          ", genre='" + genre + '\'' +
          ", year=" + year +
          '}';
 }
}



