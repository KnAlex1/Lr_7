package model;


import java.util.*;
import java.util.stream.Collectors;


public class PlaylistOnDisk {


    public List<Composition> compositions;


    public PlaylistOnDisk() {
        compositions = new ArrayList<>();
    }

    private void compositionsToLowerCase(){
        for (Composition composition: compositions) {
            composition.setAuthor(composition.getAuthor().toLowerCase(Locale.ROOT));
            composition.setGenre(composition.getGenre().toLowerCase(Locale.ROOT));
            composition.setTitle(composition.getTitle().toLowerCase(Locale.ROOT));
        }
    }



    public void fillListOfComposition(){
        compositions = new ArrayList<>();
        compositions.add(new Composition("Thunder", "Pop Rock", "imagine dragons", 177 ));
        compositions.add(new Composition("In the end", "Alternative Rock", "Linkin Park", 217 ));
        compositions.add(new Composition("Numb", "Alternative Rock", "Linkin Park", 187 ));
        compositions.add(new Composition("Demons", "Pop Rock", "imagine dragons", 250 ));
        compositions.add(new Composition("Demons", "Pop Rock", "imagine dragons", 121 ));
        compositionsToLowerCase();
    }

    public int countDurationOfPlaylist(){
        int result = 0;
        for(Composition composition: compositions) {
            result+= composition.getSongDurationInSecond();
        }
        System.out.println("загальна тривалість плейлесту в секундах = " + result);
        return result;
    }


    public Composition findCompositionByDuration(){

        Scanner in = new Scanner(System.in);
        System.out.println("Введіть тривалість композиції в секундах: ");
        int duration = in.nextInt();

        for(Composition composition: compositions) {
            if(composition.getSongDurationInSecond() == duration){
                System.out.println("Знайдена композиція по заданій тривалості = " + composition.toString());
                return composition;
            }
        }
        System.out.println("Такої композиції не знайдено");
        return null;

    }


    public Composition findCompositionByTitle(){

        Scanner in = new Scanner(System.in);

        in.nextLine();
        System.out.println("Введіть назву композиції: ");

        String title = in.nextLine().toLowerCase(Locale.ROOT);

        for(Composition composition: compositions) {
            if(composition.getTitle().equals(title)){
                System.out.println("Знайдена композиція по заданій назві = " + composition.toString());
                return composition;
            }
        }
        System.out.println("Такої композиції не знайдено");
        return null;
    }


    public List<Composition> findCompositionsByAuthor(){

        Scanner in = new Scanner(System.in);
        System.out.println("Введіть назву автору: ");
        in.nextLine();
        String author = in.nextLine().toLowerCase(Locale.ROOT);

        List<Composition> result = new ArrayList<>();

        for(Composition composition: compositions) {
            if(composition.getAuthor().equals(author)){
                result.add(composition);
            }
        }
        if(result.isEmpty()){
            System.out.println("Таких композицій не знайдено");
            return null;
        }
        System.out.println("Результатуючий набір композицій по вашому запиту: ");

        for (Composition composition: result) {
            System.out.println(composition);
        }
        return result;
    }


    public List<Composition> findCompositionsByDurationRange(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть мінімальну тривалість композиції в секундах: ");

        int minDuration = in.nextInt();

        System.out.println("Введіть максимальну тривалість композиції в секундах: ");
        int maxDuration = in.nextInt();
        System.out.println("min = " + minDuration + "  max = " + maxDuration );

        List<Composition> result = new ArrayList<>();

        for(Composition composition: compositions) {
            if(composition.getSongDurationInSecond() >= minDuration && composition.getSongDurationInSecond() <= maxDuration){
                result.add(composition);
            }
        }

        if(result.isEmpty()){
            System.out.println("Таких композицій не знайдено");
            return null;
        }
        System.out.println("Результатуючий набір композицій по вашому запиту: " );
        for (Composition composition: result) {
            System.out.println(composition);
        }
        return result;
    }


    public void sortPlaylistByGenre(){
        Scanner in = new Scanner(System.in);
        Map<String, List<Composition>> map =  compositions.stream().collect(Collectors.groupingBy(el -> el.getAuthor()));
        System.out.println("Відсортований плейлист по жанру: ");
        for(Map.Entry<String, List<Composition>> entry: map.entrySet()){
            System.out.println(entry.getKey() + ": ");
            for (Composition composition :entry.getValue()) {
                System.out.println(composition);
            }
        }
    }

    public void deleteComposition(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть назву композиції, яку хочете видалити: ");
        in.nextLine();
        String title = in.nextLine().toLowerCase(Locale.ROOT);

        for (Composition composition : compositions) {
            if(composition.getTitle().equals(title)){
                compositions.remove(composition);
                System.out.println("Композиція " + composition + " видалена");
                return;
            }

        }
        System.out.println("Такої композиції не має");


    }

    public void showAllPlaylist(){
        System.out.println("Результатуючий набір композицій по вашому запиту: ");
        for (Composition composition: compositions) {
            System.out.println(composition);
        }

    }

    public void createComposition(){
        Scanner in = new Scanner(System.in);
        in.nextLine();
        System.out.println("Введіть назву композиції: ");
        String title = in.nextLine();
        System.out.println("Введіть жанр композиції: ");
        String genre = in.nextLine();
        System.out.println("Введіть автора композиції: ");
        String author = in.nextLine();
        System.out.println("Введіть тривалість композиції: ");
        int songDurationInSecond = in.nextInt();
        Composition composition = new Composition(title, genre, author, songDurationInSecond);
        compositions.add(composition);
        System.out.println("композиція " + compositions + " додана");
        compositionsToLowerCase();
    }



}
