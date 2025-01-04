import java.util.Scanner;

class NoGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chance = 7;
        int finals = 0;
        boolean playagain = true;
        System.out.println("Hello Player");
        System.out.println("You have " + chance + " chances to win");

        while (playagain) {
            int rand = getrandN(1, 100);
            boolean guess = false;
            for (int i = 0; i < chance; i++) {
                System.out.println("Chance " + (i + 1) + ": Enter your guess");

              
                int user = 0;
                boolean validInput = false;
                while (!validInput) {
                    if (sc.hasNextInt()) {
                        user = sc.nextInt();
                        validInput = true;
                    } else {
                        System.out.println("Invalid input! Please enter an integer.");
                        sc.next(); 
                    }
                }

                if (user == rand) {
                    guess = true;
                    finals += 1;
                    System.out.println("You won the game!");
                    break;
                } else if (user > rand) {
                    System.out.println("Too high");
                } else {
                    System.out.println("Too low");
                }
            }
            if (!guess) {
                System.out.println("You lost the game. The number was " + rand);
            }
            System.out.println("Do you want to play again (y/n)?");
            String pa = sc.next();
            playagain = pa.equalsIgnoreCase("y");
        }
        System.out.println("Here is your scorecard: " + finals);
    }

    public static int getrandN(int min, int max) 
    {
        return (int)(Math.random() * (max - min + 1) + min);
    }
}
