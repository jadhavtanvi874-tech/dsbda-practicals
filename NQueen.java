import java.util.Scanner;

public class NQueen {

    static int N;
    static int board[][];

    // Function to print board
    static void printBoard() {

        System.out.println("\nSolution:\n");

        for(int i = 0; i < N; i++) {

            for(int j = 0; j < N; j++) {

                if(board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print("_ ");
            }

            System.out.println();
        }
    }

    // Function to check safe position
    static boolean isSafe(int row, int col) {

        // Check left side row
        for(int i = 0; i < col; i++) {
            if(board[row][i] == 1)
                return false;
        }

        // Check upper diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1)
                return false;
        }

        // Check lower diagonal
        for(int i = row, j = col; i < N && j >= 0; i++, j--) {
            if(board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Backtracking function
    static boolean solve(int col) {

        // All queens placed
        if(col >= N)
            return true;

        // Try every row
        for(int i = 0; i < N; i++) {

            if(isSafe(i, col)) {

                board[i][col] = 1;

                // Recursive call
                if(solve(col + 1))
                    return true;

                // Backtracking
                board[i][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter number of Queens: ");
        N = sc.nextInt();

        board = new int[N][N];

        // Solve N-Queen Problem
        if(solve(0))
            printBoard();
        else
            System.out.println("No Solution Exists");

        sc.close();
    }
}