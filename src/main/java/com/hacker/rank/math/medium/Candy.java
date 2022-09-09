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
package com.hacker.rank.math.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Candy {

    /**
     * Retrieves the number of ways Jim can purchase k candies based on n types offered by the store.
     *
     * @param n Number of types offered.
     * @param k Number candies that Jim can purchase.
     * @return Number of ways Jim can buy the k candies.
     */
    private static int solve(int n, int k) {

        final BigInteger modulus = BigInteger.valueOf(1000000000);

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n - 1; i++) {
            result = result.multiply(BigInteger.valueOf(k + n - i))
                    .divide(BigInteger.valueOf(i));
        }

        return result.mod(modulus)
                .intValue();
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

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                final int t = Integer.parseInt(
                        bufferedReader.readLine()
                                .trim());

                for (int i = 0; i < t; i++) {

                    final int n = Integer.parseInt(
                            bufferedReader.readLine()
                                    .trim());

                    final int k = Integer.parseInt(
                            bufferedReader.readLine()
                                    .trim());

                    final int result = solve(n, k);
                    final String output = String.valueOf(result);

                    bufferedWriter.write(output);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
