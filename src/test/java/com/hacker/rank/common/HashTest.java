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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.NoSuchAlgorithmException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases  for Hash.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class HashTest {

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void generate_md5_hash() throws NoSuchAlgorithmException {

        final InputStream sysInBackup = System.in;

        final String algorithm = "SHA-1";
        final String input = "This is a test";
        final String expectedOutput = "7971e6a051104074fdae0f02322417b6eb5695a2\n";

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Hash hash = new Hash();
        hash.generate(algorithm);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
