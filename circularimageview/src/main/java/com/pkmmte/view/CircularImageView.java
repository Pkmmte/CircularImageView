package com.pkmmte.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircularImageView extends ImageView {
	// For logging purposes
	private static final String TAG = CircularImageView.class.getSimpleName();

	public CircularImageView(Context context) {
		this(context, null, R.styleable.CircularImageViewStyle_circularImageViewDefault);
	}

	public CircularImageView(Context context, AttributeSet attrs) {
		this(context, attrs, R.styleable.CircularImageViewStyle_circularImageViewDefault);
	}

	public CircularImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs, defStyleAttr);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public CircularImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init(context, attrs, defStyleAttr);
	}

	private void init(Context context, AttributeSet attrs, int defStyle) {
		// TODO
		//setImageDrawable(new CircularDrawable(getDrawable()));
	}

	@Override
	public void setImageResource(int resId) {
		super.setImageResource(resId);
		setImageDrawable(getDrawable());
	}

	@Override
	public void setImageURI(Uri uri) {
		super.setImageURI(uri);
		setImageDrawable(getDrawable());
	}

	@Override
	public void setImageDrawable(Drawable drawable) {
		super.setImageDrawable(new CircularDrawable(getResources(), drawable));
	}

	@Override
	public void setImageBitmap(Bitmap bm) {
		super.setImageDrawable(new CircularDrawable(getResources(), bm));
	}
}
