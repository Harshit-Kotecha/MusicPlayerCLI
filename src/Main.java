import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Album 1", "A R.");
        album.addSong(new Song("Song 1", 4.5));
        album.addSong(new Song("Song 2", 4.5));
        album.addSong(new Song("Song 3", 4.5));
        album.addSong(new Song("Song 4", 4.5));
        album.addSong(new Song("Song 5", 4.5));

        albums.add(album);

        album = new Album("album2", "Krishna");
        album.addSong(new Song("New song", 4.5));
        album.addSong(new Song("new Song 2", 4.5));
        album.addSong(new Song("new Song 3", 4.5));

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addSongToPlaylist(1, playlist);
        albums.get(0).addSongToPlaylist(1, playlist);
        albums.get(0).addSongToPlaylist(1, playlist);
        albums.get(0).addSongToPlaylist(3, playlist);
        albums.get(1).addSongToPlaylist(2, playlist);
        albums.get(1).addSongToPlaylist(3, playlist);

        play(playlist);
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> songListIterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("This playlist has no songs");
        } else {
            System.out.println("Playing " + songListIterator.next().toString() + "...");
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (songListIterator.hasNext()) {
                            songListIterator.next();
                        }
                        forward = true;
                    }
                    if (songListIterator.hasNext()) {
                        System.out.println(songListIterator.next().toString());
                    } else {
                        System.out.println("You have reached at the end");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (songListIterator.hasPrevious()) {
                            songListIterator.previous();
                        }
                        forward = false;
                    }
                    if (songListIterator.hasPrevious()) {
                        System.out.println(songListIterator.previous().toString());
                    } else {
                        System.out.println("No previous song available");
                        forward = true;
                    }
                    break;
                case 3:
//                    if (!forward) {
//                        if (songListIterator.hasNext()) {
//                            System.out.println(songListIterator.next().toString());
//                            // forward = false;
//                        } else {
//                            System.out.println("You are at the start of the list");
//                        }
//                    } else {
                    if (songListIterator.hasNext()) {
                        System.out.println(songListIterator.next().toString());
                        // forward = true;
                    } else {
                        System.out.println("This is the last song");
                    }
//                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (!playlist.isEmpty()) {
                        songListIterator.remove();
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing " + songListIterator.next().toString());
                        } else if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing" + songListIterator.previous().toString());
                        } else {
                            System.out.println("No song left in playlist");
                        }
                    }
                    break;
                default:
                    System.out.println("Please choose from the available options only");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Press 0 to quit");
        System.out.println("Press 1 to play next");
        System.out.println("Press 2 to play previous");
        System.out.println("Press 3 to play current song");
        System.out.println("Press 4 to print all songs");
        System.out.println("Press 5 to print all available options");
        System.out.println("Press 6 to delete the song");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> songIterator = playlist.iterator();

        System.out.println("----------------------------------------");

        while (songIterator.hasNext()) {
            System.out.println(songIterator.next());
        }

        System.out.println("----------------------------------------");
    }
}
