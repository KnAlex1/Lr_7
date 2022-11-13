package model;
import commands.playlistOnDiskCommand.Command;

public class User {

    Command createComposition;
    Command deleteComposition;
    Command showAllPlaylist;
    Command countDurationOfPlaylist;
    Command findCompositionByDuration;
    Command findCompositionByTitle;
    Command findCompositionsByAuthor;
    Command findCompositionsByDurationRange;
    Command sortPlaylistByGenre;

    public User( Command createComposition, Command deleteComposition,Command showAllPlaylist,
                 Command countDurationOfPlaylist, Command findCompositionByDuration, Command findCompositionByTitle,
                 Command findCompositionsByAuthor, Command findCompositionsByDurationRange, Command sortPlaylistByGenre) {
        this.createComposition = createComposition;
        this.deleteComposition = deleteComposition;
        this.showAllPlaylist = showAllPlaylist;
        this.countDurationOfPlaylist = countDurationOfPlaylist;
        this.findCompositionByDuration = findCompositionByDuration;
        this.findCompositionByTitle = findCompositionByTitle;
        this.findCompositionsByAuthor = findCompositionsByAuthor;
        this.findCompositionsByDurationRange = findCompositionsByDurationRange;
        this.sortPlaylistByGenre = sortPlaylistByGenre;
    }


    public void countDurationOfPlaylist(){
        countDurationOfPlaylist.execute();
    }

    public void findCompositionByDuration(){
        findCompositionByDuration.execute();
    }
    public void findCompositionByTitle(){
        findCompositionByTitle.execute();
    }
    public void findCompositionsByAuthor(){
        findCompositionsByAuthor.execute();
    }
    public void findCompositionsByDurationRange(){
        findCompositionsByDurationRange.execute();
    }
    public void sortPlaylistByGenre(){
        sortPlaylistByGenre.execute();
    }

    public void createComposition(){
        createComposition.execute();
    }

    public void deleteComposition(){
        deleteComposition.execute();
    }

    public void showAllPlaylist(){
        showAllPlaylist.execute();
    }




}
