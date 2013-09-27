package com.mmf;

import com.jayway.android.robotium.solo.By;
import com.jayway.android.robotium.solo.Solo;

import android.preference.PreferenceManager;
import android.test.ActivityInstrumentationTestCase2;
import junit.framework.TestCase;

public class MyTCmmf extends ActivityInstrumentationTestCase2 {

	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME="com.mapmyfitness.android.activity.Launcher";
	private static Class launcherActivityClass;
	private Solo solo;
	
	public MyTCmmf() throws ClassNotFoundException {
		super(launcherActivityClass=Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME));
	}

	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testMMFapk() throws InterruptedException {
		
        solo.clickOnWebElement(By.xpath(".//*[@id='current_members']/a"));
        solo.waitForView(0);
        
        solo.enterTextInWebElement(By.xpath(".//*[@id='username_or_email']"), "TesterVindas");
        solo.enterTextInWebElement(By.xpath(".//*[@id='sign_in_password']"), "mmf123");
        
        solo.clickOnWebElement(By.xpath(".//*[@id='sign-in-button']"));
        solo.waitForActivity("com.mapmyfitness.android.activity.Dashboard");
        
        solo.clickOnButton("Workouts");
        solo.waitForActivity("com.mapmyfitness.android.activity.Workouts");        
        solo.waitForText("Last week");
        solo.clickOnScreen(200, 120);
        
        solo.waitForActivity("com.mapmyfitness.android.activity.WorkoutDetail");
        
        solo.clickOnScreen(450, 50);
        solo.waitForText("Facebook");
        solo.clickOnText("Facebook");
        solo.enterText(0,"Facebook - Robotium Test Case 01");
        solo.clickOnButton(1);
           
	}	
	
	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
