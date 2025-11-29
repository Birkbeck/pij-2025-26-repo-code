package pij.day06solutions.artists;

import pij.day06.artists.Singer;

/**
 * A SingerSongwriter can both sing and write songs.
 */
public class SingerSongwriter extends Singer {
    // Remove the "/*" and the "*/" in the previous line.
    // Will the code still compile? Why (not)?

    // Answer (Ex 7):
    // The code no longer compiled. The reason is that class SingerSongwriter
    // did not have an explicit constructor. This caused the Java compiler to
    // create a default constructor for class SingerSongwriter. This
    // constructor corresponds to:
    //
    // public SingerSongwriter() {
    //     super();
    // }
    //
    // Since the superclass Singer does not have a constructor without
    // parameters (that could be called from SingerSongwriter), the Java
    // compiler reports a compile error.
    //
    // The issue can be resolved by making an explicit call to an existing
    // superclass constructor in our own constructor:
    public SingerSongwriter(String name) {
        super(name);
    }


    /**
     * Writes a song with a given title.
     *
     * @param title the song title
     */
    public void writeSong(String title) {
        System.out.println("Writing song with title: " + title);
    }
}
