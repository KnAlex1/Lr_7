package commands.playlistOnDiskCommand;


import model.PlaylistOnDisk;

public class FindCompositionByDurationCommand implements Command{

    PlaylistOnDisk playlistOnDisk;

    public FindCompositionByDurationCommand(PlaylistOnDisk playlistOnDisk) {
        this.playlistOnDisk = playlistOnDisk;
    }

    @Override
    public void execute() {

        playlistOnDisk.findCompositionByDuration();
    }
}
