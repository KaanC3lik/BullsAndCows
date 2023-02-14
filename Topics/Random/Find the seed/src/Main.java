import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int lowerSeed = scanner.nextInt();
        int upperSeed = scanner.nextInt();
        int numberOfRandomNumbers = scanner.nextInt();
        int biggestRandomNumber = scanner.nextInt();
        int seedsBiggestNumber[] = new int[upperSeed - lowerSeed + 1];

        for (int i = lowerSeed; i <= upperSeed; i++) {
            Random random = new Random(i);
            int biggestNumber = 0;
            for (int j = 0; j < numberOfRandomNumbers; j++) {
                int number = random.nextInt(biggestRandomNumber);

                if (biggestNumber < number) {
                    biggestNumber = number;
                }
            }
            seedsBiggestNumber[i - lowerSeed] = biggestNumber;
        }
        int minBiggestNumber = seedsBiggestNumber[0];
        for (int i = 0; i <= upperSeed - lowerSeed; i++) {
                if (seedsBiggestNumber[i] < minBiggestNumber) {
                    minBiggestNumber = seedsBiggestNumber[i];
                }
        }
        for (int i = 0; i <= upperSeed - lowerSeed; i++) {
                if (minBiggestNumber == seedsBiggestNumber[i]) {
                    System.out.println(i + lowerSeed);
                    break;
                }
        }
        System.out.println(minBiggestNumber);
    }
}