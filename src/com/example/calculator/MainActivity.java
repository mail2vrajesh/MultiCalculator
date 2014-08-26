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
public class MainActivity extends Activity implements OnItemClickListener {

	
	String arr[]={"EmiCalc","FdCalc","RdCalc"};
	ArrayAdapter<String> arAdp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		arAdp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
				
		ListView lv=(ListView)findViewById(R.id.calcSelector);
		lv.setAdapter(arAdp);
		lv.setOnItemClickListener(this);
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		TextView tv=(TextView) view;
		Fragment fg;
		if(((String) tv.getText()).contains("EmiCalc"))
			fg=new EmiFragment();
		else if(((String) tv.getText()).contains("Fd"))
			fg=new FDFragment();
		else
			fg=new RDFragment();
		
		FragmentManager fm=getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.greenBox,fg,(String) tv.getText());
		transaction.addToBackStack((String) tv.getText());
		transaction.commit();
	}

}
