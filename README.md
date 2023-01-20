# Hacker Rank Solutions

version 1.3.0 - 16/01/2023

[![License](https://img.shields.io/badge/license-apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Build](https://img.shields.io/github/actions/workflow/status/icsanabriar/hackerrank-java/main.yml)](https://github.com/icsanabriar/hackerrank-java/actions/workflows/main.yml)
[![PR](https://img.shields.io/github/issues-pr/icsanabriar/hackerrank-java)](https://github.com/icsanabriar/hackerrank-java/pulls)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=icsanabriar_hackerrank-java&metric=alert_status)](https://sonarcloud.io/project/overview?id=icsanabriar_hackerrank-java)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=icsanabriar_hackerrank-java&metric=bugs)](https://sonarcloud.io/project/issues?resolved=false&types=BUG&id=icsanabriar_hackerrank-java)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=icsanabriar_hackerrank-java&metric=coverage)](https://sonarcloud.io/component_measures?id=icsanabriar_hackerrank-java&metric=coverage)
[![Size](https://sonarcloud.io/api/project_badges/measure?project=icsanabriar_hackerrank-java&metric=ncloc)](https://sonarcloud.io/code?id=icsanabriar_hackerrank-java)
[![TechnicalDebt](https://sonarcloud.io/api/project_badges/measure?project=icsanabriar_hackerrank-java&metric=sqale_index)](https://sonarcloud.io/component_measures?metric=Maintainability&id=icsanabriar_hackerrank-java)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=icsanabriar_hackerrank-java&metric=vulnerabilities)](https://sonarcloud.io/project/issues?resolved=false&types=VULNERABILITY&id=icsanabriar_hackerrank-java)

## Introduction

HackerRank is a online platform to connect companies with developers to practice and hire right people based on skill 
assessments.

## Requirements

- JDK 14.x
- Maven 3.6.x
- IDE for JAVA (Eclipse, Netbeans, IntelliJ).

## Running Application inside IDE

To run the application on your IDE:

1. Verify the version of your JDK - 14.x or higher.
2. Verify the version of Maven - 3.6.x or higher.
3. Download the source code from repository.
4. Integrate your project with IDE:
    - [Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html)
    - [Netbeans](http://wiki.netbeans.org/MavenBestPractices)
    - [IntelliJ]( https://www.jetbrains.com/idea/help/importing-project-from-maven-model.html)
5. Open IDE and run each class to see the solution results.

## Running Unit Tests on Terminal

To run the unit tests on terminal:

1. Verify the version of your JDK - 14.x or higher.
2. Verify the version of Maven - 3.6.x or higher.
3. Download the source code from repository.
4. Open a terminal.
5. Go to the root location of the source code.
6. Execute the commands:

```bash
    mvn clean test
```

## Check Application Test Coverage using Jacoco

To verify test coverage on terminal:

1. Verify the version of your JDK - 14.x or higher.
2. Verify the version of Maven - 3.6.x or higher.
3. Download the source code from repository.
4. Open a terminal.
5. Go to the root location of the source code.
6. Execute the commands:

```bash
    mvn clean verify
    open target/site/jacoco/index.html
```

## List Dependency Licenses

To generate list of dependency licenses on terminal:

1. Verify the version of your JDK - 14.x or higher.
2. Verify the version of Maven - 3.6.x or higher.
3. Download the source code from repository.
4. Open a terminal.
5. Go to the root location of the source code.
6. Execute the commands:

```bash
    mvn project-info-reports:dependencies
    open target/site/dependencies.html
```

# Contact Information

Email: icsanabriar@googlemail.com