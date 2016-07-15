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
public class CustomAdapter extends ArrayAdapter<TextView>
{
	Activity mContext;
	public CustomAdapter(Activity context, List<TextView> views)
	{
		super(context, 0, views);
		mContext = context;
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

		datePickerView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				DialogFragment newFragment = new DatePickerFragment();
				newFragment.show(mContext.getFragmentManager(), "datePicker");
			}
		});

		return itemView;
	}

	/*Time Picker*/
	public static class DatePickerFragment extends DialogFragment
			implements DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);


			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {
			//TODO: set itemView to the date that is picked. However I can't access it from here.
		}
	}
}
