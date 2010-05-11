package com.cketcham.daylogger;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListSelectActivity extends ListActivity {

	protected String[] categories;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		categories = categories();

		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories));

		final ListView listView = getListView();

		listView.setItemsCanFocus(false);
	}

	protected String[] categories() {
		return new String[]{};
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		finish();
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			setResult(Activity.RESULT_OK);
			finish();
		}
	}

}