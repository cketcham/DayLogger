package com.cketcham.daylogger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainCatChooser extends ListSelectActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectlist);

	}

	@Override
	protected String[] categories() {
		return new String[]{"Food", "Sleep", "Exercise", "Other"};
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, SubCatChooser.class);
		intent.putExtra("main", categories[position]);
		intent.putExtra("position", position);
		startActivity(intent);
	}

}