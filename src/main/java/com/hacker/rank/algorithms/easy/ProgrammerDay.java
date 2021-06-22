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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class ProgrammerDay {

    /**
     * Estimates the 256th of the year based on Julian Calendar before 1918, after this year Gregorian Calendar.
     *
     * @param year Given year to estimate the date.
     * @return Day of the year based on the format dd.mm.yyyy.
     */
    private static String dayOfProgrammer(int year) {

        int dayOfYear = 256;

        if (year < 1918 && year % 100 == 0)
            dayOfYear--;

        if (year == 1918)
            dayOfYear = dayOfYear + 13;

        final LocalDate date = Year.of(year)
                .atDay(dayOfYear);

        return date.format(
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        final FileWriter fileWriter = new FileWriter(System.getenv("OUTPUT_PATH"));
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        final String yearLine = bufferedReader.readLine()
                .trim();

        final int year = Integer.parseInt(yearLine);
        final String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
