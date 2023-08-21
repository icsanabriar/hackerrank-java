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
package com.hacker.rank.structures.medium;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class DecoderTest {

    @Test
    public void given_test_case() {

        final String expectedOutput = "ABACA";
        final String s = "1001011";

        final CNode cll = new CNode(1);
        cll.data = 'B';
        assertEquals(cll.frequency, 1);

        final CNode clf = new CNode(1);
        clf.data = 'C';
        assertEquals(clf.frequency, 1);

        final CNode cl = new CNode(2);
        cl.left = cll;
        cl.right = clf;
        assertEquals(cl.frequency, 2);

        final CNode cr = new CNode(3);
        cr.data = 'A';
        assertEquals(cr.frequency, 3);

        final CNode root = new CNode(5);
        root.left = cl;
        root.right = cr;
        assertEquals(root.frequency, 5);

        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(controllerOut));

        final Decoder decoder = new Decoder();
        decoder.decode(s, root);

        assertEquals(expectedOutput, controllerOut.toString());
    }

}
