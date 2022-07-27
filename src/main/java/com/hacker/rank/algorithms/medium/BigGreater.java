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
public class BigGreater {

    /**
     * Swap char exchange chars in the string builder with the given index and swap index.
     *
     * @param builder Builder to make the exchange of chars.
     * @param index   Index to make the char exchange.
     * @param swap    Swap index to make the char exchange.
     */
    private static void swapChar(StringBuilder builder, int index, int swap) {

        char temp = builder.charAt(index);

        builder.setCharAt(index, builder.charAt(swap));
        builder.setCharAt(swap, temp);
    }

    /**
     * Reverse chars of specific substring of the given string builder. Substring is defined by the given indexes.
     *
     * @param builder Builder to reverse the characters.
     * @param begin   Begin index of the substring to make the swap.
     * @param end     End index of the substring to make the swap.
     */
    private static void reverseChar(StringBuilder builder, int begin, int end) {

        for (int i = begin, j = end; i < j; i++, j--) {
            swapChar(builder, i, j);
        }
    }

    /**
     * Retrieves the smallest lexicographically higher string possible from the given string. In case is not found
     * no answer is returned.
     *
     * @param w String to find the smallest lexicographically higher string possible.
     * @return A String representing the smallest lexicographically higher string possible.
     */
    private static String biggerIsGreater(String w) {

        int index = w.length() - 2;

        while (index >= 0 && w.charAt(index) >= w.charAt(index + 1)) {
            index--;
        }

        if (index < 0)
            return "no answer";

        int swapIndex = index + 1;

        while (swapIndex + 1 < w.length() && w.charAt(swapIndex + 1) > w.charAt(index)) {
            swapIndex++;
        }

        StringBuilder builder = new StringBuilder(w);

        swapChar(builder, index, swapIndex);
        reverseChar(builder, index + 1, builder.length() - 1);

        return builder.toString();
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

            final int T = scanner.nextInt();

            for (int TItr = 0; TItr < T; TItr++) {

                final String w = scanner.next();
                final String result = biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }

        }

        scanner.close();
    }

}
