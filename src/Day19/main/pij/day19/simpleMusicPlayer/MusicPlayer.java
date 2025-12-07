package pij.day19.simpleMusicPlayer;

import java.util.List;

/**
 * Exercise 2.
 * A simple music player that can play, pause, stop, and navigate through a
 * playlist of songs. The MusicPlayer class manages the playback state and
 * separates the model from the GUI.
 *
 * This class is provided as part of a question. Do not modify it.
 */
public class MusicPlayer {

    private boolean isPlaying;
    private int playlistIndex;
    private List<String> playlist;

    /**
     * Creates a new MusicPlayer with a default playlist.
     */
    public MusicPlayer() {
        playlist = getDefaultPlaylist();
    }

    /**
     * Stops the music playback.
     */
    public void stop() {
        System.out.println("Stopping music...");
        isPlaying = false;
    }

    /**
     * Starts or resumes the music playback.
     */
    public void play() {
        System.out.println("Playing music...");
        isPlaying = true;
    }

    /**
     * Pauses the music playback.
     */
    public void pause() {
        System.out.println("Pausing music...");
    }

    /**
     * Skips to the next track in the playlist. Will loop back to the start
     * if at the end.
     */
    public void forward() {
        playlistIndex = (playlistIndex + 1) % playlist.size();
        System.out.println("Skipping to next track...");
    }

    /**
     * Goes back to the previous track in the playlist. Will loop to the end
     * if at the start.
     */
    public void backward() {
        playlistIndex = (playlistIndex - 1 + playlist.size()) % playlist.size();
        System.out.println("Going back to previous track...");
    }

    /**
     * Gets the title of the current song.
     *
     * @return The title of the current song.
     */
    public String getSongTitle() {
        return playlist.get(playlistIndex);
    }

    /**
     * Checks if the player is currently playing music.
     *
     * @return true if music is playing, false otherwise.
     */
    public boolean isPlaying() {
        return isPlaying;
    }

    /**
     * Returns a default playlist for a music player.
     *
     * @return a default playlist
     */
    private static List<String> getDefaultPlaylist() {
        return List.of("Last Christmas - Wham!",
                "All I want for Christmas is you - Mariah Carey",
                "Jingle Bells - Frank Sinatra",
                "I saw Mommy kissing Santa Claus - Jackson 5",
                "I wish it could be Christmas everyday - Wizzard");
    }

}
