package menu;
import commands.playlistOnDiskCommand.*;
import model.PlaylistOnDisk;
import model.User;

import java.util.Scanner;

public class MenuUtils {

    public static final Scanner in = new Scanner(System.in);

    public static final PlaylistOnDisk playlistOnDisk = new PlaylistOnDisk();

    public static final String[] nameOfCommandsArray = { "створити нову композицію", "видалити композицію", "переглянути весь список композицій", "порахувати загальну тривалість плейлесту в секундах", "знайти композицію по тривалості", "знайти композицію по назві",
            "знайти композицію по автору", "знайти композиції з заданого діапазону тривалості ", "відсортувати по жанру"};

    public static final Command[] commandArray = {new CreateCompositionCommand(playlistOnDisk), new DeleteCompositionCommand(playlistOnDisk),
            new ShowAllPlaylistCommand(playlistOnDisk), new CountDurationOfPlaylistCommand(playlistOnDisk), new FindCompositionByDurationCommand(playlistOnDisk),
            new FindCompositionByTitleCommand(playlistOnDisk), new FindCompositionsByAuthorCommand(playlistOnDisk),
            new FindCompositionsByDurationRangeCommand(playlistOnDisk), new SortPlaylistByGenreCommand(playlistOnDisk)};


    public static void printMenu(Command[] commandArray, String[] nameOfCommandsArray){
        System.out.println("\n");
        for (int i = 0; i < commandArray.length; i++)
            System.out.println((i + 1) + ") - " + nameOfCommandsArray[i]);
        System.out.println("0) - Вийти");
    }


    public static void menuLoop(){
        boolean flag = true;
        int choice = 0;

        User user = new User(new CreateCompositionCommand(playlistOnDisk), new DeleteCompositionCommand(playlistOnDisk),
                new ShowAllPlaylistCommand(playlistOnDisk), new CountDurationOfPlaylistCommand(playlistOnDisk), new FindCompositionByDurationCommand(playlistOnDisk),
                new FindCompositionByTitleCommand(playlistOnDisk), new FindCompositionsByAuthorCommand(playlistOnDisk),
                new FindCompositionsByDurationRangeCommand(playlistOnDisk), new SortPlaylistByGenreCommand(playlistOnDisk));

        while (flag) {
            printMenu(commandArray, nameOfCommandsArray);

            try {
                System.out.print("Вибиріть дію:  ");
                choice = in.nextInt();
            } catch (Exception e) {
                in.nextLine();
            }


            switch (choice){
                case 0:
                    flag = false;
                    break;

                case 1:
                    user.createComposition();
                    break;
                case 2:
                    user.deleteComposition();
                    break;
                case 3:
                    user.showAllPlaylist();
                    break;
                case 4:
                    user.countDurationOfPlaylist();
                    break;
                case 5:
                    user.findCompositionByDuration();
                    break;
                case 6:
                    user.findCompositionByTitle();
                    break;
                case 7:
                    user.findCompositionsByAuthor();
                    break;
                case 8:
                    user.findCompositionsByDurationRange();
                    break;
                case 9:
                    user.sortPlaylistByGenre();
                    break;
            }
        }
    }
}
