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
public class DetectTest {

    /**
     * Define line separator for test cases.
     */
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void given_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "13" + SEPARATOR +
                "<div class=\"portal\" role=\"navigation\" id='p-navigation'>" + SEPARATOR +
                "<h3>Navigation</h3>" + SEPARATOR +
                "<div class=\"body\">" + SEPARATOR +
                "<ul>" + SEPARATOR +
                " <li id=\"n-mainpage-description\"><a href=\"/wiki/Main_Page\" title=\"Visit the main page [z]\" accesskey=\"z\">Main page</a></li>" + SEPARATOR +
                " <li id=\"n-contents\"><a href=\"/wiki/Portal:Contents\" title=\"Guides to browsing Wikipedia\">Contents</a></li>" + SEPARATOR +
                " <li id=\"n-featuredcontent\"><a href=\"/wiki/Portal:Featured_content\" title=\"Featured content  the best of Wikipedia\">Featured content</a></li>" + SEPARATOR +
                "<li id=\"n-currentevents\"><a href=\"/wiki/Portal:Current_events\" title=\"Find background information on current events\">Current events</a></li>" + SEPARATOR +
                "<li id=\"n-randompage\"><a href=\"/wiki/Special:Random\" title=\"Load a random article [x]\" accesskey=\"x\">Random article</a></li>" + SEPARATOR +
                "<li id=\"n-sitesupport\"><a href=\"//donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&utm_medium=sidebar&utm_campaign=C13_en.wikipedia.org&uselang=en\" title=\"Support us\">Donate to Wikipedia</a></li>" + SEPARATOR +
                "</ul>" + SEPARATOR +
                "</div>" + SEPARATOR +
                "</div>  ";

        final String expectedOutput = "/wiki/Main_Page,Main page" + SEPARATOR +
                "/wiki/Portal:Contents,Contents" + SEPARATOR +
                "/wiki/Portal:Featured_content,Featured content" + SEPARATOR +
                "/wiki/Portal:Current_events,Current events" + SEPARATOR +
                "/wiki/Special:Random,Random article" + SEPARATOR +
                "//donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&utm_medium=sidebar&utm_campaign=C13_en.wikipedia.org&uselang=en,Donate to Wikipedia" + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        final Detect instance = new Detect();
        instance.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

    @Test
    public void second_test_case() {

        final String[] args = {};
        final InputStream sysInBackup = System.in;

        final String input = "2" + SEPARATOR +
                "<p><a href=\"https://www.quackit.com/html/tutorial/html_links.cfm\">Example Link</a></p>" + SEPARATOR +
                "<div class=\"more-info\"><a href=\"https://www.quackit.com/html/examples/html_links_examples.cfm\">More Link Examples...</a></div>";

        final String expectedOutput = "https://www.quackit.com/html/tutorial/html_links.cfm,Example Link" + SEPARATOR +
                "https://www.quackit.com/html/examples/html_links_examples.cfm,More Link Examples..." + SEPARATOR;

        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream controllerOut = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(controllerOut));

        Detect.main(args);

        assertEquals(expectedOutput, controllerOut.toString());

        System.setIn(sysInBackup);
    }

}
