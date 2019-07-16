package com.mytaxi.app.pages;

import android.support.test.espresso.matcher.ViewMatchers;

import com.mytaxi.app.R;
import com.mytaxi.app.Utils.ActionsHelper;

import junit.framework.Assert;

import org.hamcrest.Matcher;

public class Login {
    ActionsHelper actionsHelper = new ActionsHelper();
    int usernameId = R.id.edt_username,
            passwordId = R.id.edt_password,
            drawerId = R.id.drawer_layout,
            loginBtnId = R.id.btn_login,
            navUsernameId = R.id.nav_username;

    Matcher usernameField = ViewMatchers.withId(usernameId),
            passwordField = ViewMatchers.withId(passwordId),
            navUsername = ViewMatchers.withId(navUsernameId),
            loginBtn = ViewMatchers.withId(loginBtnId),
            drawer = ViewMatchers.withId(drawerId);


    public void login (String username,String pass){
        if(!checkLoggingIn()){
             setUsername(username);
             setPassword(pass);
             actionsHelper.clickOn(loginBtn);
             actionsHelper.waitForElement(drawer,10000);
         }


         if(!checkLoginSuccess(username)){
             Assert.fail("Error in Logging in");
         }

    }

    void setUsername(String user){
        actionsHelper.setText(usernameField,user);
    }


    void setPassword(String pass){
        actionsHelper.setText(passwordField,pass);

    }

    public boolean checkLoggingIn(){
        if(actionsHelper.checkElementIsDisplayed(usernameField)){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean checkLoginSuccess(String user) {
        if (actionsHelper.checkElementIsDisplayed(drawer)) {
            actionsHelper.openDrawer(drawer);
            if (actionsHelper.checkElementIsDisplayed(navUsername)) {
                if(actionsHelper.assertText(navUsername, user)){
                    actionsHelper.closeDrawer(drawer);
                    return true;
                }
            }
        }
        return false;
    }
}
