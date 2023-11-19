package org.example;

public class Main {
    public static void main(String[] args) {
        // declare a max so 1 .. 100
        int max = 10000000;

        problem(max);
    }

    public static void problem(int limit) {
        int switchWon = 0;
        int stayWon = 0;

        for (int i = 0; i < limit; i++) {
            // Initialize doors with goats
            boolean[] doors = new boolean[3];

            // Randomly place the car behind one of the doors
            int carIndex = random(0, 2);
            doors[carIndex] = true;

            // Contestant makes an initial choice
            int Choice = random(0, 2);

            // Host reveals a door with a goat
            int revealedDoor;
            do {
                revealedDoor = random(0, 2);
            } while (revealedDoor == Choice || doors[revealedDoor]);

            // If switching, choose the other unopened door
            int finalChoice;
            do {
                finalChoice = random(0, 2);
            } while (finalChoice == Choice || finalChoice == revealedDoor);

            // Check if contestant wins based on staying or switching
            if (doors[Choice]) {
                stayWon++;
            }
            if (doors[finalChoice]) {
                switchWon++;
            }
        }

        System.out.println("stay won this many times = " + stayWon);
        System.out.println("switch won this many times = " + switchWon);

    }

    public static int random(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }
}
