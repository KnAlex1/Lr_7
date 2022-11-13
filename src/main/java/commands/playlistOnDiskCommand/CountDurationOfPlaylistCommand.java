package commands.playlistOnDiskCommand;


import model.PlaylistOnDisk;

public class CountDurationOfPlaylistCommand implements Command{
    PlaylistOnDisk playlistOnDisk;

    public CountDurationOfPlaylistCommand(PlaylistOnDisk playlistOnDisk) {
        this.playlistOnDisk = playlistOnDisk;
    }

    @Override
    public void execute() {
        playlistOnDisk.countDurationOfPlaylist();
    }
}
