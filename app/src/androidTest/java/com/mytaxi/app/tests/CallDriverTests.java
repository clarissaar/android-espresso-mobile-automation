package com.mytaxi.app.tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.app.Utils.PropertyReader;
import com.mytaxi.app.activities.MainActivity;
import com.mytaxi.app.pages.Driver;
import com.mytaxi.app.pages.Login;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Properties;

@RunWith(AndroidJUnit4.class)
public class CallDriverTests {

    String username,password,searchWithText,driverName;
    Login loginActions = new Login();
    Driver driver = new Driver();
    MainActivity mainActivity;
    private Properties properties = new Properties();
    private PropertyReader propertyReader;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    @Before
    public void setUp()  {

        propertyReader = new PropertyReader(InstrumentationRegistry.getTargetContext());
        properties = propertyReader.getMyProperties("testData");

        mainActivity = mainActivityRule.getActivity();
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        searchWithText = properties.getProperty("searchWithText");
        driverName = properties.getProperty("driverName");
    }

    @Test
    public void searchForDriver(){
        if(!loginActions.checkLoginSuccess(username)){
            loginActions.login(username,password);
        }
        driver.setDriverName(searchWithText);
        driver.chooseDriver(driverName, mainActivity);
        driver.callDriver();


    }


}
