package com.mienapps.datepickerfragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Raghunandan on 15-07-2016.
 */

	/*Time Picker*/
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private int position;

    public static DatePickerFragment newInstance(int pos)
    {
        DatePickerFragment f = new DatePickerFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("pos", pos);
        f.setArguments(args);

        return f;

    }
    private SetDate setDate;
    public interface SetDate
    {
         void dateSet(int pos,int year,int month, int day);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setDate =(SetDate)context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
    }

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
        setDate.dateSet(position,year,month,day);
    }
}