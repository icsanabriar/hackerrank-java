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
package com.hacker.rank.regex.medium;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Word {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    /**
     * Extract the emails found in the given text.
     *
     * @param text Text to extract the emails.
     * @return CSV string representing the emails found in the text.
     */
    private static int find(String word, String text) {

        final Pattern pattern = Pattern.compile("(?<![a-zA-Z0-9_])" + word + "(?![a-zA-Z0-9_])");
        final Matcher matcher = pattern.matcher(text);

        int counter = 0;

        while (matcher.find()) {
            counter++;
        }

        return counter;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            builder.append(sc.nextLine());
            builder.append(SEPARATOR);
        }

        final String text = builder.toString();
        final int t = sc.nextInt();

        for (int j = 0; j < t; j++) {

            final String word = sc.next();
            final int result = find(word, text);
            System.out.println(result);
        }

        sc.close();
    }

}
