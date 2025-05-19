package com.greedgame;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"classpath:greedGame/features"},
    glue = {"com.greedgame"})
public class RunCucumberTest {}