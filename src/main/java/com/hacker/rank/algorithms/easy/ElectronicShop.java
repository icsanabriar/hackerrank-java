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
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class ElectronicShop {

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = " ";

    /**
     * Retrieves the money spent on keyboards and drives based on the given budget. In case the budget is not enough the
     * function return -1.
     *
     * @param keyboards List of prices of keywords.
     * @param drives    List of prices of drives.
     * @param b         Budget that is possible to spent in total of 1 keyword and 1 drive.
     * @return A number representing the total budget spent in total of 1 keyword and 1 drive.
     */
    private static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        int expenses = -1;

        Arrays.sort(drives);

        for (int keyboard : keyboards) {

            int index = Arrays.binarySearch(drives, b - keyboard);

            if (index < 0)
                // The index that is a match is the insertion point - 1.
                index = -1 - (index + 1);


            if (index >= 0)
                expenses = Math.max(expenses, keyboard + drives[index]);

        }

        return expenses;
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

        final String[] bnm = scanner.nextLine().split(SEPARATOR);

        int b = Integer.parseInt(bnm[0]);
        int n = Integer.parseInt(bnm[1]);
        int m = Integer.parseInt(bnm[2]);

        final int[] keyboards = new int[n];

        final String[] keyboardsItems = scanner.nextLine()
                .split(SEPARATOR);

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {

            final int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        final int[] drives = new int[m];

        final String[] drivesItems = scanner.nextLine()
                .split(SEPARATOR);

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {

            final int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        final int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

}
