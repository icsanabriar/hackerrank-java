/*
 * Copyright (C) 2023 Iván Camilo Sanabria.
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
package com.hacker.rank.interview.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since 1.4.0
 */
public class Prefix {

    static class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private static boolean insertWord(String word, TrieNode root) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null)
                current.children[index] = new TrieNode();
            else if (current.children[index].isWord)
                return false;


            current = current.children[index];
        }

        current.isWord = true;

        for (TrieNode child : current.children) {
            if (child != null)
                return false;

        }

        return true;
    }

    /**
     * Validates the given list of words no one is prefix of another.
     *
     * @param words List of words.
     * @return String with the response if the given list is a GOOD SET or BAD SET.
     */
    private static String noPrefix(List<String> words) {

        TrieNode root = new TrieNode();

        for (String word : words) {
            if (!insertWord(word, root)) {
                return "BAD SET\n" + word;
            }
        }

        return "GOOD SET";
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int n = Integer.parseInt(
                    bufferedReader.readLine()
                            .trim());

            final List<String> words = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String word = bufferedReader.readLine();
                words.add(word);
            }

            final String result = noPrefix(words);

            System.out.println(result);
        }
    }

}
