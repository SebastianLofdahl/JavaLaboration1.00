package Se.iths.sebastian.laborationEtt.laborationDice.model;

public class Player {
    //Min player klass

    private String firstName;
    private String lastName;
    private int score;

    public Player(String firstName, String lastName) {
        //En enkel konstruktor för klassen att använda
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = 0;
    }

    public int getScore() { //Hämtar score
        return score;
    }

    public void addToScore(int score) {
        //get metod för att addera på scoren för varje kast
        this.score += score;
    }

    public String getFullName() {
        //Return för att få ett fullt namn för spelare
        return firstName + " " + lastName;
    }
}