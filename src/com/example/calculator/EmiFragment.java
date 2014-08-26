package com.example.calculator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmiFragment extends Fragment implements OnClickListener{



	Button b,resetBtn;
	Double emi,totalInt,totalAmt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.emicalc, container,false);
		b=(Button) v.findViewById(R.id.Fdcalculate);
		b.setOnClickListener(this);
		resetBtn=(Button) v.findViewById(R.id.Fdreset);
		resetBtn.setOnClickListener(this);
		return v;
	}

	public Double calcEmi(double p, double r, double n) {
		double R = (r / 12) / 100;
		emi = (p * R * (Math.pow((1 + R), n)) / ((Math.pow((1 + R), n)) - 1));
         totalInt = (double) Math.round((emi * n) - p);
         totalAmt = (double) Math.round((emi * n));
         emi=(double) Math.round(emi);
		return emi;
	}
	
	@Override
	public void onClick(View v) {

		// TODO Auto-generated method stub
		if (v.getId() == R.id.Fdcalculate) {
			String prinStr = ((EditText) getActivity().findViewById(R.id.fdEdit)).getText().toString();
			if (prinStr.length() < 1) {
				Toast.makeText(getActivity(), "Please provide values for Principal",
						Toast.LENGTH_SHORT).show();
				return;
			}
			String roiStr = ((EditText) getActivity().findViewById(R.id.roiFdEdit)).getText().toString();
			if (roiStr.length() < 1) {
				Toast.makeText(getActivity(),
						"Please provide values for Rate of interest",
						Toast.LENGTH_SHORT).show();
				return;
			}

			String durStr = ((EditText) getActivity().findViewById(R.id.durFdEdit)).getText().toString();
			if (durStr.length() < 1) {
				Toast.makeText(getActivity(), "Please provide values for duration",
						Toast.LENGTH_SHORT).show();
				return;
			}
			
			calcEmi(Double.parseDouble(prinStr), Double.parseDouble(roiStr), Double.parseDouble(durStr));
			((EditText) getActivity().findViewById(R.id.resRdEdit)).setText(emi.toString());
			((EditText) getActivity().findViewById(R.id.intFdEdit)).setText(totalInt.toString());
			((EditText) getActivity().findViewById(R.id.amtFdEdit)).setText(totalAmt.toString());

		}
		else if(v.getId()==R.id.Fdreset)
		{
			((EditText) getActivity().findViewById(R.id.fdEdit)).setText("");
			((EditText) getActivity().findViewById(R.id.roiFdEdit)).setText("");
			((EditText) getActivity().findViewById(R.id.durFdEdit)).setText("");
			((EditText) getActivity().findViewById(R.id.resRdEdit)).setText("");
			((EditText) getActivity().findViewById(R.id.intFdEdit)).setText("");
			((EditText) getActivity().findViewById(R.id.amtFdEdit)).setText("");
			
		}

	}



}
