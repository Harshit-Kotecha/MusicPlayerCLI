import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private final ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public void addSong(Song song) {
        if (doesSongExistsInAlbum(song)) {
//            System.out.println("Song already present");
            return;
        }
        songs.add(song);
//        System.out.println("Song added");
    }

    public void addSongToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        if (trackNumber > songs.size() || trackNumber <= 0 || doesSongExists(playlist, songs.get(trackNumber - 1))) {
            return;
        }
        playlist.add(songs.get(trackNumber - 1));
    }

    public boolean addSongToPlaylist(String title, LinkedList<Song> playlist) {
        for (Song song : this.songs) {
            if (song.title.equals(title)) {
                playlist.add(song);
                return true;
            }
        }
        return false;
    }

    private boolean doesSongExists(LinkedList<Song> playlist, Song song) {
        for (Song _song : playlist) {
            if (_song.equals(song)) {
                return true;
            }
        }
        return false;
    }

    private boolean doesSongExistsInAlbum(Song song) {
        for (Song _song : songs) {
            if (_song.equals(song)) {
                return true;
            }
        }
        return false;
    }


}
