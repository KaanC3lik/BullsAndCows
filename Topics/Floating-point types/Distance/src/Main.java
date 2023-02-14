import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double length = scanner.nextDouble();
        double time = scanner.nextDouble();
        double average = length/time;
        System.out.println(average);
    }
}