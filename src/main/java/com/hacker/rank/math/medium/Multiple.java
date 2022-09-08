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
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Multiple {

    /**
     * Define digits used to generate the number.
     */
    private static final BigInteger[] DIGITS = {BigInteger.ZERO, BigInteger.valueOf(9)};

    /**
     * Find a positive integer compose of 9 and 0 that is a multiple of n.
     *
     * @param n Multiple of generated number.
     * @return Positive integer compose of 9 and 0s.
     */
    private static BigInteger findMultiple(int n) {

        final boolean[] cache = new boolean[n];
        final BigInteger bn = BigInteger.valueOf(n);

        final Queue<BigInteger> queue = new LinkedList<>();
        queue.offer(DIGITS[0]);

        while (true) {

            final BigInteger head = queue.poll();

            for (BigInteger digit : DIGITS) {

                if (BigInteger.ZERO.equals(head) && digit.equals(BigInteger.ZERO))
                    continue;

                final BigInteger next = BigInteger.TEN.multiply(head)
                        .add(digit);

                final BigInteger remain = next.mod(bn);
                final int index = remain.intValue();

                if (remain.equals(BigInteger.ZERO)) {
                    return next;
                } else if (!cache[index]) {
                    cache[index] = true;
                    queue.offer(next);
                }
            }
        }
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

                    final BigInteger result = findMultiple(n);
                    final String output = String.valueOf(result);

                    bufferedWriter.write(output);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
