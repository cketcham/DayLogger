package com.cketcham.daylogger;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class Description extends Activity {

	private static final int MAIN_FINISHED = 0;
	private static final int SUB_FINISHED = 1;
	private LogRow log;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.description);

		log = new LogRow(this);
		final Date time = new Date();
		log.time = time.getTime();	

		final TimePicker timepicker = (TimePicker) findViewById(R.id.time);
		timepicker.setCurrentHour(time.getHours());
		timepicker.setCurrentMinute(time.getMinutes());

		Button next = (Button) findViewById(R.id.submit);
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				log.main = getIntent().getStringExtra("main");
				log.sub = getIntent().getStringExtra("sub");
				log.description = ((EditText) findViewById(R.id.description)).getText().toString();
				log.time = new Date(time.getYear(), time.getMonth(), time.getDay(),timepicker.getCurrentHour(),timepicker.getCurrentMinute(),time.getSeconds()).getTime();
				//log.put();
				setResult(Activity.RESULT_OK);
				finish();
			}

		});

	}

}