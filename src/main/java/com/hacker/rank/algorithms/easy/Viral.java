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
public class Viral {

    /**
     * Calculates the cumulative number of people who have liked the ad at a given time.
     *
     * @param n Number of days to calculate the cumulative number of people.
     * @return Number representing the cumulative people.
     */
    private static int viralAdvertising(int n) {

        int receive = 5;
        int totalLikes = 0;

        for (int i = 0; i < n; i++) {

            final int likes = receive / 2;

            totalLikes += likes;
            receive = likes * 3;
        }

        return totalLikes;
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

        final int n = scanner.nextInt();
        final int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

}
