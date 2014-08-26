package com.example.calculator;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FDFragment extends Fragment implements OnClickListener{



	Button b,resetBtn;
	Double monInst,totalInt,maturAmt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.fdcalc, container,false);
		b=(Button) v.findViewById(R.id.Fdcalculate);
		b.setOnClickListener(this);
		resetBtn=(Button) v.findViewById(R.id.Fdreset);
		resetBtn.setOnClickListener(this);
		return v;
	}

	
	@Override
	public void onClick(View v) {

		// TODO Auto-generated method stub
		if (v.getId() == R.id.Fdcalculate) {
			String fdPrincipal = ((EditText) getActivity().findViewById(R.id.fdEdit)).getText().toString();
			if (fdPrincipal.length() < 1) {
				Toast.makeText(getActivity(), "Please provide values for FD Deposit Amount",
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
			
			double r=Double.parseDouble(roiStr)/100;
			double p=Double.parseDouble(fdPrincipal);
			double t=Double.parseDouble(durStr)/12;
			double n=4;
			maturAmt=p *  Math.pow(1+r/n,n*t);
			Log.d("raj_tag","matur amount is "+maturAmt);
			totalInt=maturAmt- p;
			((EditText) getActivity().findViewById(R.id.intFdEdit)).setText(totalInt.toString());
			((EditText) getActivity().findViewById(R.id.amtFdEdit)).setText(maturAmt.toString());

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
