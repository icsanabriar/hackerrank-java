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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class Priority {

    /**
     * Priority queue used to handle student request.
     */
    private static final Priorities priorities = new Priorities();

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final Scanner scan = new Scanner(System.in);
        final List<String> events = new ArrayList<>();

        int totalEvents = Integer.parseInt(
                scan.nextLine());

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        final List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {

            System.out.println("EMPTY");

        } else {

            for (Student st : students) {

                final String name = st.getName();
                System.out.println(name);
            }
        }
    }

}

/**
 * Define class student.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
class Student {

    /**
     * Identifier of the student.
     */
    private int id;

    /**
     * Name of the student.
     */
    private String name;

    /**
     * CGPA of the student.
     */
    private double cgpa;

    /**
     * Constructor of the student with given identifier, name and CGPA.
     *
     * @param id   Identifier of the student.
     * @param name Name of the student.
     * @param cgpa CGPA of the student.
     */
    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    /**
     * Return the identifier of the student instance.
     *
     * @return Identifier of the student instance.
     */
    int getId() {
        return id;
    }

    /**
     * Return the name of the student instance.
     *
     * @return Name of the student instance.
     */
    String getName() {
        return name;
    }

    /**
     * Return the CGPA of the student instance.
     *
     * @return CGPA of the student instance.
     */
    double getCgpa() {
        return cgpa;
    }

}

/**
 * Define class Priorities.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
class Priorities {

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = " ";

    /**
     * Define priority queue.
     */
    private PriorityQueue<Student> students = new PriorityQueue<>((o1, o2) -> {

        if (Double.compare(o1.getCgpa(), o2.getCgpa()) != 0) {
            return Double.compare(o2.getCgpa(), o1.getCgpa());
        }

        if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        }

        return Integer.compare(o1.getId(), o2.getId());
    });

    /**
     * Retrieves the student list order by priority.
     *
     * @param events List of events to prioritize the students.
     * @return A List of Student with prioritization.
     */
    List<Student> getStudents(final List<String> events) {

        for (String event : events) {

            if (event.equals("SERVED")) {

                students.poll();

            } else {

                final String[] studentInput = event.split(SEPARATOR);

                final Student student = new Student(
                        Integer.parseInt(studentInput[3]),
                        studentInput[1],
                        Double.parseDouble(studentInput[2]));

                students.offer(student);
            }
        }

        // Make a copy using poll of the queue to guarantee the order
        final List<Student> results = new LinkedList<>();

        while (!students.isEmpty()) {
            results.add(students.poll());
        }

        return results;
    }

}
