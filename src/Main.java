import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("album1", "Eminem");
        album.addSong(new Song("Song", 4.5));
        album.addSong(new Song("Song 2", 4.5));
        album.addSong(new Song("Song 3", 4.5));

        albums.add(album);

        album = new Album("album2", "Krishna");
        album.addSong(new Song("New song", 4.5));
        album.addSong(new Song("new Song 2", 4.5));
        album.addSong(new Song("new Song 3", 4.5));

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addSongToPlaylist(1, playlist);
        albums.get(0).addSongToPlaylist(1, playlist);
        albums.get(1).addSongToPlaylist(2, playlist);
        albums.get(1).addSongToPlaylist(3, playlist);

    }
}
