package com.mienapps.datepickerfragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Tommy on 7/15/2016.
 */
public class CustomAdapter extends ArrayAdapter<ModelClass>
{
	Activity mContext;

	private List<ModelClass> items;
	public CustomAdapter(Activity context, List<ModelClass> views)
	{
		super(context, 0, views);
		mContext = context;
		this.items =views;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public ModelClass getItem(int position) {
		return items.get(position);
	}

	/*Get view from adapter*/
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View itemView = convertView;
		if (convertView == null)
		{
			itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
		}

		TextView datePickerView = (TextView) itemView.findViewById(R.id.date_picker);

		datePickerView.setTag(R.string.TAG,position);
		datePickerView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				DialogFragment newFragment = DatePickerFragment.newInstance((int)view.getTag(R.string.TAG));
				newFragment.show(mContext.getFragmentManager(), "datePicker");
			}
		});
		datePickerView.setText(String.valueOf(getItem(position).getYear())+
				String.valueOf(getItem(position).getMonth())+
		String.valueOf(getItem(position).getDay()));
		return itemView;
	}


}
