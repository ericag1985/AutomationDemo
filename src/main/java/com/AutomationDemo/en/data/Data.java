package com.AutomationDemo.en.data;

import org.testng.annotations.DataProvider;

public class Data {

  @DataProvider(name = "userData")
  public static Object[][] userData() {
    return new Object[][] {
      {"egugliemella", "P@ssword7"}
    };
  }

}
