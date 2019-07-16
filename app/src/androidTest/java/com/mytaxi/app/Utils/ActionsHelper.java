package com.mytaxi.app.Utils;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.mytaxi.app.activities.MainActivity;

import junit.framework.Assert;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class ActionsHelper {
    public void setText(Matcher v , String text){
        Espresso.onView(v).check(matches(isDisplayed())).perform(typeText(text));
        Espresso.onView(v).check(ViewAssertions.matches(ViewMatchers.withText(text)));
    }

    public void clickOn(Matcher v ){
        Espresso.onView(v).check(matches(isDisplayed())).perform(click());
    }

    public void openDrawer(Matcher v){
        Espresso.onView(v).check((matches(isEnabled()))).perform(DrawerActions.open());
    }

    public void closeDrawer(Matcher v){
        Espresso.onView(v).check (matches(isDisplayed())).perform(DrawerActions.close());
    }

    public boolean checkElementIsDisplayed(Matcher m){
        try {
            onView(m).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean assertText(Matcher m,String text){
        try {
            onView(m).check(matches(ViewMatchers.withText(text)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElement(Matcher m ,int time)  {
        for(;time>0;time-=100){

            try{Thread.sleep(100);}
            catch(Exception e){}
            if(checkElementIsDisplayed(m)){
                return;
            }
        }
        Assert.fail("Couldn't find the Element");
    }

    public boolean checkNameInAutoCompleteTextView(String s,MainActivity mActivity){
        try {
            onView(withText(s))
                    .inRoot(RootMatchers.withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                    .check(matches(isDisplayed()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void clickOnNameInAutoCompleteTextView(String s,MainActivity mActivity){
        try {
            onView(withText(s))
                    .inRoot(RootMatchers.withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                    .perform(scrollTo()).perform(click());

        }
        catch (Exception e){
            Assert.fail("Couldn't click on  this name because of "+e.getMessage());
        }
    }
    public String getText(final Matcher matcher) {
        final String[] stringHolder = { null };
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                AutoCompleteTextView tv = (AutoCompleteTextView)view; //Save, because of check in getConstraints()
                stringHolder[0]= tv.getText().toString();
            }
        });
        return stringHolder[0];
    }
}
