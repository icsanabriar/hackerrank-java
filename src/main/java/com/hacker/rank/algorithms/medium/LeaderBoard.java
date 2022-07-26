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
public class LeaderBoard {

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
     * Retrieves the position of the given player based on the given score and ranked players.
     *
     * @param ranked List of ranked scores in the machine.
     * @param ranks  Positions of the given ranked scores.
     * @param score  Score of the player to rank.
     * @return Rank of the given player score.
     */
    private static Integer position(final List<Integer> ranked, final List<Integer> ranks, final Integer score) {

        int lower = 0;
        int higher = ranked.size() - 1;
        int currentRank = 1;

        while (lower <= higher) {

            int index = (lower + higher) / 2;
            int currentScore = ranked.get(index);

            if (score == currentScore)
                return ranks.get(index);
            else if (score > currentScore)
                higher = index - 1;
            else {
                currentRank = ranks.get(index) + 1;
                lower = index + 1;
            }
        }

        return currentRank;
    }

    /**
     * Return the results of the player based on the given ranks.
     *
     * @param ranked Ranks players given on the case.
     * @param scores Player scores to get rank.
     * @return Rank of the given player based on the ranks.
     */
    private static List<Integer> climbingLeaderBoard(final List<Integer> ranked, final List<Integer> scores) {

        final List<Integer> positions = new ArrayList<>();
        int position = 1;

        // Build the positions for the ranked player scores.
        for (int i = 0; i < ranked.size(); i++) {

            if (i > 0 && !ranked.get(i).equals(ranked.get(i - 1))) {
                position++;
            }

            positions.add(position);
        }

        // Build the rank for the given player scores.
        final List<Integer> results = new ArrayList<>();

        for (Integer score : scores) {
            Integer result = position(ranked, positions, score);
            results.add(result);
        }

        return results;
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

        final int rankedCount = Integer.parseInt(
                bufferedReader.readLine()
                        .trim());

        final String[] rankedTemp = bufferedReader.readLine()
                .replaceAll(REGEX, REPLACEMENT)
                .split(SEPARATOR);

        final List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            final int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        final int playerCount = Integer.parseInt(
                bufferedReader.readLine()
                        .trim());

        final String[] playerTemp = bufferedReader.readLine()
                .replaceAll(REGEX, REPLACEMENT)
                .split(SEPARATOR);

        final List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            final int playerItem = Integer.parseInt(playerTemp[i]);
            scores.add(playerItem);
        }

        final List<Integer> result = climbingLeaderBoard(ranked, scores);

        for (int i = 0; i < result.size(); i++) {

            bufferedWriter.write(
                    String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}