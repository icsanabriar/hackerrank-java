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
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class QueenAttack {

    /**
     * Position in a chess board.
     */
    private static class Position {

        /**
         * Row number of the position.
         */
        private int row;

        /**
         * Column number of the position.
         */
        private int column;

        /**
         * Constructor of the position using the given row and column.
         *
         * @param row    Row number of the position.
         * @param column Column number of the position.
         */
        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
                return false;

            Position position = (Position) o;

            return row == position.row && column == position.column;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

    }

    /**
     * Define row positions to check obstacles around the queen position.
     */
    private static final int[] R_OFFSETS = {-1, 0, 1, 0, -1, -1, 1, 1};

    /**
     * Define column positions to check obstacles around the queen position.
     */
    private static final int[] C_OFFSETS = {0, 1, 0, -1, -1, 1, -1, 1};

    /**
     * Find number of attack by given parameters.
     *
     * @param n         Number of rows and columns in the board.
     * @param r_q       Row number of the queen position.
     * @param c_q       Column number of the queen's position.
     * @param obstacles Set of rows and columns of obstacles.
     * @return Number of queen attacks in the board.
     */
    private static int findAttack(final int n, int r_q, int c_q, int r_offset, int c_offset,
                                  final Set<Position> obstacles) {

        int attacks = 0;

        while (true) {

            r_q += r_offset;
            c_q += c_offset;

            if (!(r_q >= 1 && r_q <= n && c_q >= 1 && c_q <= n))
                break;
            else if (obstacles.contains(new Position(r_q, c_q)))
                break;

            attacks++;
        }

        return attacks;
    }

    /**
     * Calculates the number of attacks the queen could make under the given conditions of the board.
     *
     * @param n         Number of rows and columns in the board.
     * @param r_q       Row number of the queen position.
     * @param c_q       Column number of the queen's position.
     * @param positions Set of rows and columns of obstacles.
     * @return Number of queen attacks in the board.
     */
    private static int queensAttack(final int n, final int r_q, final int c_q, final List<List<Integer>> positions) {

        final Set<Position> obstacles = positions.stream()
                .map(c -> new Position(c.get(0), c.get(1)))
                .collect(toSet());

        return IntStream.range(0, R_OFFSETS.length)
                .map(index -> findAttack(n, r_q, c_q, R_OFFSETS[index], C_OFFSETS[index], obstacles))
                .sum();
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        final BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH")));

        final String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        final int n = Integer.parseInt(firstMultipleInput[0]);
        final int k = Integer.parseInt(firstMultipleInput[1]);

        final String[] secondMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        final int r_q = Integer.parseInt(secondMultipleInput[0]);
        final int c_q = Integer.parseInt(secondMultipleInput[1]);

        final List<List<Integer>> obstacles = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            final String[] obstaclesRowTempItems = bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" ");

            final List<Integer> obstaclesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {

                final int obstaclesItem = Integer.parseInt(obstaclesRowTempItems[j]);
                obstaclesRowItems.add(obstaclesItem);
            }

            obstacles.add(obstaclesRowItems);
        }

        final int result = queensAttack(n, r_q, c_q, obstacles);

        bufferedWriter.write(
                String.valueOf(result));

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
