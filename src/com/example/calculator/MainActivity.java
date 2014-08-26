package com.example.calculator;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author Rajesh.Vemula
 * Tasks pending
 * Spinner for FD calc
 * List view for selection
 * landscape & portrait handle
 * 
 */
public class MainActivity extends Activity implements OnClickListener {

	
	String arr[]={"EmiCalc","FdCalc","RdCalc"};
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> ar=new ArrayAdapter(this,1, arr);
		
		setContentView(R.layout.activity_main);
		b=(Button) findViewById(R.id.emiBtn);
		b.setOnClickListener(this);
		((Button)findViewById(R.id.FdBtn)).setOnClickListener(this);
		((Button)findViewById(R.id.RdBtn)).setOnClickListener(this);
	}


	
	@Override
	public void onClick(View v) {
		Log.d("raj_tag", "On click in view");
		// TODO Auto-generated method stub
		if (v.getId() == R.id.emiBtn) {
			Log.d("raj_tag", "button clicked properly");
			EmiFragment my=new EmiFragment();
			FragmentManager fm=getFragmentManager();
			FragmentTransaction transaction = fm.beginTransaction();
			transaction.replace(R.id.greenBox,my,"EmiCalc");
			transaction.addToBackStack("EmiCalc");
			transaction.commit();
		
		}
		else if (v.getId() == R.id.FdBtn) {
			Log.d("raj_tag", "button clicked properly");
			FDFragment my=new FDFragment();
			FragmentManager fm=getFragmentManager();
			FragmentTransaction transaction = fm.beginTransaction();
			transaction.replace(R.id.greenBox,my,"FDCalc");
			transaction.addToBackStack("FDCalc");
			transaction.commit();
		
		}
		else
		{
			Log.d("raj_tag", "button clicked properly");
			RDFragment my=new RDFragment();
			FragmentManager fm=getFragmentManager();
			FragmentTransaction transaction = fm.beginTransaction();
			transaction.replace(R.id.greenBox,my,"RDCalc");
			transaction.addToBackStack("RDCalc");
			transaction.commit();
		
		}
		
	}

}
