CircularImageView
=================

Custom view for circular images in Android while maintaining the best draw performance


![Imgur](http://i.imgur.com/Q33e2Zb.gif)

Usage
--------
To make a circular ImageView, add this CircularImageView library to your project and add CircularImageView in your layout XML.

###XML
```xml
    <com.pkmmte.circularimageview.CircularImageView
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:src="@drawable/image"
        app:border_color="#EEEEEE"
        app:border_width="4dp"
        app:shadow="true" />
```

You may use the following properties in your XML to customize your CircularImageView.

#####Properties:

* `app:border`       (boolean)             -> default false
* `app:border_color` (color)               -> default WHITE
* `app:border_width` (dimension)           -> default 2dp
* `app:selector`       (boolean)           -> default false
* `app:selector_color` (color)             -> default TRANSPARENT
* `app:selector_stroke_color` (color)      -> default BLUE
* `app:selector_stroke_width` (dimension)  -> default 2dp
* `app:shadow`       (boolean)             -> default false

###JAVA

```java
    CircularImageView circularImageView = (CircularImageView)findViewById(R.id.yourCircularImageView);
    circularImageView.setBorderColor(getResources().getColor(R.color.GrayLight));
    circularImageView.setBorderWidth(10);
    circularImageView.setSelectorColor(getResources().getColor(R.color.BlueLightTransparent));
    circularImageView.setSelectorStrokeColor(getResources().getColor(R.color.BlueDark));
    circularImageView.setSelectorStrokeWidth(10);
    circularImageView.addShadow();
```

License
--------

    CircularImageView by Pkmmte Xeleon is licensed under the Creative Commons Attribution 4.0 International License.
    
    To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/

Based on a work at https://github.com/lopspower/CircularImageView.
