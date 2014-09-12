package com.example.calculator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class BaseFragment extends Fragment implements OnItemClickListener{

	String arr[]={"EmiCalc","FdCalc","RdCalc"};
	ArrayAdapter<String> arAdp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.basefg, container,false);
		arAdp=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr);
		ListView lv=(ListView)v.findViewById(R.id.calcSelector);
		lv.setAdapter(arAdp);
		lv.setOnItemClickListener(this);
		return v;
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
		transaction.replace(R.id.fragment1,fg,(String) tv.getText());
		transaction.addToBackStack((String) tv.getText());
		transaction.commit();
	}



}
