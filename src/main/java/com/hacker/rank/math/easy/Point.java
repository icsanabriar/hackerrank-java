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
package com.hacker.rank.math.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Point {

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
     * Find the reflection point of the given coordinates pair.
     *
     * @param px X coordinate of point P.
     * @param py Y coordinate of point P.
     * @param qx X coordinate of point Q.
     * @param qy Y coordinate of point Q.
     * @return List of integer with X and Y coordinate of the reflection point.
     */
    private static List<Integer> findPoint(int px, int py, int qx, int qy) {

        final List<Integer> result = new ArrayList<>();

        result.add(qx * 2 - px);
        result.add(qy * 2 - py);

        return result;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int n = Integer.parseInt(
                    bufferedReader.readLine()
                            .trim());

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                for (int tItr = 0; tItr < n; tItr++) {

                    String[] firstMultipleInput = bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR);

                    final int px = Integer.parseInt(firstMultipleInput[0]);
                    final int py = Integer.parseInt(firstMultipleInput[1]);
                    final int qx = Integer.parseInt(firstMultipleInput[2]);
                    final int qy = Integer.parseInt(firstMultipleInput[3]);

                    List<Integer> result = findPoint(px, py, qx, qy);

                    bufferedWriter.write(
                            result.stream()
                                    .map(Object::toString)
                                    .collect(joining(" "))
                                    + "\n");
                }
            }
        }
    }

}
