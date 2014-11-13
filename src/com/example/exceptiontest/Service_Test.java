package com.example.exceptiontest;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class Service_Test extends Service
{

	
	BroadcastReceiver receiver;
	
	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
		MyUtil.setHandler();
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setHandler();
		receiver = new BroadcastReceiver()
		{
			
			@Override
			public void onReceive(Context context, Intent intent)
			{
				// TODO Auto-generated method stub
//				MyUtil.ShowDialog("This is a Service Test!", Service_Test.this);
				MyUtil.DialogToActivity("11111111111111111", getApplicationContext());
			}
		};
		
		registerReceiver(receiver,  new IntentFilter("com.receiver.test"));
		
	}
	
	@Override
	public void onStart(Intent intent, int startId)
	{
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
//		sendBroadcast( new Intent("com.receiver.test"));
//		MyUtil.DialogToActivity("11111111111111111", getApplicationContext());
	}
	task ts;
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO Auto-generated method stub
//		if ( ts == null )
//		{
//			ts = new task();
//			new Thread( ts ).start();
//		}
//		ts.setB(true);
		setHandler();
		handler.sendMessage(new Message());
		return START_STICKY;
	}
	
	class task implements Runnable
	{
		public Object obj = new Object();
		boolean b = false;
		public boolean isB()
		{
			synchronized (obj)
			{
				return b;
			}
		}
		public void setB(boolean b)
		{
			synchronized (obj)
			{
				this.b = b;
			}
		}
		public void run()
		{
			
			while (true)
			{
				try
				{
					Thread.sleep(1000);
				} catch (Exception e)
				{
					// TODO: handle exception
				}
				
				synchronized (obj)
				{
					if ( isB() )
					{
						setB(!isB());
//						dialogshow();
						handler.sendMessage(null);
					}
					
				}
			}
		}
		
		
		
	}
	
	
	private void dialogshow ()
	{
		MyUtil.DialogToActivity("TESTTESTTESTTESTTEST!", getApplicationContext(), new com.example.exceptiontest.MyUtil.DialogOnBack(){

			@Override
			public void onOk()
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCancel()
			{
				// TODO Auto-generated method stub
				
			}});
	}
	
	
	Handler handler;
	
	private void setHandler ()
	{
		if ( handler != null ) return;
		handler = new Handler(){

			@Override
			public void handleMessage(Message msg)
			{
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				dialogshow();
			}
			
		};
	}
	
	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
