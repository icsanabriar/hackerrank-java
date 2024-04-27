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
package com.hacker.rank.algorithms.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class SherlockSquares {

    /**
     * Return the  number of squares (1,4,9...) of given range.
     *
     * @param a Start of the range.
     * @param b End of the range.
     * @return Number of squares in the given range.
     */
    private static int squares(int a, int b) {

        final int highSqrt = (int) Math.floor(Math.sqrt(b));

        int lowSqrt = (int) Math.floor(Math.sqrt(a));

        if (lowSqrt * lowSqrt == a)
            lowSqrt--;

        return highSqrt - lowSqrt;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        final Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            final int q = scanner.nextInt();

            for (int qItr = 0; qItr < q; qItr++) {

                final int a = scanner.nextInt();
                final int b = scanner.nextInt();

                final int result = squares(a, b);

                bufferedWriter.write(
                        String.valueOf(result));

                bufferedWriter.newLine();
            }

        }

        scanner.close();
    }

}
