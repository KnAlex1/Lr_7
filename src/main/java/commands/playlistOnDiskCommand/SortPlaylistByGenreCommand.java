package commands.playlistOnDiskCommand;


import model.PlaylistOnDisk;

public class SortPlaylistByGenreCommand implements Command{
    PlaylistOnDisk playlistOnDisk;

    public SortPlaylistByGenreCommand(PlaylistOnDisk playlistOnDisk) {
        this.playlistOnDisk = playlistOnDisk;
    }

    @Override
    public void execute() {
        playlistOnDisk.sortPlaylistByGenre();
    }
}
