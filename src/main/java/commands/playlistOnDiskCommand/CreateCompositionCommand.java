package commands.playlistOnDiskCommand;


import model.PlaylistOnDisk;

import static menu.MenuUtils.in;

public class CreateCompositionCommand implements Command{

    PlaylistOnDisk playlistOnDisk;

    public CreateCompositionCommand(PlaylistOnDisk playlistOnDisk) {
        this.playlistOnDisk = playlistOnDisk;
    }

    @Override
    public void execute() {
        try {
            do {
                //Вибрати заповнення вручну чи з автоматичного заповнення
                System.out.println("Виберіть спосіб заповнення списку композицій: ");
                System.out.println("1. Заповнити вручну");
                System.out.println("2. Заповнити автоматично");
                int choice = in.nextInt();

                if(choice == 1) {
                    playlistOnDisk.createComposition();
                    break;
                } else if(choice == 2) {
                    playlistOnDisk.fillListOfComposition();
                    break;
                } else{
                    System.out.println("Ви ввели неправильне значення");
                }


            } while (true);
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
