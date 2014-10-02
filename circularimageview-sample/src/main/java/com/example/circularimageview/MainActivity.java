package com.example.circularimageview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.bitmap.Transform;
import com.pkmmte.view.CircularImageView;
import com.squareup.picasso.Picasso;

public class MainActivity extends Activity
{
	private int[] images = {
								R.drawable.default_avatar,
								R.drawable.default_avatar,
								R.drawable.default_avatar,
								R.drawable.default_avatar,
								R.drawable.default_avatar,
								R.drawable.default_avatar,
								R.drawable.default_avatar
							};
	
	private ListView mList;
	private SimpleAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		initList();
	}
	
	private void initViews()
	{
		mList = (ListView) findViewById(R.id.mList);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	private void initList()
	{
		// Add header
		View headerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.header, mList, false);
		mList.addHeaderView(headerView, null, false);
		
		// Add footer
		View footerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer, mList, false);
		mList.addFooterView(footerView, null, false);
		
		// DOGE!!!
		final CircularImageView imgDoge = (CircularImageView) headerView.findViewById(R.id.imgDoge);
		final TextView txtWow = (TextView) headerView.findViewById(R.id.txtWow);
		final TextView txtClick = (TextView) headerView.findViewById(R.id.txtClick);
		
		imgDoge.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(imgDoge.isSelected()) {
					txtWow.setVisibility(View.VISIBLE);
					txtClick.setVisibility(View.VISIBLE);
				}
				else {
					txtWow.setVisibility(View.INVISIBLE);
					txtClick.setVisibility(View.INVISIBLE);
				}
				
				return false;
			}
		});
		
		// Load web image with a round transformation
		final CircularImageView imgNetwork = (CircularImageView) footerView.findViewById(R.id.imgNetwork);
		loadWebImage(imgNetwork);

		// Set the most basic adapter
		mAdapter = new SimpleAdapter(this, images);
		mList.setAdapter(mAdapter);
	}

	private void loadWebImage(final CircularImageView imgNetwork) {
		final String URL = "http://i.imgur.com/LrwApXg.png";

		// Using Picasso...
		//Picasso.with(this).load(URL).placeholder(R.drawable.default_avatar).error(R.drawable.grumpy_cat).transform(new PicassoRoundTransform()).into(imgNetwork);

		// Using Glide...
		//Glide.with(this).load(URL).placeholder(R.drawable.default_avatar).error(R.drawable.grumpy_cat).into(imgNetwork);

		// Using ION...
		Ion.with(this).load(URL).asBitmap().setCallback(new FutureCallback<Bitmap>() {
			@Override
			public void onCompleted(Exception e, Bitmap result) {
				if(e == null) {
					// Success
					imgNetwork.setImageBitmap(result);
				}
				else {
					// Error
					imgNetwork.setImageResource(R.drawable.grumpy_cat);
				}
			}
		});
	}
}