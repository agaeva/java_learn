package ru.stqa.pft.rest.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.rest.model.Contacts;
import ru.stqa.pft.rest.model.DataContact;
import ru.stqa.pft.rest.model.GroupData;
import ru.stqa.pft.rest.model.Groups;
import ru.stqa.pft.rest.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  public static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
  public WebDriver wd;

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUIGroup")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUI() {
    if (Boolean.getBoolean("verifyUIContact")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((c) -> new DataContact()
                      .withId(c.getId())
                      .withFirstname(c.getFirstname())
                      .withLastname(c.getLastname())
                      .withAddress(c.getAddress())
                      .withHomePhone(c.getHomePhone())
                      .withMobilePhone(c.getMobilePhone())
                      .withWorkPhone(c.getWorkPhone())
                      .withEmail(c.getEmail())
                      .withEmail2(c.getEmail2())
                      .withEmail3(c.getEmail3())
                      .withAddress(c.getAddress())
              ).collect(Collectors.toSet())));
    }
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
