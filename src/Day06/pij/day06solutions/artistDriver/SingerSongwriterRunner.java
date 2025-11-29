package pij.day06solutions.artistDriver;

import pij.day06solutions.artists.SingerSongwriter;

public class SingerSongwriterRunner {
    public static void main(String[] args) {
        // Ex 8
        SingerSongwriter artist = new SingerSongwriter("Suzanne Vega");
        // The methods need to be public. For the other three visibility
        // modifier options, the code does not compile.
        System.out.println(artist.getName());
        artist.writeSong("Tom's Diner");
        artist.sing("Tom's Diner");
    }
}
