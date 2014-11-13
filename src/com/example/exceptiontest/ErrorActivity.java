package com.example.exceptiontest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ErrorActivity extends Activity
{
	
	private TextView tv_1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_error);
		tv_1 = (TextView) findViewById(R.id.tv_1);
		String ERROR = getIntent().getStringExtra("ERROR");
		if ( null == ERROR || "".equals(ERROR) )
		{
			tv_1.setText("Null");
		}
		else
		{
			tv_1.setText(ERROR);
		}
	}
	
}
