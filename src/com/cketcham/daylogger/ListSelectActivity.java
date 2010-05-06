package com.cketcham.daylogger;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListSelectActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectlist);

		final String[] categories = getIntent().getExtras().getStringArray("categories");

		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, categories));

		final ListView listView = getListView();

		listView.setItemsCanFocus(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		Button next = (Button) findViewById(R.id.next);
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("result", categories[listView.getCheckedItemPosition()]);
				setResult(Activity.RESULT_OK, data);
				finish();
			}

		});

	}
}