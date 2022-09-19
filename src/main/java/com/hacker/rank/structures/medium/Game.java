/*
 * Copyright (C) 2022 Iván Camilo Sanabria.
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
package com.hacker.rank.structures.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Game {

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
     * Given the two stacks and maximum sum find the number of selections could be made.
     *
     * @param maxSum Maximum sum that could be done on selections.
     * @param a      First stack to make the selection.
     * @param b      Second stack to make the selection.
     * @return Maximum number of selections made with the given parameters.
     */
    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {

        int sum = 0;
        int index = 0;

        while (index < b.size() && sum + b.get(index) <= maxSum) {
            sum = sum + b.get(index);
            index++;
        }

        int maxScore = index;

        for (int i = 1; i <= a.size(); i++) {

            sum = sum + a.get(i - 1);

            while (sum > maxSum && index > 0) {
                index--;
                sum = sum - b.get(index);
            }

            if (sum > maxSum)
                break;

            maxScore = Math.max(maxScore, i + index);
        }

        return maxScore;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int g = Integer.parseInt(bufferedReader.readLine().trim());

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                for (int gItr = 0; gItr < g; gItr++) {

                    final String[] firstMultipleInput = bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR);

                    final int maxSum = Integer.parseInt(firstMultipleInput[2]);

                    final List<Integer> a = Stream.of(bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR))
                            .map(Integer::parseInt)
                            .collect(toList());

                    final List<Integer> b = Stream.of(bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR))
                            .map(Integer::parseInt)
                            .collect(toList());

                    final int result = twoStacks(maxSum, a, b);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
