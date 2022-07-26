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
import java.util.ArrayList;
import java.util.List;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class CellGrid {

    /**
     * Regex used to process input of the program.
     */
    private static final String REGEX = "\\s+$";

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = " ";

    /**
     * Replacement of value inline.
     */
    private static final String REPLACEMENT = "";

    /**
     * Define row values to look around of a cell.
     */
    private static final int[] R_OFFSETS = {-1, -1, 0, 1, 1, 1, 0, -1};

    /**
     * Define column values to look around of a cell.
     */
    private static final int[] C_OFFSETS = {0, 1, 1, 1, 0, -1, -1, -1};

    /**
     * Find a region of cells using the given matrix, row and column number.
     *
     * @param matrix Matrix to look cell's region.
     * @param row    Number of row to find region.
     * @param column Number of column to find region.
     * @return Number of connected cells found in one region.
     */
    private static int findRegion(final List<List<Integer>> matrix, final int row, final int column) {

        final int rows = matrix.size();

        final int columns = matrix.get(0)
                .size();

        if (!(row >= 0 && row < rows && column >= 0 && column < columns))
            return 0;

        else {

            final int value = matrix.get(row)
                    .get(column);

            if (value != 1)
                return 0;
        }

        matrix.get(row)
                .set(column, -1);

        int region = 1;

        for (int i = 0; i < R_OFFSETS.length; i++) {
            region += findRegion(matrix, row + R_OFFSETS[i], column + C_OFFSETS[i]);
        }

        return region;
    }

    /**
     * Find the maximum connection between cells on the given matrix.
     *
     * @param matrix Matrix to look the maximum connection between cells.
     * @return Maximum number of connected cells.
     */
    private static int connectedCell(final List<List<Integer>> matrix) {

        int maxRegion = 0;

        for (int row = 0; row < matrix.size(); row++) {

            final List<Integer> columns = matrix.get(row);

            for (int column = 0; column < columns.size(); column++) {

                final int value = matrix.get(row)
                        .get(column);

                if (value == 1)
                    maxRegion = Math.max(maxRegion, findRegion(matrix, row, column));
            }
        }

        return maxRegion;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings({"Duplicates", "unused"})
    public static void main(String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        final BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH")));

        final int n = Integer.parseInt(
                bufferedReader.readLine()
                        .trim());

        final int m = Integer.parseInt(
                bufferedReader.readLine()
                        .trim());

        final List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            final String[] matrixRowTempItems = bufferedReader.readLine()
                    .replaceAll(REGEX, REPLACEMENT)
                    .split(SEPARATOR);

            final List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {

                final int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        final int result = connectedCell(matrix);

        bufferedWriter.write(
                String.valueOf(result));

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
