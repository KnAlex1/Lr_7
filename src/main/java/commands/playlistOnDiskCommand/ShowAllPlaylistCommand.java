package commands.playlistOnDiskCommand;


import model.PlaylistOnDisk;

public class ShowAllPlaylistCommand implements Command{
    PlaylistOnDisk playlistOnDisk;

    public ShowAllPlaylistCommand(PlaylistOnDisk playlistOnDisk) {
        this.playlistOnDisk = playlistOnDisk;
    }

    @Override
    public void execute() {
        playlistOnDisk.showAllPlaylist();
    }
}
