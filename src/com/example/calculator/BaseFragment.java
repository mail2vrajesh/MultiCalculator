package com.example.calculator;

import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable.Orientation;
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
	Fragment emi=null,rd=null,fd=null;
	static Fragment fg=null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	/*	emi=new EmiFragment();
		rd=new RDFragment();
		fd=new FDFragment();*/
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
		String action=((String) tv.getText()).toUpperCase();
		if(action.contains("EMI"))
		{
			fg= ((emi==null)? (emi=new EmiFragment()) : emi);
			fg=emi;
		}
		else if(action.contains("RD"))
		{
			fg=((rd==null)? (rd=new RDFragment()) : rd);
			fg=rd;
		}
		else
		{
			fg= ((fd==null)? (fd=new FDFragment()) : fd);
			fg=fd;
		}
		
		FragmentManager fm=getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			transaction.replace(R.id.Lilyt2, fg, (String) tv.getText());
		//	transaction.addToBackStack((String) tv.getText());
			transaction.commit();
		} else {
			Intent intent=new Intent(getActivity(), AnotherActivity.class);
			intent.putExtra("action",tv.getText());
			startActivity(intent);
		}
	
	}



}
