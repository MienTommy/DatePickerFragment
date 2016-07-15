package com.mienapps.datepickerfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayList<TextView> arrayOfViews = new ArrayList<TextView>();
		TextView date_Picker = (TextView) findViewById(R.id.date_picker);
		arrayOfViews.add(date_Picker);

		CustomAdapter adapter = new CustomAdapter(this, arrayOfViews);
		ListView listView = (ListView) findViewById(R.id.main_list_view);
		listView.setAdapter(adapter);
	}
}
