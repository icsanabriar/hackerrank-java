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

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Floating {

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
     * Greatest Common Divisor for the given numbers a, b.
     *
     * @param a Number to calculate gcd.
     * @param b Number to calculate gcd.
     * @return Greatest common divisor of the given a,b.
     */
    private static int gcd(int a, int b) {
        return (b == 0) ? Math.max(1, a) : gcd(b, a % b);
    }

    /**
     * Return the number of rocks between the two given points.
     *
     * @param x1 X coordinate of P1.
     * @param y1 Y coordinate of P2.
     * @param x2 X coordinate of P1.
     * @param y2 Y coordinate of P2.
     * @return Number of rocks between P1 and P2.
     */
    private static int solve(int x1, int y1, int x2, int y2) {
        return gcd(Math.abs(x1 - x2), Math.abs(y1 - y2)) - 1;
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

            final int t = Integer.parseInt(bufferedReader.readLine().trim());

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                for (int tItr = 0; tItr < t; tItr++) {

                    final String[] firstMultipleInput = bufferedReader.readLine()
                            .replaceAll(REGEX, REPLACEMENT)
                            .split(SEPARATOR);

                    final int x1 = Integer.parseInt(firstMultipleInput[0]);
                    final int y1 = Integer.parseInt(firstMultipleInput[1]);

                    final int x2 = Integer.parseInt(firstMultipleInput[2]);
                    final int y2 = Integer.parseInt(firstMultipleInput[3]);

                    final int result = solve(x1, y1, x2, y2);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
