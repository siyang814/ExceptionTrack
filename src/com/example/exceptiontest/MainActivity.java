package com.example.exceptiontest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button1, button2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		MyUtil.log("Activity on Create !");
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener( new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
//				init();
//				button1 = (Button) findViewById(R.id.tv_1);
				
				
//				Intent intent1 = new Intent();
//				intent1.setAction(Intent.ACTION_MAIN);
//				intent1.addCategory(Intent.CATEGORY_HOME);           
//				startActivity(intent1);
//				try
//				{
//					Thread.sleep(1000);
//				} catch (Exception e)
//				{
//					// TODO: handle exception
//				}
				
				Intent intent = new Intent(MainActivity.this, Service_Test.class);
				startService(intent);
//				MainActivity.this.finish();
				
				
				
			}
		});
        button2.setOnClickListener( new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
//				init();
				starActive();
			}
		});
    }

    private void init ()
    {
//    	new Thread(new Runnable() {
//            
//            @Override
//            public void run() {
//                     throw new NullPointerException("please catch me! sub thread");
//            }
//    }).start();
    	throw new NullPointerException("please catch me! sub thread==========");

    }
    String FLAG_ERROR = "com.myaction";
    private void starActive ()
    {
//    	Intent intent =new Intent(FLAG_ERROR);
////    	Intent intent =new Intent();
////    	intent.setClass(this, ErrorActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra("ERROR", "11111111111111");
//        startActivity(intent);
    	
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("提示");
		dialog.setMessage("sdfsdffdsfds");
		dialog.setPositiveButton("确定",  new DialogInterface.OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		
		dialog.setNegativeButton("we", null);
		dialog.show();
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
