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
public class CommentTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = " /*This is a program to calculate area of a circle after getting the radius as input from the user*/" + SEPARATOR +
                "#include<stdio.h>" + SEPARATOR +
                "int main()" + SEPARATOR +
                "{" + SEPARATOR +
                "   double radius,area;//variables for storing radius and area" + SEPARATOR +
                "   printf(\"Enter the radius of the circle whose area is to be calculated\\n\");" + SEPARATOR +
                "   scanf(\"%lf\",&radius);//entering the value for radius of the circle as float data type" + SEPARATOR +
                "   area=(22.0/7.0)*pow(radius,2);//Mathematical function pow is used to calculate square of radius" + SEPARATOR +
                "   printf(\"The area of the circle is %lf\",area);//displaying the results" + SEPARATOR +
                "   getch();" + SEPARATOR +
                "}" + SEPARATOR +
                "/*A test run for the program was carried out and following output was observed" + SEPARATOR +
                "If 50 is the radius of the circle whose area is to be calculated" + SEPARATOR +
                "The area of the circle is 7857.1429*/";

        final String expectedOutput = "/*This is a program to calculate area of a circle after getting the radius as input from the user*/" + SEPARATOR +
                "//variables for storing radius and area" + SEPARATOR +
                "//entering the value for radius of the circle as float data type" + SEPARATOR +
                "//Mathematical function pow is used to calculate square of radius" + SEPARATOR +
                "//displaying the results" + SEPARATOR +
                "/*A test run for the program was carried out and following output was observed" + SEPARATOR +
                "If 50 is the radius of the circle whose area is to be calculated" + SEPARATOR +
                "The area of the circle is 7857.1429*/" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Comment instance = new Comment();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
