package com.cketcham.daylogger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SubCatChooser extends ListSelectActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectlist);

	}

	@Override
	protected String[] categories() {

		switch(getIntent().getIntExtra("position",-1)) {
			case 0: return new String[]{"Breakfast", "Lunch", "Dinner", "Snack", "Water"};
			case 1: return new String[]{"Wake", "Sleep"};
			case 2: return new String[]{"10 mins", "20 mins", "30 mins", "60 mins", "90 mins", "weight"};
		}

		return new String[]{};
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent data = new Intent(this, Description.class);
		data.putExtra("sub", categories()[position]);
		data.putExtra("main", this.getIntent().getStringExtra("main"));
		startActivity(data);
	}

}