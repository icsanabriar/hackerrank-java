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
package com.hacker.rank.common;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Class that is responsible of generating HASHES based on given algorithm.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class Hash {

    /**
     * Private constructor to hide public one.
     */
    private Hash() {
        throw new IllegalStateException("This utility class and should be used in such mode.");
    }

    /**
     * Function that prints out the HASH of given string over console and print the result based on the given algorithm.
     * <p>
     * Currently supported algorithms:
     * <p>
     * - MD5 <p>
     * - SHA <p>
     *
     * @param algorithm Name of the algorithm to generate and print the hash.
     * @throws NoSuchAlgorithmException Thrown when the hashing algorithm specification is different than supported algorithms.
     */
    public static void generate(final String algorithm) throws NoSuchAlgorithmException {

        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.next();

        final MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        final byte[] hashBytes = messageDigest.digest(
                input.getBytes(StandardCharsets.UTF_8));

        final String hash = DatatypeConverter.printHexBinary(hashBytes)
                .toLowerCase();

        System.out.println(hash);

        scanner.close();
    }

}
