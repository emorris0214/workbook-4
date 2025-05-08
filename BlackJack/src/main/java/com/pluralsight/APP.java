package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;


public class APP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!");
        System.out.print("Enter the number of players (1–7): ");
        int numPlayers = 0;

        while (numPlayers < 1 || numPlayers > 7) {
            try {
                numPlayers = Integer.parseInt(scanner.nextLine());
                if (numPlayers < 1 || numPlayers > 7) {
                    System.out.print("Please enter a number between 1 and 7: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between 1 and 7: ");
            }
        }

        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Hand> hands = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine().trim();
            playerNames.add(name.isEmpty() ? "Player " + i : name);
            hands.add(new Hand());
        }

        Deck deck = new Deck();
        deck.shuffle();

        // Deal two cards to each player
        for (Hand hand : hands) {
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }

        // Player turns
        for (int i = 0; i < hands.size(); i++) {
            Hand hand = hands.get(i);
            String name = playerNames.get(i);

            System.out.println("\n" + name + "'s turn:");
            while (true) {
                hand.showHand();
                System.out.println("Total value: " + hand.getValue());

                if (hand.getValue() > 21) {
                    System.out.println(name + " busted!\n");
                    break;
                }

                System.out.print("Would you like to [Hit] or [Stay]? ");
                String choice = scanner.nextLine().trim().toLowerCase();

                if (choice.equals("hit")) {
                    hand.deal(deck.deal());
                } else if (choice.equals("stay")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please type Hit or Stay.");
                }
            }
        }

        printGameResults(hands, playerNames);
        scanner.close();
    }

    private static void printGameResults(ArrayList<Hand> hands, ArrayList<String> playerNames) {
        int maxScore = 0;
        ArrayList<Integer> winningPlayerPositions = new ArrayList<>();

        for (int i = 0; i < hands.size(); i++) {
            int score = hands.get(i).getValue();
            if (score <= 21) {
                if (score > maxScore) {
                    maxScore = score;
                    winningPlayerPositions.clear();
                    winningPlayerPositions.add(i);
                } else if (score == maxScore) {
                    winningPlayerPositions.add(i);
                }
            }
        }

        System.out.println("\n--- Game Over ---");
        for (int i = 0; i < hands.size(); i++) {
            System.out.println(playerNames.get(i) + "'s final hand (" + hands.get(i).getValue() + " points):");
            hands.get(i).showHand();
            System.out.println();
        }

        if (winningPlayerPositions.isEmpty()) {
            System.out.println("No winner. Everyone busted!");
        } else if (winningPlayerPositions.size() == 1) {
            int winner = winningPlayerPositions.get(0);
            System.out.println("🏆 Winner: " + playerNames.get(winner) +
                    " with " + hands.get(winner).getValue() + " points!");
        } else {
            System.out.println("🤝 It's a tie between:");
            for (int index : winningPlayerPositions) {
                System.out.println("- " + playerNames.get(index) +
                        " with " + hands.get(index).getValue() + " points");
            }
        }
    }
}
