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

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class Kaprekar {

    /**
     * Separator string to print the Kaprekar range.
     */
    private static final String SEPARATOR = " ";

    /**
     * Return the number of digits of given a.
     *
     * @param a Number to calculate the digits.
     * @return A number representing the number of digits of the given a.
     */
    private static int digits(long a) {
        if (a < 100) {
            if (a < 10) {
                return 1;
            } else {
                return 2;
            }
        } else {
            if (a < 1000) {
                return 3;
            } else {
                if (a < 10000) {
                    return 4;
                } else {
                    return 5;
                }
            }
        }
    }

    /**
     * Prints in console the kaprekar numbers between the given range p and q. Assuming p < q.
     *
     * @param p Lower bound to generate kaprekar numbers.
     * @param q Higher bound to generate kaprekar numbers.
     */
    private static void kaprekarNumbers(int p, int q) {

        final LinkedList<String> results = new LinkedList<>();

        for (long i = p; i <= q; i++) {

            final int d = digits(i);
            final String square = String.valueOf(i * i);

            final int rightStartIndex = square.length() - d;

            int left = 0;
            int right;

            if (rightStartIndex <= 0) {

                right = Integer.parseInt(square);

            } else {

                right = Integer.parseInt(
                        square.substring(rightStartIndex)
                );

                left = Integer.parseInt(
                        square.substring(0, rightStartIndex)
                );
            }

            final int sum = left + right;

            if (sum == i) {

                final String value = String.valueOf(i);
                results.add(value);
            }
        }

        System.out.println(results.isEmpty() ? "INVALID RANGE" : String.join(SEPARATOR, results));
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int p = scanner.nextInt();
        final int q = scanner.nextInt();

        kaprekarNumbers(p, q);

        scanner.close();
    }

}
