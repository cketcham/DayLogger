package com.cketcham.daylogger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DayLogger extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		startActivity(new Intent(this, MainCatChooser.class));
		finish();

	}


}