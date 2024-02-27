package com.gildedrose;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"classpath:gildedRose/features"},
    glue = {"com.gildedrose"})
public class RunCucumberTest {}