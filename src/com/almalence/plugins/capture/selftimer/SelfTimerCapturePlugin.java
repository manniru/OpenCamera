/*
The contents of this file are subject to the Mozilla Public License
Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at
http://www.mozilla.org/MPL/

Software distributed under the License is distributed on an "AS IS"
basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations
under the License.

The Original Code is collection of files collectively known as Open Camera.

The Initial Developer of the Original Code is Almalence Inc.
Portions created by Initial Developer are Copyright (C) 2013 
by Almalence Inc. All Rights Reserved.
*/

package com.almalence.plugins.capture.selftimer;


/***
Implements self timer capture plugin. Starts capture when shutter pressed and predefined interval elapsed.
***/

public class SelfTimerCapturePlugin {//extends PluginCapture {
//
//	public static final int MAX_FRAMES = 1;
//
//	private boolean takingAlready=false;
//	
//    //defaul val. value should come from config
//    public int delayInterval = 4;    
//    private int imageAmount = 1;
//    
//    public int imagesTaken=0;
//    
//    private boolean isBlinkEnable = false;
//    private boolean isSoundEnable = false;
//    
//    private SoundPlayer countdownPlayer = null;
//    private SoundPlayer finalcountdownPlayer = null;
//    
//    private RelativeLayout countdownLayout = null;
//    private TextView countdownView = null;
//    
//    private Animation countdownAnimation = null;
//
//    private CountDownTimer timer=null;
//    
//    public String flashModeBackUp = "";
//    
//	public SelfTimerCapturePlugin()
//	{
//		super("com.almalence.plugins.selftimercapture",
//			  R.xml.preferences_capture_selftimer,
//			  0,
//			  MainScreen.thiz.getResources().getString(R.string.Pref_SelfTimer_Preference_Title),
//			  MainScreen.thiz.getResources().getString(R.string.Pref_SelfTimer_Preference_Summary),
//			  R.drawable.gui_almalence_mode_selftimer,
//			  "Self timer");
//		refreshPreferences();
//	}
//	
//	private void refreshPreferences()
//	{
//		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainScreen.mainContext);
//        int val = Integer.parseInt(prefs.getString("delayInterval", "3"));
//        delayInterval = val*1000 + 990;
//        
//        switch (val)
//        {
//        case 3:
//        	quickControlIconID = R.drawable.gui_almalence_mode_selftimer3;
//        	break;
//        case 5:
//        	quickControlIconID = R.drawable.gui_almalence_mode_selftimer5;
//        	break;
//        case 10:
//        	quickControlIconID = R.drawable.gui_almalence_mode_selftimer10;
//        	break;
//        }
//        
//        imageAmount = Integer.parseInt(prefs.getString("selfTimerImagesAmount", "2"));
//        
//        isBlinkEnable = prefs.getBoolean("selftimerBlinking", true);
//        isSoundEnable = prefs.getBoolean("selftimerSound", true);
//	}
//	
//	@Override
//	public void onResume()
//	{
//		initializeSoundPlayers(MainScreen.thiz.getResources().openRawResourceFd(R.raw.plugin_capture_selftimer_countdown),
//				  			   MainScreen.thiz.getResources().openRawResourceFd(R.raw.plugin_capture_selftimer_finalcountdown));
//		
//		imagesTaken=0;
//		refreshPreferences();
//	}
//	
//	@Override
//	public void onPause()
//	{
//		releaseSoundPlayers();
//		
//		countdownView.clearAnimation();
//        countdownLayout.setVisibility(View.GONE);
//        
//        countdownHandler.removeCallbacks(FlashOff);
//	    finalcountdownHandler.removeCallbacks(FlashBlink);
//	    
//	    takingAlready = false;
//   	
//		//stops timer befor exit to be sure it canceled
//		if (timer!=null)
//		{
//			timer.cancel();
//			timer=null;
//		}
//		
//		Message msg = new Message();
//		msg.arg1 = PluginManager.MSG_CONTROL_UNLOCKED;
//		msg.what = PluginManager.MSG_BROADCAST;
//		MainScreen.H.sendMessage(msg);
//		
//		MainScreen.guiManager.lockControls = false;
//	}
//	
//	@Override
//	public void onCreate()
//	{
//		countdownAnimation = AnimationUtils.loadAnimation(MainScreen.thiz, R.anim.plugin_capture_selftimer_countdown);
//		countdownAnimation.setFillAfter(true);
//		
//		LayoutInflater inflator = MainScreen.thiz.getLayoutInflater();		
//		countdownLayout = (RelativeLayout)inflator.inflate(R.layout.plugin_capture_selftimer_layout, null, false);
//		countdownView = (TextView)countdownLayout.findViewById(R.id.countdown_text);
//	}
//	
//	@Override
//	public void onGUICreate()
//	{
//		List<View> specialView = new ArrayList<View>();
//		RelativeLayout specialLayout = (RelativeLayout)MainScreen.thiz.findViewById(R.id.specialPluginsLayout);
//		for(int i = 0; i < specialLayout.getChildCount(); i++)
//			specialView.add(specialLayout.getChildAt(i));
//
//		for(int j = 0; j < specialView.size(); j++)
//		{
//			View view = specialView.get(j);
//			int view_id = view.getId();
//			int layout_id = this.countdownLayout.getId();
//			if(view_id == layout_id)
//			{
//				if(view.getParent() != null)
//					((ViewGroup)view.getParent()).removeView(view);
//				
//				specialLayout.removeView(view);
//			}
//		}
//		
//		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);		
//		
//		params.addRule(RelativeLayout.CENTER_IN_PARENT);		
//		
//		((RelativeLayout)MainScreen.thiz.findViewById(R.id.specialPluginsLayout)).addView(this.countdownLayout, params);
//		
//		this.countdownLayout.setLayoutParams(params);
//		this.countdownLayout.requestLayout();
//		this.countdownLayout.setVisibility(View.INVISIBLE);
//	}
//	
//	@Override
//	public void onQuickControlClick()
//	{
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainScreen.mainContext);
//        int val = Integer.parseInt(prefs.getString("delayInterval", "5"));
//        int selected = 0;
//        switch (val)
//        {
//        case 3:
//        	selected=0;
//        	break;
//        case 5:
//        	selected=1;
//        	break;
//        case 10:
//        	selected=2;
//        	break;
//        }
//        selected= (selected+1)%3;
//        
//    	Editor editor = prefs.edit();
//    	switch (selected)
//        {
//        case 0:
//        	quickControlIconID = R.drawable.gui_almalence_mode_selftimer3;
//        	editor.putString("delayInterval", "3");
//        	break;
//        case 1:
//        	quickControlIconID = R.drawable.gui_almalence_mode_selftimer5;
//        	editor.putString("delayInterval", "5");
//        	break;
//        case 2:
//        	quickControlIconID = R.drawable.gui_almalence_mode_selftimer10;
//        	editor.putString("delayInterval", "10");
//        	break;
//        }
//    	editor.commit();
//	}
//
//	@Override
//	public void OnShutterClick()
//	{
//		flashModeBackUp = "";
////		Camera cam = MainScreen.thiz.getCamera();
////		if (cam != null)
////		{
////			Camera.Parameters params = MainScreen.thiz.getCameraParameters();
////			if (params != null)
////				flashModeBackUp = params.getFlashMode();
////		}
//		Camera.Parameters params = MainScreen.thiz.getCameraParameters();
//		if (params != null)
//			flashModeBackUp = params.getFlashMode();
//		if (takingAlready == false)
//			takePicture();
//	}
//	
//	final Handler countdownHandler = new Handler();
//	final Handler finalcountdownHandler = new Handler();
//	public void takePicture()
//	{
//		MainScreen.thiz.MuteShutter(false);
//		
//		refreshPreferences();
//		takingAlready = true;
//		
//		Message msg = new Message();
//		msg.arg1 = PluginManager.MSG_CONTROL_LOCKED;
//		msg.what = PluginManager.MSG_BROADCAST;
//		MainScreen.H.sendMessage(msg);
//			
//		countdownHandler.removeCallbacks(FlashOff);	 
//		finalcountdownHandler.removeCallbacks(FlashBlink);		
//		
//		timer = new CountDownTimer(imagesTaken!=0 ? 1000 : delayInterval, imagesTaken!=0 ? 100: 1000) 
//		{			 
//			 boolean isFirstTick = true;
//		     public void onTick(long millisUntilFinished) {
//		    	 if(!(imagesTaken != 0 && !isFirstTick))
//		    		 TickEverySecond((millisUntilFinished/1000 <= 1 || imagesTaken != 0)? true : false);
//		         
//		         if(imagesTaken == 0)
//		         {
//		        	 countdownView.setRotation(90 - MainScreen.orientationMain);
//			         countdownView.setText(String.valueOf(millisUntilFinished/1000));
//			         countdownView.clearAnimation();
//			         countdownLayout.setVisibility(View.VISIBLE);
//			         countdownView.startAnimation(countdownAnimation);
//		         }
//		         Camera camera = MainScreen.thiz.getCamera();
//		     	 if (null==camera)
//		     		return;
//		         
//		         if(isBlinkEnable)
//		         {
//			         if(millisUntilFinished/1000 > 1 || (imagesTaken != 0 && isFirstTick))
//			         {
//			        	try 
//			        	{
//			        		 Camera.Parameters p = MainScreen.thiz.getCameraParameters();
//				        	 p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//				        	 MainScreen.thiz.setCameraParameters(p);
//						} catch (Exception e) {
//							e.printStackTrace();
//							Log.e("Self-timer", "Torch exception: " + e.getMessage());
//						}
//			        	countdownHandler.postDelayed(FlashOff, 100);
//			         }
//			         else if(!(imagesTaken != 0 && !isFirstTick))
//			         {
//			        	finalcountdownHandler.postDelayed(FlashBlink, 100);
//			         }
//		         }
//		         
//		         isFirstTick = false;
//		     }
//
//		     public void onFinish() {
//		    	 
//		    	 countdownView.clearAnimation();
//		         countdownLayout.setVisibility(View.GONE);
//		         
//		         countdownHandler.removeCallbacks(FlashOff);	 
//		 	     finalcountdownHandler.removeCallbacks(FlashBlink);
//		         
//		 	    Camera camera = MainScreen.thiz.getCamera();
//		    	if (camera != null)		// paranoia
//				{
//		    		if(MainScreen.thiz.getSupportedFlashModes() != null)
//		    			MainScreen.thiz.setCameraFlashMode(flashModeBackUp);
//
//		    		new CountDownTimer(300, 300) {
//						public void onTick(long millisUntilFinished) {
//						}
//
//						public void onFinish() 
//						{
//							Message msg = new Message();
//							msg.arg1 = PluginManager.MSG_TAKE_PICTURE;
//							msg.what = PluginManager.MSG_BROADCAST;
//							MainScreen.H.sendMessage(msg);
//						}
//					}.start();
//				}
//		    	timer=null;
//		     }
//		  };
//		  timer.start();
//	}
//	
//	public void TickEverySecond(boolean isLastSecond)
//	{
//		if (MainScreen.ShutterPreference)
//			return;
//		if (isSoundEnable)
//		{
//			if(isLastSecond)
//			{
//				if (finalcountdownPlayer != null)
//					finalcountdownPlayer.play();
//			}
//			else
//			{
//				if (countdownPlayer!=null)
//					countdownPlayer.play();
//			}
//		}
// 	}
//	
//	public void initializeSoundPlayers(AssetFileDescriptor fd_countdown, AssetFileDescriptor fd_finalcountdown) {
//		countdownPlayer = new SoundPlayer(MainScreen.thiz.mainContext, fd_countdown);
//		finalcountdownPlayer = new SoundPlayer(MainScreen.thiz.mainContext, fd_finalcountdown);
//    }
//
//    public void releaseSoundPlayers() {
//        if (countdownPlayer != null) {
//        	countdownPlayer.release();
//        	countdownPlayer = null;
//        }
//        
//        if (finalcountdownPlayer != null) {
//        	finalcountdownPlayer.release();
//        	finalcountdownPlayer = null;
//        }
//    }
//    
//    private Runnable FlashOff = new Runnable() {
//        public void run() {
//        	Camera camera = MainScreen.thiz.getCamera();
//        	if (null==camera)
//        		return;
//        	Camera.Parameters p = MainScreen.thiz.getCameraParameters();
//       	 	p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
//       	 	MainScreen.thiz.setCameraParameters(p); 
//        }
//    };
//    
//    private Runnable FlashBlink = new Runnable() {
//    	boolean isFlashON = false;
//        public void run() {
//        	Camera camera = MainScreen.thiz.getCamera();
//        	if (null==camera)
//        		return;
//        	
//        	try {
//	        	Camera.Parameters p = MainScreen.thiz.getCameraParameters();
//	        	if(isFlashON)
//	        	{
//	       	 		p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
//	       	 		isFlashON = false;
//	        	}
//	        	else
//	        	{
//	        		p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//	       	 		isFlashON = true;
//	        	}
//	        	MainScreen.thiz.setCameraParameters(p);
//        	} catch (Exception e) {
//				e.printStackTrace();
//				Log.e("Self-timer", "finalcountdownHandler exception: " + e.getMessage());
//			}
//        	finalcountdownHandler.postDelayed(this, 50);
//        }
//    };
//	
//    @Override
//	public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
//	{        
//		imagesTaken++;
//		int frame_len = paramArrayOfByte.length;
//		int frame = SwapHeap.SwapToHeap(paramArrayOfByte);
//    	
//    	if (frame == 0)
//    	{
//    		//NotEnoughMemory();
//    	}
//    	String frameName = "frame" + imagesTaken;
//    	String frameLengthName = "framelen" + imagesTaken;
//    	
//    	PluginManager.getInstance().addToSharedMem(frameName+String.valueOf(PluginManager.getInstance().getSessionID()), String.valueOf(frame));
//    	PluginManager.getInstance().addToSharedMem(frameLengthName+String.valueOf(PluginManager.getInstance().getSessionID()), String.valueOf(frame_len));
//    	PluginManager.getInstance().addToSharedMem("frameorientation" + imagesTaken + String.valueOf(PluginManager.getInstance().getSessionID()), String.valueOf(MainScreen.guiManager.getDisplayOrientation()));
//    	PluginManager.getInstance().addToSharedMem("framemirrored" + imagesTaken + String.valueOf(PluginManager.getInstance().getSessionID()), String.valueOf(MainScreen.getCameraMirrored()));
//    	
//    	if(imagesTaken == 1)
//    		PluginManager.getInstance().addToSharedMem_ExifTagsFromJPEG(paramArrayOfByte);
//    	
//		try
//		{
//			paramCamera.startPreview();
//		}
//		catch (RuntimeException e)
//		{
//			Log.i("CameraTest", "StartPreview fail");
//		}
//		if (imagesTaken < imageAmount)
//			MainScreen.H.sendEmptyMessage(PluginManager.MSG_TAKE_PICTURE);
//		else
//		{
//			PluginManager.getInstance().addToSharedMem("amountofcapturedframes"+String.valueOf(PluginManager.getInstance().getSessionID()), String.valueOf(imagesTaken));
//			MainScreen.H.sendEmptyMessage(PluginManager.MSG_CAPTURE_FINISHED);
//			imagesTaken=0;
//		}
//		takingAlready = false;
//		
//		Message msg = new Message();
//		msg.arg1 = PluginManager.MSG_CONTROL_UNLOCKED;
//		msg.what = PluginManager.MSG_BROADCAST;
//		MainScreen.H.sendMessage(msg);
//	}
//
//	@Override
//	public void onAutoFocus(boolean paramBoolean, Camera paramCamera){}
//
//	@Override
//	public void onPreviewFrame(byte[] data, Camera paramCamera){}
//	
//	public boolean onBroadcast(int arg1, int arg2)
//	{
//		if (arg1 == PluginManager.MSG_TAKE_PICTURE)
//		{
//			Camera camera = MainScreen.thiz.getCamera();
//    		if (camera != null)
//    		{
//	    		MainScreen.guiManager.showCaptureIndication();
//	    		MainScreen.thiz.PlayShutter();
//	    		try {
//        			camera.takePicture(null, null, null, MainScreen.thiz);
//				}catch (Exception e) {
//					e.printStackTrace();
//					Log.e("MainScreen takePicture() failed", "takePicture: " + e.getMessage());
//					takingAlready = false;
//					Message msg = new Message();
//					msg.arg1 = PluginManager.MSG_CONTROL_UNLOCKED;
//					msg.what = PluginManager.MSG_BROADCAST;
//					MainScreen.H.sendMessage(msg);
//					
//					MainScreen.H.sendEmptyMessage(PluginManager.MSG_CAPTURE_FINISHED);
//				}
//    		}
//    		return true;
//    	}
//		return false;
//	}
}
