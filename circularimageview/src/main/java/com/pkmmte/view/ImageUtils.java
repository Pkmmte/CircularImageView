package com.pkmmte.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Utility class for image-related stuff.
 */
public class ImageUtils {
	// For logging purposes
	private static final String TAG = ImageUtils.class.getSimpleName();

	/**
	 * Convert a drawable object into a Bitmap.
	 * @param drawable Drawable to extract a Bitmap from.
	 * @return A Bitmap created from the drawable parameter.
	 */
	public static Bitmap getBitmap(Drawable drawable) {
		if (drawable == null)   // Don't do anything without a proper drawable
			return null;
		else if (drawable instanceof BitmapDrawable) {  // Use the getBitmap() method instead if BitmapDrawable
			if (BuildConfig.DEBUG) {
				Log.i(TAG, "Bitmap drawable!");
			}
			return ((BitmapDrawable) drawable).getBitmap();
		}

		int intrinsicWidth = drawable.getIntrinsicWidth();
		int intrinsicHeight = drawable.getIntrinsicHeight();

		if (!(intrinsicWidth > 0 && intrinsicHeight > 0))
			return null;

		try {
			// Create Bitmap object out of the drawable
			Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(bitmap);
			drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
			drawable.draw(canvas);
			return bitmap;
		} catch (OutOfMemoryError e) {
			// Simply return null of failed bitmap creations
			Log.e(TAG, "Encountered OutOfMemoryError while generating bitmap!");
			return null;
		}
	}
}
