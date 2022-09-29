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
public class Comment {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    /**
     * Extract the comments found in the given text.
     *
     * @param text Text to extract the comments.
     * @return String representing the comments found in the text.
     */
    private static String extract(String text) {

        final Pattern pattern = Pattern.compile("(//[^\\n]*)|(/\\*.*?\\*/)", Pattern.MULTILINE | Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(text);

        final StringBuilder builder = new StringBuilder();

        while (matcher.find()) {

            final Scanner scanner = new Scanner(matcher.group());

            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine().trim());
                builder.append(SEPARATOR);
            }
        }

        return builder.substring(0, builder.length() - 1);
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        final StringBuilder builder = new StringBuilder();

        while (sc.hasNextLine()) {
            builder.append(sc.nextLine());
            builder.append(SEPARATOR);
        }

        final String result = extract(builder.toString());
        System.out.println(result);

        sc.close();
    }

}
