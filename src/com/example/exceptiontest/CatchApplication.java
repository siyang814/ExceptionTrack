package com.example.exceptiontest;

import android.app.Application;

public class CatchApplication extends Application
{
	
	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
		MyUtil.log("Application on Create !");
//		CatchHandler.getInstance().init(getApplicationContext());
		CrashHandler1.getInstance().init(getApplicationContext());
	}
	
}
