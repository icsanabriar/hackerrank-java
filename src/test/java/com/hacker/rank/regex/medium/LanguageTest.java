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

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

/**
 * Class to handle the test cases given on hacker rank website.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class LanguageTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "# let us create a test string" + SEPARATOR +
                SEPARATOR +
                SEPARATOR +
                "testString1 = \"Hello World!\"" + SEPARATOR +
                "print \"Original String: \"+ testString1" + SEPARATOR;

        final String expectedOutput = "Python" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Language instance = new Language();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void second_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "import java.io.*;" + SEPARATOR +
                "class ShellSort" + SEPARATOR +
                "{" + SEPARATOR +
                "void ShellSort(int array[], int number_of_elements)" + SEPARATOR +
                "{" + SEPARATOR +
                "        int iter, jter, increment, temp,i,j;" + SEPARATOR +
                "        for(increment = number_of_elements/2;increment > 0; increment /= 2)" + SEPARATOR +
                "        {" + SEPARATOR +
                "                for(i = increment; i<number_of_elements; i++)" + SEPARATOR +
                "                {" + SEPARATOR +
                "                        temp = array[i];" + SEPARATOR +
                "                        for(j = i; j >= increment ;j-=increment)" + SEPARATOR +
                "                        {" + SEPARATOR +
                "                                if(temp < array[j-increment])" + SEPARATOR +
                "                                {" + SEPARATOR +
                "                                        array[j] = array[j-increment];" + SEPARATOR +
                "                                }" + SEPARATOR +
                "                                else" + SEPARATOR +
                "                                {" + SEPARATOR +
                "                                        break;" + SEPARATOR +
                "                                }" + SEPARATOR +
                "                        }" + SEPARATOR +
                "                        array[j] = temp;" + SEPARATOR +
                "                }" + SEPARATOR +
                "        }" + SEPARATOR +
                "}";

        final String expectedOutput = "Java" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Language.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void third_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "#include<stdio.h>" + SEPARATOR +
                "#include<stdlib.h>" + SEPARATOR +
                "" + SEPARATOR +
                "typedef struct treeNode" + SEPARATOR +
                "{" + SEPARATOR +
                "        int data;" + SEPARATOR +
                "        struct treeNode *left;" + SEPARATOR +
                "        struct treeNode *right;" + SEPARATOR +
                SEPARATOR +
                "}treeNode;";

        final String expectedOutput = "C" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Language.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
