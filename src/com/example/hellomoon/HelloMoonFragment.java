package com.example.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	
	private AudioPlayer mPlayer;
	private Button mPlayButton;
	private Button mStopButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		/*
		 * This method is a special method in fragments that allows you to keep the information
		 * intact while the program goes through it's lifecycle methods
		 */
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanteState)
	{
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
		
		mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
		mPlayButton.setOnClickListener(new OnClickListener(){

			
			public void onClick(View arg0) {
				mPlayer.play(getActivity());
				
			}
			
		});
		
		mStopButton = (Button) v.findViewById(R.id.hellomoon_pauseButton);
		mStopButton.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0)
			{
				mPlayer.stop();
			}
		});
		
		return v;
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		mPlayer.stop();
	}
}
