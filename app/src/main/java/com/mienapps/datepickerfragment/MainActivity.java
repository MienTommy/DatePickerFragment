package com.mienapps.datepickerfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.SetDate
{

	private ArrayList<ModelClass> arrayOfViews;

	private CustomAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		arrayOfViews = new ArrayList<ModelClass>();

		for(int i=0;i<10;i++)
		{
			arrayOfViews.add(new ModelClass());
		}
		TextView date_Picker = (TextView) findViewById(R.id.date_picker);
		//arrayOfViews.add(date_Picker);

		adapter = new CustomAdapter(this, arrayOfViews);
		ListView listView = (ListView) findViewById(R.id.main_list_view);
		listView.setAdapter(adapter);
	}


	@Override
	public void dateSet(int pos,int year, int month, int day) {

		ModelClass modelClass = arrayOfViews.get(pos);
		modelClass.setYear(year);
		Toast.makeText(this,""+month,Toast.LENGTH_SHORT).show();
		modelClass.setMonth(month);
		modelClass.setDay(day);
		adapter.notifyDataSetChanged();
	}
}
