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
package com.hacker.rank.practice.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class DayTime {

    /**
     * Regex used to process input of the program.
     */
    private static final String REGEX = "\\s+$";

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = " ";

    /**
     * Replacement of value inline.
     */
    private static final String REPLACEMENT = "";

    /**
     * Given the month, day and year of a date the function returns the week day (Monday).
     *
     * @param month Number representing the month of a date.
     * @param day   Number representing the day of a date.
     * @param year  Number representing the year of a date.
     * @return String representing the week day of the given date.
     */
    @SuppressWarnings("MagicConstant")
    private static String findDay(int month, int day, int year) {

        // Adjust the month to pass as parameter to calendar instance.
        final int estimatedMonth = month - 1;

        final Calendar gregorian = new GregorianCalendar();
        gregorian.set(year, estimatedMonth, day);

        return gregorian.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)
                .toUpperCase();
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in console.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final String[] firstMultipleInput = bufferedReader.readLine()
                    .replaceAll(REGEX, REPLACEMENT)
                    .split(SEPARATOR);

            final int month = Integer.parseInt(firstMultipleInput[0]);
            final int day = Integer.parseInt(firstMultipleInput[1]);
            final int year = Integer.parseInt(firstMultipleInput[2]);

            final String result = findDay(month, day, year);

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }
    }

}
