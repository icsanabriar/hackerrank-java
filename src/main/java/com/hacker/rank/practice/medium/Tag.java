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
package com.hacker.rank.practice.medium;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class Tag {

    /**
     * Define the end tag string to validate found tag is closing html / xml tag.
     */
    private static final String END_TAG = "</";

    /**
     * Define pattern to identify html tags.
     */
    private static final Pattern PATTERN = Pattern.compile("(<|</)[^<>/]+>");

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);

        int testCases = Integer.parseInt(
                in.nextLine()
        );

        while (testCases > 0) {

            final Stack<String> tags = new Stack<>();
            final LinkedList<String> texts = new LinkedList<>();

            final String line = in.nextLine();
            final Matcher matcher = PATTERN.matcher(line);

            int startLineIndex = 0;
            boolean lastStart = false;

            while (matcher.find()) {

                // Find the tags in each line.
                final String tag = matcher.group();

                // Extract the name of tag in the line.
                String name  = tag.substring(
                        1,
                        tag.length() - 1
                );

                if (tag.startsWith(END_TAG)) {

                    name = name.substring(1);

                    final String lastTagName = tags.pop();

                    // Validate the closing tag match with the opening tag.
                    if (name.equals(lastTagName) && lastStart) {

                        final String text = line.substring(
                                startLineIndex,
                                matcher.start()
                        );

                        if (!text.isEmpty()) {
                            texts.add(text);
                        }
                    }

                    lastStart = false;

                } else {

                    tags.push(name);
                    lastStart = true;
                }

                // Adjust index of the line after a tag is matched.
                startLineIndex = matcher.end();
            }

            // Transform the multiple text in multiple line texts.
            System.out.println(
                    texts.isEmpty() ?
                            "None" : String.join("\n", texts)
            );

            testCases--;
        }

        in.close();
    }

}
