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

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class MD5 {

    /**
     * Define algorithm name to hash the given string.
     */
    private static final String MD5 = "MD5";

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws NoSuchAlgorithmException Thrown when the hashing algorithm specification is different than supported algorithms.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws NoSuchAlgorithmException {

        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.next();

        final MessageDigest messageDigest = MessageDigest.getInstance(MD5);
        final byte[] hashBytes = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));

        final String hash = DatatypeConverter.printHexBinary(hashBytes)
                .toLowerCase();

        System.out.println(hash);

        scanner.close();
    }

}
