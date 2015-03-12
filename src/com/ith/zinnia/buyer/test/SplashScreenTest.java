package com.ith.zinnia.buyer.test;

import org.junit.Before;
import org.junit.Test;

import android.app.Activity;
import android.app.Instrumentation;
import android.graphics.drawable.Drawable;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.ImageView;

import com.ith.zinnia.buyer.ActivityDashboard;
import com.ith.zinnia.buyer.SplashScreen;


public class SplashScreenTest extends ActivityInstrumentationTestCase2<SplashScreen> {

	private SplashScreen context; 
	private 	ImageView btnLetsGo;
	private ActivityDashboard contextActivityDashboard; 
	private Drawable actual,expected;
	private int resId;

	public SplashScreenTest() {
		this("SplashScreen");
	}

	public SplashScreenTest(String name) {
		super(SplashScreen.class);
		setName("SplashScreen");
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();

		setActivityInitialTouchMode(false);
		context = getActivity();
		btnLetsGo = (ImageView)context.findViewById(com.ith.zinnia.R.id.btnLetsGo);

		resId = com.ith.zinnia.R.drawable.letsgo;
		
		actual = btnLetsGo.getDrawable();
		expected = context.getResources().getDrawable(resId);

	}

	@Test
	public void testCondition1(){

		assertNotNull(context);
		assertNotNull(btnLetsGo);
	}

	@Test
	public void testCondition2(){

		assertEquals(expected.getConstantState(), actual.getConstantState());

		final View decorView = context.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(decorView, btnLetsGo);
		assertTrue(View.VISIBLE ==  btnLetsGo.getVisibility());

	}

	@Test
	public void testCondition3(){

		Instrumentation instrumentation = getInstrumentation();
		Instrumentation.ActivityMonitor monitor = instrumentation.addMonitor(ActivityDashboard.class.getName(), null, false);
		
		context.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				btnLetsGo.performClick();
			}
		});
		
		Activity currentActivity = getInstrumentation().waitForMonitor(monitor);
		contextActivityDashboard = (ActivityDashboard) currentActivity;
		assertNotNull(contextActivityDashboard);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
