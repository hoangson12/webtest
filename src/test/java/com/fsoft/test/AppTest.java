package com.fsoft.test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.fsoft.base.BaseWeb;
import com.fsoft.model.LoginScreen;
import com.fsoft.model.RegisterScreen;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends BaseWeb {
    public LoginScreen login;
    public RegisterScreen res;
    public String usernameAdmin="webgoat";
    public String passwordAdmin="webgoat";

    @BeforeTest
    public void initTest()
    {
        this.init();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://localhost:8080/WebGoat/login");
        login = new LoginScreen();
        res = new RegisterScreen();
    }    

    @Test
    public void verifyLogoutAdmin ()
    {
        element(login.buttonUserMenu).click();
        element(login.buttonLogOut).click();
        Assert.assertEquals(element(login.textSuccessLogout).getText(), "You have logged out successfully");
    }

    @Test 
    public void verifyLoginAdminValid ()
    {        

        element(login.inputUsername).sendKeys(usernameAdmin);
        element(login.inputPassword).sendKeys(passwordAdmin);
        element(login.buttonSignIn).click();
        Assert.assertEquals(element(login.textWebTitle).getText(), "How to work with WebGoat");
    }

    @Test
    public void verifyLoginInvalid ()
    {
        element(login.inputUsername).sendKeys(randomString(10));
        element(login.inputPassword).sendKeys(randomString(10));
        element(login.buttonSignIn).click();
        Assert.assertEquals(element(login.textInvalidLogin).getText(),"Invalid username and password!");
    }


    public String randomString (int length)
    {
        String source = "qwertyuiopasdfghjkllzxcvbnm1234567890";
        Random ran = new Random();
        int bound = source.length();
        String result = "";
        for (int i=0;i<length;i++) result = result + source.charAt(ran.nextInt(bound));
        return result;
    }


    @AfterTest
    public void tearDown ()
    {
        driver.close();
    }

}
