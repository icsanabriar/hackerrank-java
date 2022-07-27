/*
 * Copyright (C) 2020 Iván Camilo Sanabria.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hacker.rank.algorithms.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class Encryption {

    /**
     * Transform the given grid into a linear string.
     *
     * @param grid Grid built on previous step.
     * @param row  Number of rows of the grid.
     * @param col  Number of columns of the grid.
     * @return String build from the grid after mapping process.
     */
    private static String mapGrid(final char[][] grid, final int row, final int col) {

        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < col; i++) {

            for (int j = 0; j < row; j++) {
                if (grid[j][i] != 0)
                    builder.append(grid[j][i]);
            }

            builder.append(" ");
        }

        return builder.toString()
                .trim();
    }

    /**
     * Build the grid based on the given string and formula specify on the problem.
     *
     * @param s      Given string to encrypt.
     * @param length Length of the given string.
     * @param row    Number of rows to build the grid.
     * @param col    Number of columns to build the grid.
     * @return Grid build based on specify formula on the problem.
     */
    private static char[][] buildGrid(final String s, final int length, final int row, final int col) {

        final char[][] grid = new char[row][col];
        int r = 0;
        int c = 0;

        for (int i = 0; i < length; i++) {
            grid[r][c] = s.charAt(i);
            c++;

            if (c == col) {
                c = 0;
                r++;
            }
        }

        return grid;
    }

    /**
     * Encrypts the given string based on the specify function.
     *
     * @param s String to encrypt.
     * @return Encrypted result of the given string.
     */
    private static String encryption(final String s) {

        final int length = s.length();
        int row = (int) Math.round(Math.sqrt(length));

        if (row * row > length)
            row--;

        int col;

        if (row * row == length)
            col = row;
        else if (row * (row + 1) >= length)
            col = row + 1;
        else {
            row++;
            col = row;
        }

        final char[][] grid = buildGrid(s, length, row, col);

        return mapGrid(grid, row, col);
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final String s = bufferedReader.readLine();
            final String result = encryption(s);

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }
    }

}
