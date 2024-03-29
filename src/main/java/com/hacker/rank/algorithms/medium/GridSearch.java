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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class GridSearch {

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
     * Collect the positions where the first pattern line is found in the given grid line.
     *
     * @param indexes     Map containing the indexes where the first pattern line was found in the grid.
     * @param patternLine First pattern line to find in the given grid line.
     * @param gridLine    Current grid line to find the first pattern line.
     * @param lineNumber  Current line number of the grid to use as key on indexes map.
     */
    private static void collectPositions(final Map<Integer, List<Integer[]>> indexes, final String patternLine,
                                         final String gridLine, final int lineNumber) {

        int adjustment = 0;
        String updateLine = gridLine;

        while (updateLine.contains(patternLine)) {

            final int start = updateLine.indexOf(patternLine) + adjustment;
            final int end = start + patternLine.length();

            if (indexes.containsKey(lineNumber))
                indexes.get(lineNumber)
                        .add(new Integer[]{start, end});
            else
                indexes.put(lineNumber,
                        new ArrayList<>(Collections.singletonList(new Integer[]{start, end})));

            adjustment = start + 1;

            if (adjustment + patternLine.length() <= gridLine.length())
                updateLine = gridLine.substring(adjustment);
            else
                break;
        }
    }


    /**
     * Match the given pattern to the grid using the indexes map.
     *
     * @param lineNumber Line number of the grid to start matching the pattern.
     * @param grid       Grid given as input of the program.
     * @param pattern    Pattern given as input of the program.
     * @param positions  Current index positions that first line of pattern match with the given line number of the grid.
     * @return A boolean representing if the pattern was found on the grid or not.
     */
    private static boolean matchPattern(final Integer lineNumber, final List<String> grid, final List<String> pattern,
                                        final List<Integer[]> positions) {

        for (Integer[] position : positions) {

            int matches = 0;
            String line = grid.get(lineNumber + matches);
            String extract = line.substring(position[0], position[1]);
            String patternLine = pattern.get(matches);

            while (extract.equals(patternLine)) {
                matches++;
                if (matches < pattern.size()) {
                    line = grid.get(lineNumber + matches);
                    extract = line.substring(position[0], position[1]);
                    patternLine = pattern.get(matches);
                } else {
                    break;
                }
            }

            if (matches == pattern.size())
                return true;
        }

        return false;
    }

    /**
     * Search the given pattern P on the grid G.
     *
     * @param grid    Grid to search the pattern.
     * @param pattern Pattern to search at the grid.
     * @return A String representing if the pattern was found YES, otherwise NO is returned.
     */
    private static String gridSearch(final List<String> grid, final List<String> pattern) {

        final Map<Integer, List<Integer[]>> indexes = new HashMap<>();

        int lineNumber = 0;
        String patternLine = pattern.get(0);

        for (String gridLine : grid) {
            collectPositions(indexes, patternLine, gridLine, lineNumber);
            lineNumber++;
        }

        for (Map.Entry<Integer, List<Integer[]>> entry : indexes.entrySet()) {
            if (matchPattern(entry.getKey(), grid, pattern, entry.getValue()))
                return "YES";
        }

        return "NO";
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings({"Duplicates", "unused"})
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int t = Integer.parseInt(
                    bufferedReader.readLine()
                            .trim());

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                for (int tItr = 0; tItr < t; tItr++) {

                    final String[] firstMultipleInput = bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR);

                    final int R = Integer.parseInt(firstMultipleInput[0]);
                    final int C = Integer.parseInt(firstMultipleInput[1]);

                    final List<String> grid = new ArrayList<>();

                    for (int i = 0; i < R; i++) {
                        final String GItem = bufferedReader.readLine();
                        grid.add(GItem);
                    }

                    final String[] secondMultipleInput = bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR);

                    final int r = Integer.parseInt(secondMultipleInput[0]);
                    final int c = Integer.parseInt(secondMultipleInput[1]);

                    final List<String> pattern = new ArrayList<>();

                    for (int i = 0; i < r; i++) {
                        final String PItem = bufferedReader.readLine();
                        pattern.add(PItem);
                    }

                    final String result = gridSearch(grid, pattern);

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
