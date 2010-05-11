package com.cketcham.daylogger;

import android.content.Context;

import com.cketcham.database.Row;

public class LogRow extends Row {
	public LogRow(Context context) {
		super(context);
	}

	public String main;
	public String sub;
	public String description;
	public Long time;
}