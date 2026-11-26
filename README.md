# Breakout

A Breakout game written in Java. This is phase 1 of the Advanced Programming course project.

**Status:** work in progress.

## Built with

- Java
- ACM graphics library (`lib/acm.jar`)

## How to run

From the repository root on Windows:

```
javac --release 11 -cp lib/acm.jar -d out src/breakout/*.java src/breakout/controller/*.java src/breakout/view/*.java
java -cp "out;lib/acm.jar" breakout.Main
```
