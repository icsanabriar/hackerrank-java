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
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class GridSearch {

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = " ";

    /**
     * Search the given pattern P on the grid G.
     *
     * @param G Grid to search the pattern.
     * @param P Pattern to search at the grid.
     * @return A String representing if the pattern was found YES, otherwise NO is returned.
     */
    private static String gridSearch(String[] G, String[] P) {



        return "NO";
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

        final int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {

            final String[] RC = scanner.nextLine().split(SEPARATOR);

            final int R = Integer.parseInt(RC[0]);

            final String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                final String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            final String[] rc = scanner.nextLine().split(SEPARATOR);

            final int r = Integer.parseInt(rc[0]);

            final String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                final String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            final String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }

}
