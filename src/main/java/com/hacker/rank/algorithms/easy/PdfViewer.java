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
public class PdfViewer {

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = " ";

    /**
     * Designer pdf viewer calculates the highlight area for the given word, taking into account the heights of each letter.
     *
     * @param h    Height of letters.
     * @param word Word to highlight on text.
     * @return Area that is going to be highlighted.
     */
    private static int designerPdfViewer(int[] h, String word) {

        final int maximumHeight = word.chars()
                .map(c -> h[c - 'a'])
                .max()
                .orElse(0);

        return word.length() * maximumHeight;
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
        final FileWriter fileWriter = new FileWriter(System.getenv("OUTPUT_PATH"));
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        final int[] h = new int[26];

        final String[] hItems = scanner.nextLine()
                .split(SEPARATOR);

        for (int i = 0; i < 26; i++) {
            final int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        final String word = scanner.nextLine();

        final int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

}
