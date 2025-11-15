package SIGMA.oops.polycor;

public class Movie  extends Media{
    int durationInTime;
    public Movie(String title , String creator , int durationInTime){
        super(title , creator);
        this.durationInTime = durationInTime;
    }

    @Override
    public void play() {
        System.out.println("Movie playing" + title + " directed by " + creator + "Duration: " +durationInTime +"minutes");
    }
}
