import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Main {

    static void display_text() {
        System.out.println("Choose: 1 for Addition | 2 for Subtraction | 3 for Multiplication");
    }

    // Method to return a string representation of the complex number

    static void addition(int i1, int i2) {
        int real = 2 + 4;
        int imaginary = 5*i1 + i2;
        System.out.println(real + " + " + imaginary + "*i");
    }

    static void subtraction(int i1, int i2) {
        int real = 2 - 4;
        int imaginary = 5*i1 - i2;
        System.out.println(real + " - " + Math.abs(imaginary) + "*i");
    }

    static void multiplication(int i1, int i2) {
        int real = 2 * 4 - 5 * i1 * i2;
        int imaginary = 5 * i1 + i2;
        System.out.println(real + " + " + imaginary + "*i");
    }

    static void complex_nr(int var, int i1, int i2) {
        switch (var) {
            case 1: {
                System.out.println("You chose: Addition");
                addition(i1, i2);
                break;
            }
            case 2: {
                System.out.println("You chose: Subtraction");
                subtraction(i1, i2);
                break;
            }
            case 3: {
                System.out.println("You chose: Multiplication");
                multiplication(i1, i2);
                break;
            }
            default:
                System.out.println("Invalid choice");
        }
    }

    static void display_matrix(int m[][], int n[][]) {
        System.out.println("Display first matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Display second matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void matrix_sum(int m[][], int n[][]) {
        System.out.println("Matrix Sum:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + n[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] matrix_prod(int[][] m1, int[][] m2) {
        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    static void random_ex (){
        int[] numbers = new int[10];

        // Generate and store 10 random numbers
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Generate random numbers between 0 and 99
        }

        // Sort the array
        Arrays.sort(numbers);

        // Display the sorted numbers
        System.out.println("Sorted numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }


    public static void main(String[] args) {

        System.out.println("Ex 1");

        Scanner scanner = new Scanner(System.in);

        // Read first number
        System.out.print("Enter the first number: ");
        int i1 = scanner.nextInt();

        // Read second number
        System.out.print("Enter the second number: ");
        int i2 = scanner.nextInt();

        // Read operation choice
        display_text();
        int var = 0;
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                var = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // consume the invalid input
            }
        }
        scanner.close();
        complex_nr(var, i1, i2);

        //EX2
        System.out.println("Ex 2");

        int[][] matrix1 = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        int[][] matrix2 = {{8, 5, 3}, {3, 9, 2}, {2, 7, 3}};

        display_matrix(matrix1, matrix2);

        System.out.println("Sum:");
        matrix_sum(matrix1, matrix2);
        System.out.println();

        System.out.println("Product:");
        int[][] productMatrix = matrix_prod(matrix1, matrix2);
        for (int i = 0; i < productMatrix.length; i++) {
            for (int j = 0; j < productMatrix[i].length; j++) {
                System.out.print(productMatrix[i][j] + " ");
            }
            System.out.println();
        }


        //Ex3:
        System.out.println("Ex 3");
        random_ex();
    }
}
