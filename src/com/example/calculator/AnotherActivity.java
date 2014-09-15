package com.example.calculator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AnotherActivity extends Activity {
	//Fragment emi=null,rd=null,fd=null;
	//Fragment fg=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_another);
		
		Intent intent=getIntent();
		String action=intent.getStringExtra("action");
		
			
		FragmentManager fm=getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		
		transaction.replace(R.id.RelLyt1,BaseFragment.fg);
		transaction.commit();
	}

	
}
