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

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Email {

    /**
     * Extract the emails found in the given text.
     *
     * @param text Text to extract the emails.
     * @return CSV string representing the emails found in the text.
     */
    private static String extract(String text) {

        final Set<String> emails = new TreeSet<>();

        final Pattern pattern = Pattern.compile("[\\w]+(\\.[\\w]+)*@[\\w]+(\\.[\\w]+)+");
        final Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {

            final String email = matcher.group();
            emails.add(email);
        }

        return String.join(";", new ArrayList<>(emails));
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final StringBuilder builder = Comment.readInput();
        final String result = extract(builder.toString());

        System.out.println(result);
    }

}
