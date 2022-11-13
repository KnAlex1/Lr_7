package model;

import commands.playlistOnDiskCommand.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class UserTest {

    private User user;
    private PlaylistOnDisk playlistOnDisk;

    @Before
    public void setUpUser() {
        playlistOnDisk = new PlaylistOnDisk();
        playlistOnDisk.fillListOfComposition();
        // INNER LIST OF COMPOSITION WILL BE FILLED WITH VALUES
//        compositions.add(new Composition("Thunder", "Pop Rock", "imagine dragons", 177 ));
//        compositions.add(new Composition("In the end", "Alternative Rock", "Linkin Park", 217 ));
//        compositions.add(new Composition("Numb", "Alternative Rock", "Linkin Park", 187 ));
//        compositions.add(new Composition("Demons", "Pop Rock", "imagine dragons", 250 ));
//        compositions.add(new Composition("Demons", "Pop Rock", "imagine dragons", 121 ));
        user = new User(new CreateCompositionCommand(playlistOnDisk), new DeleteCompositionCommand(playlistOnDisk),
                new ShowAllPlaylistCommand(playlistOnDisk), new CountDurationOfPlaylistCommand(playlistOnDisk), new FindCompositionByDurationCommand(playlistOnDisk),
                new FindCompositionByTitleCommand(playlistOnDisk), new FindCompositionsByAuthorCommand(playlistOnDisk),
                new FindCompositionsByDurationRangeCommand(playlistOnDisk), new SortPlaylistByGenreCommand(playlistOnDisk));
    }


    @Test
    public void testCountDurationOfPlaylist() {
       user.countDurationOfPlaylist();
    }

    @Test
    public void testFindCompositionByDuration() {
        String duration = "\n250";
        ByteArrayInputStream in = new ByteArrayInputStream(duration.getBytes());
        System.setIn(in);
        user.findCompositionByDuration();
    }

    @Test
    public void testFindCompositionByTitle() {
        String title = "\nthunder";
        ByteArrayInputStream in = new ByteArrayInputStream(title.getBytes());
        System.setIn(in);
        user.findCompositionByTitle();
    }

    @Test
    public void testFindCompositionsByAuthor() {
        String author = "\nimagine dragons";
        ByteArrayInputStream in = new ByteArrayInputStream(author.getBytes());
        System.setIn(in);
        user.findCompositionsByAuthor();
    }

    @Test
    public void testFindCompositionsByDurationRange() {
        String minDuration = "\n185";
        String maxDuration = "\n270";
        ByteArrayInputStream in = new ByteArrayInputStream((minDuration + maxDuration).getBytes());
        System.setIn(in);
        user.findCompositionsByDurationRange();
    }

    @Test
    public void testSortPlaylistByGenre() {
        user.sortPlaylistByGenre();
    }


    @Test
    public void testDeleteComposition() {
        String title = "\nnumb";
        ByteArrayInputStream in = new ByteArrayInputStream(title.getBytes());
        System.setIn(in);

        int lengthOfListBeforeDeleting = playlistOnDisk.compositions.size();
        user.deleteComposition();
        int lengthOfListAfterDeleting = playlistOnDisk.compositions.size();
        Assert.assertTrue(lengthOfListBeforeDeleting - lengthOfListAfterDeleting == 1);
    }

    @Test
    public void testShowAllPlaylist() {
        user.showAllPlaylist();
    }
}