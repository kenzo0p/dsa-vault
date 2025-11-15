package SIGMA.oops.polycor;

public class Main {

    /*
     * Question
     * 
     * You want to implement a new feature in the MediaLibrary class that allows you
     * to add multiple media items at once and automatically play them in sequence.
     * 
     * Which of the following approaches best utilizes polymorphism to achieve this
     * functionality?
     * 
     * 
     * Add a separate playAll method to each subclass (Book, Movie, Music) that
     * handles playing multiple items of that type.
     * 
     * 
     * Manually check the type of each media item before calling the appropriate
     * play method for that type.
     * 
     * 
     * Create specific methods in the MediaLibrary class for each media type, such
     * as playBooks, playMovies, and playMusic, and call these methods as needed.
     * 
     * 
     * -> Create a method in the MediaLibrary class that takes an array of Media
     * objects and uses a loop to call the play method on each item in the array.
     * 
     * Correct
     * That’s correct. This is the best approach as it leverages polymorphism. The
     * loop will call the play method on each media item, and Java will
     * automatically select the appropriate play method based on the object’s actual
     * class.
     * 
     * 
     */
    public static void main(String[] args) {
        Book greatgatsyBook = new Book("gatsy", "om  bhor", 100);
        Movie ironMan = new Movie("iron man", "rahul bhoi", 30);
        Music shivaMeraSala = new Music("Shiva mera sala", "shubham dange", "Horro");

        MediaLibrary library = new MediaLibrary();

        Media addEBook = library.addMedia(greatgatsyBook);
        Media addmovie = library.addMedia(ironMan);
        Media addMusic = library.addMedia(shivaMeraSala);
        library.playMedia(addEBook);
        library.playMedia(addMusic);
        library.playMedia(addmovie);
    }
}
