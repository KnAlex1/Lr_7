package commands.playlistOnDiskCommand;


import model.PlaylistOnDisk;

public class DeleteCompositionCommand implements Command{
    PlaylistOnDisk playlistOnDisk;

    public DeleteCompositionCommand(PlaylistOnDisk playlistOnDisk) {
        this.playlistOnDisk = playlistOnDisk;
    }

    @Override
    public void execute() {
        playlistOnDisk.deleteComposition();
    }
}
