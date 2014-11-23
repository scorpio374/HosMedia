package com.zhsj.hosmedia;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.zhsj.hosmedia.parser.ChannelDetailParser;
import com.zhsj.hosmedia.parser.ChannelListParser;
import com.zhsj.hosmedia.parser.ProgramTypeParser;
import com.zhsj.hosmedia.parser.ScheduleDetailParser;
import com.zhsj.hosmedia.parser.ScheduleParser;
import com.zhsj.hosmedia.parser.SeriesDetailParser;
import com.zhsj.hosmedia.parser.SeriesParser;
import com.zhsj.hosmedia.parser.VodDetailParser;
import com.zhsj.hosmedia.parser.VodParser;
import com.zhsj.hosmedia.util.FileUtil;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_portal);
	}
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		testProgramType();
		testChannelList();
		testChannelDetail();
		testScheduleList();
		testScheduleDetail();
		testSeries();
		testSeriesDetail();
		testVodList();
		testVodDetail();
	}
	
	public void testChannelList(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_channellist_ok.txt");
		ChannelListParser.parse(response);
	}
	
	public void testProgramType(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_programtype_ok.txt");
		ProgramTypeParser.parse(response);
		
		response = FileUtil.getFileFromAssets(this, "ipanel_programtype2_ok.txt");
		ProgramTypeParser.parse(response);
	}
	
	public void testChannelDetail(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_channeldetail_ok.txt");
		ChannelDetailParser.parse(response);
	}
	
	public void testScheduleList(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_schedulelist_ok.txt");
		ScheduleParser.parse(response);
	}
	
	public void testScheduleDetail(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_scheduledetail_ok.txt");
		ScheduleDetailParser.parse(response);
	}
	
	public void testSeries(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_serieslist_ok.txt");
		SeriesParser.parse(response);
	}
	
	public void testSeriesDetail(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_seriesdetail_ok.txt");
		SeriesDetailParser.parse(response);
	}
	
	public void testVodList(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_vodlist_ok.txt");
		VodParser.parse(response);
	}
	
	public void testVodDetail(){
		String response = FileUtil.getFileFromAssets(this, "ipanel_voddetail_ok.txt");
		VodDetailParser.parse(response);
	}
}
