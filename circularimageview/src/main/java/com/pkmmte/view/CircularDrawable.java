package com.pkmmte.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.InputStream;

public class CircularDrawable extends BitmapDrawable {
	// For logging purposes
	private static final String TAG = CircularDrawable.class.getSimpleName();

	// Bitmap reference
	private Paint paint;

	// Shader used for bitmap manipulation
	private BitmapShader shader;

	public CircularDrawable(Resources res, Drawable drawable) {
		this(res, ImageUtils.getBitmap(drawable));
	}

	public CircularDrawable(Resources res, Bitmap bitmap) {
		super(res, bitmap);
		init();
	}

	public CircularDrawable(Resources res, String filepath) {
		super(res, filepath);
		init();
	}

	public CircularDrawable(Resources res, InputStream is) {
		super(res, is);
		init();
	}

	private void init() {
		// TODO
		paint = new Paint();
		paint.setAntiAlias(true);
		updateShader();
	}

	@Override
	public void draw(Canvas canvas) {
		Rect bounds = getBounds();
		int radius = Math.min(bounds.width(), bounds.height()) / 2;
		canvas.drawCircle(bounds.right - radius, bounds.bottom - radius, radius, paint);
	}



	@Override
	public int getIntrinsicWidth() {
		return getBitmap() != null ? getBitmap().getWidth() : 0;
	}

	@Override
	public int getIntrinsicHeight() {
		return getBitmap() != null ? getBitmap().getHeight() : 0;
	}

	/**
	 * Re-initializes the shader texture used to fill in
	 * the Circle upon drawing.
	 */
	private void updateShader() {
		if (getBitmap() == null) {
			return;
		}

		shader = new BitmapShader(getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
		paint.setShader(shader);

		/*if (canvasSize != image.getWidth() || canvasSize != image.getHeight()) {
			Matrix matrix = new Matrix();
			float scale = (float) canvasSize / (float) image.getWidth();
			matrix.setScale(scale, scale);
			shader.setLocalMatrix(matrix);
		}*/
	}
}
