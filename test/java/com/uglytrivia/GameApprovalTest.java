package com.uglytrivia;

import java.io.*;
import java.util.Random;
import java.util.stream.IntStream;
import main.java.com.uglytrivia.GameRunner;
import org.approvaltests.Approvals;
import org.junit.Test;

public class GameApprovalTest {

  @Test
  public void itsLockedDown() throws Exception {

    Random randomizer = new Random(123455);
    ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(resultStream));

    IntStream.range(1, 15)
        .forEach(
            i -> {
              try {
                GameRunner.playGame(randomizer);
              } catch (InstantiationException e) {
                throw new RuntimeException(e);
              }
            });

    Approvals.verify(resultStream.toString());
  }
}