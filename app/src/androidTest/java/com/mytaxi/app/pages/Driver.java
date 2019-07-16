package com.mytaxi.app.pages;

import android.support.test.espresso.matcher.ViewMatchers;

import com.mytaxi.app.R;
import com.mytaxi.app.Utils.ActionsHelper;
import com.mytaxi.app.activities.MainActivity;

import junit.framework.Assert;

import org.hamcrest.Matcher;

public class Driver {
    ActionsHelper actionsHelper = new ActionsHelper();
    int searchFieldId = R.id.textSearch,
       driverNameId = R.id.textViewDriverName,
        callBtnId = R.id.fab;

    Matcher searchField = ViewMatchers.withId(searchFieldId),
        driverName = ViewMatchers.withId(searchFieldId),
        callBtn = ViewMatchers.withId(callBtnId);


    public void chooseDriver(String name, MainActivity m){
        if(actionsHelper.checkNameInAutoCompleteTextView(name,m)){
            actionsHelper.clickOnNameInAutoCompleteTextView(name,m);
            if(actionsHelper.checkElementIsDisplayed(driverName)){
                if(!actionsHelper.assertText(driverName,name)){
                    Assert.fail("Error while choosing this driver");
                }
            }
        }
        else{
            Assert.fail("Name Doesn't Exist in the Driver Menu");
        }

    }

   public void setDriverName(String name){
       try {
           Thread.sleep(4000);
           actionsHelper.setText(searchField,name);
            Thread.sleep(4000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

    }

    public void callDriver(){
        actionsHelper.waitForElement(callBtn,3000);
        actionsHelper.clickOn(callBtn);
    }
}
