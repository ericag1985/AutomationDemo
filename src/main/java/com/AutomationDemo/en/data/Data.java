package com.AutomationDemo.en.data;


import org.testng.annotations.DataProvider;

/**
 * Created by egugliemella on 3/3/16.
 */
public class Data {

  @DataProvider(name = "userData")
  public static Object[][] userData() {
    return new Object[][] {
      {"egugliemella", "P@ssword6"}
    };
  }

}
