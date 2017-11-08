/**
 * Created by tinevra17 on 6/21/17.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Scanner;

public class TinevraMatrixCal {
    /**
     * "readFromFile" the following method reads trough a text file with numbers.
     * As it runs trough out the file it generates a 2d array of integers.
     * this method has exception to handle empty files and files not found.
     * @return a 2d array of integers
     * */
    public static int[][] readFromFile() {

        BufferedReader reader;
        BufferedReader reader2;
        int row =0;
        int column;
        String line;
        int[][] matrix= new int[0][0];
        int[]A = new int[0];
        Boolean successful = false;

        while (!successful) {
            try {
                //name of file
                Scanner scnr = new Scanner(System.in);
                String fileName = scnr.next();

                //rows lines
                reader = new BufferedReader(new FileReader(fileName));
                while (reader.readLine() != null) row++;

                //columns size
                reader2 = new BufferedReader(new FileReader(fileName));
                String[] intString = reader2.readLine().split(" ");
                column = intString.length;

                //populating
                matrix =new int[row][column];
                BufferedReader reader3 = new BufferedReader(new FileReader(fileName));

                for (int i=0; i<row; i++) {
                    line = reader3.readLine();
                    String[] numbers = line.split(" ");
                    for (int j = 0; j < column; j++) {
                        matrix[i][j] = Integer.parseInt(numbers[j]);
                    }
                }
                System.out.println(Arrays.deepToString(matrix));

                successful = true;
            } catch (FileNotFoundException e) {
                System.out.println("file not found");

            } catch (NullPointerException e3){
                System.out.println("file empty");

            } catch (IOException e1) {
                System.out.println("something went wrong");
            }
        }
        return matrix;
    }
    /**
     * "sum" the following method calculates the sum of two matrices.
     * if the 2 arrays do not qualify for addition due to size
     * of the arrays an exception will be throw and catch.
     * @param matrix1 is the first 2D array.
     * @param matrix2 is a second 2D array.
     * @return a new matrix with the sum of matrix1 and matrix2.
     */
    public static int[][]sum(int[][]matrix1,int[][]matrix2){
        int[][] sum= new int[matrix1.length][matrix1[0].length];
        try {
            if(matrix1.length!=matrix2.length) throw new IOException();
            else if (matrix1[0].length!=matrix2[0].length) throw new IOException();
            //add an exception depending on the TA
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    sum[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

        }catch (NullPointerException | ArrayIndexOutOfBoundsException | IOException e2) {
            return  null;
        }
        System.out.println(Arrays.deepToString(sum));
        return sum;
    }

    /**
     * "difference"(subtraction) the following method calculates the subtraction of two matrices.
     * If the matrices do not qualify for subtraction due to size
     * of the arrays an exception will be throw and catch.
     * @param matrix1 is the first 2D array.
     * @param matrix2 is the second 2D array.
     * @return a new 2d array(matrix) with the subtraction of the matrix1 and matrix2.
     */
    public static int[][]difference(int[][]matrix1,int[][]matrix2){
        System.out.println("File path 1 for subtraction: ");
        System.out.println("File path 2: ");
        int[][] dif= new int[matrix1.length][matrix1[0].length];
        try {
            if (matrix1.length != matrix2.length) throw new IOException();
            else if (matrix1[0].length != matrix2[0].length) throw new IOException();

            //add an exception
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    dif[i][j] = matrix1[i][j] - matrix2[i][j];

                }

            }

        }
        catch (NullPointerException | ArrayIndexOutOfBoundsException | IOException e2) {
            return  null;
        }
        System.out.println(Arrays.deepToString(dif));
        return dif;
    }

    /**
     * "multiplication" the following method calculates the product of two matrices.
     * if the matrices do not qualify for multiplication due to size
     * of the arrays an exception will be throw and catch.
     * Also, AB is defined only if the number of columns in A is equal to the number of rows in B.
     * if not an exception will be throw and catch.
     * @param matrix1 is the first 2D array.
     * @param matrix2 is the second 2D array.
     * @return a new 2d array(matrix) with the multiplication of matrix1 and matrix2.
     */
    public static int[][] matrixProduct(int[][]matrix1,int[][]matrix2){
        System.out.println("File path 1 for multiplication: ");
        System.out.println("File path 2: ");
        int row = matrix1.length;
        int column = matrix2[0].length;
        int[][] multiA= new int[row][column];
        try{
            if(row!=column) throw new IOException();
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < column; j++) {
                    for(int k = 0; k < matrix1[0].length; k++) {
                        multiA[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

        }catch (NullPointerException | ArrayIndexOutOfBoundsException | IOException e2) {
            System.out.println("Error");
            return null;
        }
        System.out.println(Arrays.deepToString(multiA));
        return multiA;
    }

    /**
     * "pow" the following method calculates calculates the power of a given 2d array(matrix).
     * @param matrix1 is a 2d array (matrix) for which the method will calculate its product by itself(the power).
     * @param pow is the power for which matrix1 will be computed.
     * @return a new 2d array(matrix)the result of matrix1^pow.
     */
    public static int[][] pow(int[][]matrix1,int pow){
        System.out.println("File path for power: ");
        int[][] product=new int[matrix1.length][matrix1[0].length];
        int row = matrix1.length;
        int column = matrix1[0].length;
        try{
            if (pow < 0) throw new IOException();
            if(pow==0) {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        product[i][j] = 0;
                    }
                }
                System.out.println(Arrays.deepToString(product));
                return product;
            }
            for (int b = 0; b <pow ; b++) {
                for(int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        for (int k = 0; k < row; k++) {
                            product[i][j] += matrix1[i][k] * matrix1[k][j];
                        }
                    }
                }

            }


        }catch (NullPointerException | ArrayIndexOutOfBoundsException | IOException  | InputMismatchException e2) {
            return  null;
        }

        System.out.println(Arrays.deepToString(product));
        return product;
    }

    /**
     * "intMultiplication" the following method computes the product of a number with all the values of a matrix.
     * @param matrix1 is the 2D array(matrix).
     * @param num is an integer provided by the user which will be multiply with all the values of matrix1.
     * @return a new 2D array(matrix) with the product of the multiplication of each int in matrix1 by num.
     */
    public static int[][]intMultiplication(int[][]matrix1,int num) {
        try {
            //exception in order to not get negative values
            if (num < 0) throw new IOException();
        }catch (NullPointerException | IOException | InputMismatchException e2) {
            return null;
        }

        int[][] mult = new int[matrix1.length][matrix1[0].length];


        //add an exception
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                mult[i][j] = matrix1[i][j] * num;
            }
        }
        System.out.println(Arrays.deepToString(mult));
        return mult;
    }

    /**
     * "transpose" the following method computes the transpose of a matrix.
     * The transpose of a matrix is a new matrix whose rows are the columns of the original.
     * @param matrix1 is the 2d array(matrix).
     * @return a new 2D array(matrix) with the transpose of matrix1.
     */
    public static int[][] transpose(int[][]matrix1){
        System.out.println("File path for transpose: ");
        int[][]transposeA = new int[matrix1[0].length][matrix1.length];
        int column = matrix1.length;
        int row = matrix1[0].length;
        try{
            for (int i = 0; i <row ; i++) {
                for (int j = 0; j <column ; j++) {
                    transposeA[i][j]=matrix1[j][i];
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException e2) {
            return  null;
        }
        System.out.println(Arrays.deepToString(transposeA));
        return transposeA;
    }

    /**
     * "matrix1metric" the following method checks if a matrix is symmetric.
     * @param matrix1 is the 2d array(matrix).
     * @return a boolean depending if the matrix1 is symmetric.
     */
    public static Boolean matrix1metric(int[][]matrix1){
        System.out.println("File path for symmetric check: ");
        int [][] check = new int[matrix1[0].length][matrix1.length];
        int column = matrix1.length;
        int row = matrix1[0].length;

        try{
            for (int i = 0; i <row ; i++) {
                for (int j = 0; j <column ; j++) {
                    check[i][j]=matrix1[j][i];

                }
            }
            // System.out.println(Arrays.deepToString(check));

            if(check.length!=matrix1.length) return false;
            if(check[0].length!=matrix1[0].length)return false;

            for (int i = 0; i <check.length ; i++) {
                for (int j = 0; j < check[0].length; j++) {
                    if(matrix1[i][j]!=check[i][j])return false;

                }

            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e4){
            return null;

        }
        return true;
    }
    public static int[][] jagged(int n){
        int [][] a = new int[n][];
        if(n>0){
            int k = 0;
            for (int i = 1; i <=n ; i++) {
                a[i-1]=new int[i];
                for (int j = 0; j < i; j++) {
                    a[i-1][j]=k;
                    k++;
                }
            }
        }
        System.out.println(Arrays.deepToString(a));
        return a;
    }

    public static void main(String[] args) {
        System.out.println("pushing");
    }
}