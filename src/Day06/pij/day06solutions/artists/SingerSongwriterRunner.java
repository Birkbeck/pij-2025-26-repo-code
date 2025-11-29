package pij.day06solutions.artists;

public class SingerSongwriterRunner {
    public static void main(String[] args) {
        SingerSongwriter artist = new SingerSongwriter("Suzanne Vega");
        System.out.println(artist.getName());
        artist.writeSong("Tom's Diner");
        artist.sing("Tom's Diner");
    }
}
