package com.fsoft.model;

import org.omg.CORBA.PUBLIC_MEMBER;

public class LoginScreen {
    public String inputUsername = "//input[@id='exampleInputEmail1']";
    public String inputPassword = "//input[@id='exampleInputPassword1']";
    public String buttonSignIn = "//button[@class='btn btn-large btn-primary' and @type='submit']";
    public String linkRegister = "//a[@href='/WebGoat/registration']";

    public String textWebTitle = "//h1[@id='lesson-title']";

    public String textInvalidLogin = "//section[@id='main-content']/div[@class='error']";
    public String textSuccessLogout = "//section[@id='main-content']/div[@class='alert alert-success']";

    public String buttonUserMenu = "//button[@id='user-menu']";
    public String buttonLogOut = "//a[@href='j_spring_security_logout']";

}