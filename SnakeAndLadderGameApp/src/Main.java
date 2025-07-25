import java.util.*;

public class Main {

    // Snake and ladder positions
    static final Map<Integer, Integer> snakes = Map.of(
            99, 54,
            70, 55,
            52, 42,
            25, 2,
            95, 72
    );

    static final Map<Integer, Integer> ladders = Map.of(
            6, 25,
            11, 40,
            60, 85,
            46, 90,
            17, 69
    );

    static int playerPosition = 1;
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🎲 Welcome to Snake and Ladder Game!");
        System.out.println("You start at position 1. Reach 100 to win!");
        System.out.println("Press Enter to roll the dice...");

        while (playerPosition < 100) {
            scanner.nextLine(); // wait for Enter
            int dice = rollDice();
            System.out.println("🎯 You rolled a " + dice);

            movePlayer(dice);

            System.out.println("📍 Current Position: " + playerPosition);

            if (playerPosition == 100) {
                System.out.println("🏆 Congratulations! You reached 100 and won the game!");
                break;
            }
        }
    }

    static int rollDice() {
        return rand.nextInt(6) + 1; // 1 to 6
    }

    static void movePlayer(int dice) {
        int nextPosition = playerPosition + dice;

        if (nextPosition > 100) {
            System.out.println("❌ You need exact number to reach 100. Stay at " + playerPosition);
            return;
        }

        playerPosition = nextPosition;

        if (snakes.containsKey(playerPosition)) {
            System.out.println("🐍 Oh no! You landed on a snake! Down to " + snakes.get(playerPosition));
            playerPosition = snakes.get(playerPosition);
        } else if (ladders.containsKey(playerPosition)) {
            System.out.println("🪜 Yay! You climbed a ladder! Up to " + ladders.get(playerPosition));
            playerPosition = ladders.get(playerPosition);
        }
    }
}
