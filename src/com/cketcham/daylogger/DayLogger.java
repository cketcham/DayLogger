package com.cketcham.daylogger;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DayLogger extends Activity {

	private static final int MAIN_FINISHED = 0;
	private static final int SUB_FINISHED = 1;
	private LogRow log;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		log = new LogRow(this);
		log.time = new Date().getTime();

		Intent intent = new Intent(this, ListSelectActivity.class);
		intent.putExtra("categories", categories);
		this.startActivityForResult(intent, MAIN_FINISHED);

		Button next = (Button) findViewById(R.id.submit);
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				log.description = ((EditText) findViewById(R.id.description)).getText().toString();
				log.put();
				finish();
			}

		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
			case MAIN_FINISHED :
				if (resultCode == RESULT_OK) {
					log.main = data.getExtras().getString("result");
					for (int i = 0; i < categories.length - 1; i++) {
						if (log.main.equals(categories[i])) {
							Intent intent = new Intent(this, ListSelectActivity.class);
							intent.putExtra("categories", subcategories[i]);
							this.startActivityForResult(intent, SUB_FINISHED);
						}
					}
				}
				break;
			case SUB_FINISHED :
				if (resultCode == RESULT_OK) {
					log.sub = data.getExtras().getString("result");
				}
				break;
		}
	}

	private static final String[] categories = new String[]{"Food", "Sleep", "Exercise", "Other"};
	private static final String[] foodcat = new String[]{"Breakfast", "Lunch", "Dinner", "Snack", "Water"};
	private static final String[] sleepcat = new String[]{"Wake", "Sleep"};
	private static final String[] exercisecat = new String[]{"10 mins", "20 mins", "30 mins", "60 mins", "90 mins"};
	private static final String[][] subcategories = new String[][]{foodcat, sleepcat, exercisecat};

}