package com.example.calculator;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Rajesh.Vemula
 * Tasks pending
 * List view for selection
 * landscape & portrait handle
 * Spinner for FD calc
 * 
 */
public class MainActivity extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
/*		FragmentManager fm=getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		
		transaction.add(R.id.Lilyt1,new BaseFragment(),"BaseFrgmnt");
//		transaction.addToBackStack("Base");
		transaction.commit();*/
		
	}
	
	


	

}
