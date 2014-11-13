package com.example.exceptiontest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

public class MyUtil
{
	public static void log ( String s )
	{
		Log.w("MYUTIL", s);
	}
	
	public static void ShowDialog ( String s, Context c )
	{
		AlertDialog.Builder dialog = new AlertDialog.Builder(c);
		dialog.setTitle("提示");
		dialog.setMessage(s);
		dialog.setPositiveButton("确定",  new OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		
//		((Dialog) dialog).getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);  
		
//		dialog.show();
		
		AlertDialog ad = dialog.create();
		ad.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		ad.setCanceledOnTouchOutside(false);
		ad.show();
//		Dialog dl = new Dialog(c);
//		
//		dl.setTitle("提示");
//		
//		TextView tv = new TextView(c);
//		tv.setText("　　您有新短信息!");
//		dl.setContentView(tv);
//		dl.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//		dl.show();
		
//		Intent intent = new Intent(c, DialogActivity.class);
//		
//		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		
//		c.startActivity( intent );
	}
	
	public static boolean isShow = false; 
	static AlertDialog.Builder dialog;
	/**后台推送, 弹出DIALOG (呼叫, 报警)*/
	synchronized public static void DialogToActivity ( String s, final Context c )
	{
		if ( isShow == true )
		{
			return;
		}
		isShow = true;
		dialog = new AlertDialog.Builder (c);
		dialog.setTitle("海尔 U-home:");
		dialog.setMessage(s);
		dialog.setPositiveButton("前往", new OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				// TODO Auto-generated method stub
				isShow = false;
			}
		});
		dialog.setNegativeButton("取消", new OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				// TODO Auto-generated method stub
				isShow = false;
			}
		});
		
		AlertDialog ad = dialog.create();
		ad.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		ad.setCanceledOnTouchOutside(false);
		ad.show();
		
//		Intent intent = new Intent(c, DialogActivity.class);
//		
//		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		
//		intent.putExtra("MESSAGE", s);
//		
//		c.startActivity( intent );
		
	}
	
	private static Handler handler;
	private static Context c;
	private static DialogOnBack dob;
	
	public static void setHandler ()
	{
		if ( handler != null ) return;
		handler = new Handler(){

			@Override
			public void handleMessage(Message msg)
			{
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				String s = msg.getData().getString("MSG");
				
				dialog = new AlertDialog.Builder(c);
				dialog.setTitle("海尔 U-home:");
				dialog.setMessage(s);
				dialog.setPositiveButton("前往", new OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						isShow = false;
						dob.onOk();
					}
				});
				dialog.setNegativeButton("取消", new OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						isShow = false;
						dob.onCancel();
					}
				});
				dialog.setOnCancelListener( new OnCancelListener()
				{
					
					@Override
					public void onCancel(DialogInterface dialog)
					{
						// TODO Auto-generated method stub
						isShow = false;
					}
				});
				AlertDialog ad = dialog.create();
				ad.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
				ad.setCanceledOnTouchOutside(false);
				ad.show();
				
			}
			
		};
	}
	
	/**后台推送, 弹出DIALOG (呼叫, 报警)*/
	synchronized public static void DialogToActivity ( String s, Context mContext, DialogOnBack dob1 )
	{
		if ( isShow == true )
		{
			return;
		}
		isShow = true;
		c = mContext;
		dob = dob1;
		Message msg = new Message();
		Bundle b = new Bundle();
		b.putString("MSG", s);
		msg.setData(b);
		handler.dispatchMessage(msg);
		
		
//		Intent intent = new Intent(c, DialogActivity.class);
//		
//		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		
//		intent.putExtra("MESSAGE", s);
//		
//		c.startActivity( intent );
	}
	
	public interface DialogOnBack
	{
		public void onOk ();
		public void onCancel ();
	}
}
