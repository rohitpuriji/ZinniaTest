package com.ith.zinnia.buyer.test;

import org.junit.Test;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.test.ActivityInstrumentationTestCase2;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ith.zinnia.R;
import com.ith.zinnia.buyer.ActivityDashboard;
import com.ith.zinnia.buyer.FragmentDashboard;

public class DashboardActivityTest extends ActivityInstrumentationTestCase2<ActivityDashboard>{

	private ActionBar mActionBar;
	private FragmentDashboard fragmentDashboard;
	private TextView tvOcassions;
	private TextView tvSympathy;
	private TextView tvBecause;
	private TextView tvWell;
	private TextView tvBday;	
	private View view;
	private LayoutInflater inflater;
	private String expectedBday = "HAPPY BIRTHDAY";
	private String expectedBecause = "JUST BECAUSE";
	private String expectedWell = "GET WELL";
	private String expectedSympathy = "SYMPATHY";
	private ActivityDashboard contextActivityDashboard; 
	
	private Drawable actualBdayImg,expectedBdayImg;
	private Drawable actualBecauseImg,expectedBecauseImg;
	private Drawable actualWellImg,expectedWellImg;
	private Drawable actualSympathyImg,expectedSympathyImg;

	private RelativeLayout relativeBday;
	private RelativeLayout relativeBecause;
	private RelativeLayout relativeWell;
	private RelativeLayout relativeSympathy;

	private int resIdBday;
	private int resIdBecause;
	private int resIdWell;
	private int resIdSympathy;

	public DashboardActivityTest() {
		super(ActivityDashboard.class);
	}

	@Test
	public void testCondition1() throws Exception{


		fragmentDashboard = new FragmentDashboard();
		contextActivityDashboard = getActivity();
		
		inflater = LayoutInflater.from(contextActivityDashboard);
		view = inflater.inflate(R.layout.fragment_dashboard,null, false);

		mActionBar = contextActivityDashboard.getActionBar();

		tvOcassions = (TextView)view.findViewById(R.id.tvOcassions);
		tvSympathy = (TextView)view.findViewById(R.id.tvSympathy);
		tvBecause = (TextView)view.findViewById(R.id.tvBecause);
		tvWell = (TextView)view.findViewById(R.id.tvWell);
		tvBday = (TextView)view.findViewById(R.id.tvBday);
		relativeBday = (RelativeLayout)view.findViewById(R.id.relativeBday);
		relativeBecause = (RelativeLayout)view.findViewById(R.id.relativeBecause);
		relativeWell = (RelativeLayout)view.findViewById(R.id.relativeWell);
		relativeSympathy = (RelativeLayout)view.findViewById(R.id.relativeSympathy);

		assertNotNull(mActionBar);
		assertNotNull(fragmentDashboard);
		assertNotNull(view);
		
		assertNotNull(tvOcassions);
		assertNotNull(tvSympathy);
		assertNotNull(tvBecause);
		assertNotNull(tvWell);
		assertNotNull(tvBday);
		
		assertNotNull(relativeBday);
		assertNotNull(relativeBecause);
		assertNotNull(relativeWell);
		assertNotNull(relativeSympathy);
		
		resIdBday = com.ith.zinnia.R.drawable.birthday;
		resIdBecause = com.ith.zinnia.R.drawable.justbecause;
		resIdWell = com.ith.zinnia.R.drawable.getwell;
		resIdSympathy = com.ith.zinnia.R.drawable.sympathy;

		actualBdayImg = relativeBday.getBackground();
		expectedBdayImg = contextActivityDashboard.getResources().getDrawable(resIdBday);
	
		actualBecauseImg = relativeBecause.getBackground();
		expectedBecauseImg = contextActivityDashboard.getResources().getDrawable(resIdBecause);
		
		actualWellImg = relativeWell.getBackground();
		expectedWellImg = contextActivityDashboard.getResources().getDrawable(resIdWell);
		
		actualSympathyImg = relativeSympathy.getBackground();
		expectedSympathyImg = contextActivityDashboard.getResources().getDrawable(resIdSympathy);
		
		assertEquals(expectedBdayImg.getConstantState(), actualBdayImg.getConstantState());
		assertEquals(expectedBecauseImg.getConstantState(), actualBecauseImg.getConstantState());
		assertEquals(expectedWellImg.getConstantState(), actualWellImg.getConstantState());
		assertEquals(expectedSympathyImg.getConstantState(), actualSympathyImg.getConstantState());

		assertEquals(expectedBday, tvBday.getText().toString());
		assertEquals(expectedBecause, tvBecause.getText().toString());
		assertEquals(expectedWell, tvWell.getText().toString());
		assertEquals(expectedSympathy, tvSympathy.getText().toString());
		
		contextActivityDashboard.runOnUiThread(new Runnable() {
			 
			@Override
			public void run() {
				relativeBday.performClick();
			}
		});
		
		
	}

}
