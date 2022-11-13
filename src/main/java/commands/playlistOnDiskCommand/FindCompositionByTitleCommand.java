package commands.playlistOnDiskCommand;


import model.PlaylistOnDisk;

public class FindCompositionByTitleCommand implements Command{


    PlaylistOnDisk playlistOnDisk;

    public FindCompositionByTitleCommand(PlaylistOnDisk playlistOnDisk) {
        this.playlistOnDisk = playlistOnDisk;
    }

    @Override
    public void execute() {
        playlistOnDisk.findCompositionByTitle();
    }
}
