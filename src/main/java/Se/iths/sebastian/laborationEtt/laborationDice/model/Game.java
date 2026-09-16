package Se.iths.sebastian.laborationEtt.laborationDice.model;

public class Game {

    public void play() {
        //Min public metod för att kunna kalla på showMenu och dens följande funktioner till Main
        showMenu();
    }

    private void showMenu() {
        /*Skapade en startmeny med en vanlig switch, tog lite googlande för att komma ihåg exakt hur de funka
        vet att de kanske inte behövs, men tycker de ser bättre ut :)
         */

        boolean inMenu = true;

        while (inMenu) {
            IO.println("-- 1. Spela spelet --");
            IO.println("-- 2. Visa regler --");
            IO.println("-- 3. Avsluta --");
            String choice = IO.readln("Ditt val (1-3): ");

            switch (choice) {
                case "1" -> {
                    Player playerOne = createPlayer(1);
                    Player playerTwo = createPlayer(2);
                    playRound(playerOne);
                    playRound(playerTwo);
                    printResult(playerOne, playerTwo);
                }
                case "2" ->
                        IO.println("Varje spelare slår tärningen två gånger på rad, sedan räknas summorna ihop och högsta resultat vinner.");
                case "3" -> IO.println(inMenu = false);
                default -> IO.println("Error: Ogiltigt val! Måste göra ett val mellan 1-3.");
            }
        }
        IO.println("Hoppas ni gillade spelet!");
    }

    private Player createPlayer(int playerNumber) {//Själva player creating metoden

        IO.println("--Player " + playerNumber + "--");
        String firstName = readInput("Ditt förnamn?: ");
        String lastName = readInput("Ditt efternamn?: ");
        return new Player(firstName, lastName);
    }

    private String readInput(String prompt) {
        //Min try/catch för att säkerställa att jag får korrekt input av spelarna

        while (true) {
            String input = IO.readln(prompt);

            try {
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input kan ej vara tomt.");
                }
                return input;
            } catch (IllegalArgumentException e) {
                IO.println("Vänligen försök igen. " + e.getMessage());
            }
        }
    }

    private void playRound(Player player) {
        //for loop för att slå slagen, med logiken från "Dice" klassen

        IO.println(player.getFullName() + " slår just nu.");

        for (int i = 1; i <= 2; i++) {
            int roll = Dice.roll();
            IO.println("Slag " + i + ": " + roll);
            player.addToScore(roll);
        }
    }

    private void printResult(Player player1, Player player2) {
        //Kallar på Player klassen här och dens get metoder för score och namn

        IO.println(player1.getFullName() + " Score: " + player1.getScore());
        IO.println(player2.getFullName() + " Score: " + player2.getScore());

        if (player1.getScore() > player2.getScore()) {
            IO.println("Vinnaren är: " + player1.getFullName());
        } else if (player2.getScore() > player1.getScore()) {
            IO.println("Vinnaren är: " + player2.getFullName());
        } else {
            IO.println("Det blev oavgjort/lika.");
        }

    }

    private boolean wantToPlayMore() {
        //Metoden för att få input från användare om de vill spela igen, med en safe i form av .trim().toLowerCase();

        String answer = IO.readln("Vill du spela igen? Ja/Nej: ").trim().toLowerCase();
        return answer.equals("ja");
    }

}
