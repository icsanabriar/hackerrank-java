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
public class Rotation {

    /**
     * Return the values of given queries after array a is rotated k times.
     *
     * @param a       Array to rotate.
     * @param k       Number of times array should be rotated.
     * @param queries Indexes to query after rotation.
     * @return Results of queries after rotation is made on given array.
     */
    private static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        final int n = a.length;
        final int[] results = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            final int q = queries[i];
            final int estimatedIndex = ((q - k) % n + n) % n;

            results[i] = a[estimatedIndex];
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

        final Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            final int n = scanner.nextInt();
            final int k = scanner.nextInt();
            final int q = scanner.nextInt();

            final int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            final int[] queries = new int[q];

            for (int i = 0; i < q; i++) {
                queries[i] = scanner.nextInt();
            }

            final int[] result = circularArrayRotation(a, k, queries);

            for (int i = 0; i < result.length; i++) {

                bufferedWriter.write(
                        String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.newLine();

        }

        scanner.close();
    }

}
