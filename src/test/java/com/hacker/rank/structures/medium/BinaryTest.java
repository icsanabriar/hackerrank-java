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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class BinaryTest {

    @Test
    public void given_test_case() {

        final Node root = new Node(3);

        final Node lc = new Node(5);
        lc.left = new Node(1);
        lc.right = new Node(4);

        final Node rc = new Node(2);
        rc.left = new Node(6);

        root.left = lc;
        root.right = rc;

        final Binary instance = new Binary();
        final boolean result = instance.checkBST(root);

        assertFalse(result);
    }

    @Test
    public void second_test_case() {

        final Node root = new Node(4);

        final Node seven = new Node(7);

        final Node six = new Node(6);
        six.right = seven;

        final Node five = new Node(5);
        five.right = six;

        root.right = five;

        final Binary instance = new Binary();
        final boolean result = instance.checkBST(root);

        assertTrue(result);
    }

}
