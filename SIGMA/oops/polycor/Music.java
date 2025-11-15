package SIGMA.oops.polycor;

public class Music extends Media {
    String genre;

    public Music(String title, String creator, String genre) {
        super(title, creator);
        this.genre = genre;
    }

    @Override
    public void play() {
        System.out.println("Music playing " + title + " by" + creator + " and genre is: " + genre);
    }
}
