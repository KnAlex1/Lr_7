package commands.playlistOnDiskCommand;


import model.PlaylistOnDisk;

public class FindCompositionsByDurationRangeCommand implements Command{
    PlaylistOnDisk playlistOnDisk;

    public FindCompositionsByDurationRangeCommand(PlaylistOnDisk playlistOnDisk) {
        this.playlistOnDisk = playlistOnDisk;
    }

    @Override
    public void execute() {
        playlistOnDisk.findCompositionsByDurationRange();
    }
}
