package model;

import junit.framework.TestCase;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlaylistOnDiskTest extends TestCase {

    private PlaylistOnDisk playlistOnDisk;


    @Before
    public void setUp() throws Exception {
        // INNER LIST OF COMPOSITION WILL BE FILLED WITH VALUES
//        compositions.add(new Composition("Thunder", "Pop Rock", "imagine dragons", 177 ));
//        compositions.add(new Composition("In the end", "Alternative Rock", "Linkin Park", 217 ));
//        compositions.add(new Composition("Numb", "Alternative Rock", "Linkin Park", 187 ));
//        compositions.add(new Composition("Demons", "Pop Rock", "imagine dragons", 250 ));
//        compositions.add(new Composition("Demons", "Pop Rock", "imagine dragons", 121 ));
        playlistOnDisk = new PlaylistOnDisk();
        playlistOnDisk.fillListOfComposition();



    }


    @Test
    public void testCountDurationOfPlaylist() {

        Assert.assertEquals(952, playlistOnDisk.countDurationOfPlaylist());
    }

    @Test
    public void testFindCompositionByDuration() throws IOException {
        String duration = "\n250";
        ByteArrayInputStream in = new ByteArrayInputStream(duration.getBytes());
        System.setIn(in);
        //додали метод equals() в клас Composition
        Assert.assertTrue(new Composition("demons", "pop rock", "imagine dragons", 250 ).
                equals( playlistOnDisk.findCompositionByDuration()));
    }


    @Test
    public void testFindCompositionByTitle() {
        String title = "\nthunder";
        ByteArrayInputStream in = new ByteArrayInputStream(title.getBytes());
        System.setIn(in);
        Assert.assertTrue(new Composition("thunder", "pop rock", "imagine dragons", 177 ).
                equals( playlistOnDisk.findCompositionByTitle()));
    }

    @Test
    public void testFindCompositionsByAuthor() {
        String author = "\nimagine dragons";
        ByteArrayInputStream in = new ByteArrayInputStream(author.getBytes());
        System.setIn(in);
        List<Composition> expected = new ArrayList<>();
        expected.add(new Composition("thunder", "pop rock", "imagine dragons", 177 ));
        expected.add(new Composition("demons", "pop rock", "imagine dragons", 250 ));
        expected.add(new Composition("demons", "pop rock", "imagine dragons", 121 ));
        Assert.assertTrue(expected.equals(playlistOnDisk.findCompositionsByAuthor()));
    }

    @Test
    public void testFindCompositionsByDurationRange() {
        String minDuration = "\n185";
        String maxDuration = "\n270";
        ByteArrayInputStream in = new ByteArrayInputStream((minDuration + maxDuration).getBytes());
        System.setIn(in);
        List<Composition> expected = new ArrayList<>();
        expected.add(new Composition("in the end", "alternative rock", "linkin park", 217 ));
        expected.add(new Composition("numb", "alternative rock", "linkin park", 187 ));
        expected.add(new Composition("demons", "pop rock", "imagine dragons", 250 ));

        Assert.assertTrue(expected.equals(playlistOnDisk.findCompositionsByDurationRange()));
    }

    @Test
    public void testSortPlaylistByGenre() {
        playlistOnDisk.sortPlaylistByGenre();
    }

    @Test
    public void testDeleteComposition() {
        String title = "\nthunder";
        ByteArrayInputStream in = new ByteArrayInputStream(title.getBytes());
        System.setIn(in);
        List<Composition> expected = new ArrayList<>();
        expected.add(new Composition("in the end", "alternative rock", "linkin park", 217 ));
        expected.add(new Composition("numb", "alternative rock", "linkin park", 187 ));
        expected.add(new Composition("demons", "pop rock", "imagine dragons", 250 ));
        expected.add(new Composition("demons", "pop rock", "imagine dragons", 121 ));

        playlistOnDisk.deleteComposition();
        Assert.assertEquals(expected, playlistOnDisk.compositions);
    }

    @Test
    public void testShowAllPlaylist() {
        playlistOnDisk.showAllPlaylist();
    }

}