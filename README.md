CircularImageView
=================

Custom view for circular images in Android while maintaining the best draw performance


![Imgur](http://i.imgur.com/Q33e2Zb.gif)

Usage
--------
To make a circular ImageView, add this CircularImageView library to your project and add CircularImageView in your layout XML. 
You can also grab it via Gradle:

```groovy
compile 'com.pkmmte.view:circularimageview:1.1'
```

or Maven:

```xml
<dependency>
		<groupId>com.pkmmte.view</groupId>
		<artifactId>circularimageview</artifactId>
		<version>1.1</version>
</dependency>
```

###XML
```xml
    <com.pkmmte.view.CircularImageView
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

Developed By
--------

Pkmmte Xeleon - www.pkmmte.com

<a href="https://plus.google.com/102226057091361048952">
  <img alt="Follow me on Google+"
       src="http://data.pkmmte.com/temp/social_google_plus_logo.png" />
</a>
<a href="https://www.linkedin.com/pub/pkmmte-xeleon/7a/409/b4b/">
  <img alt="Follow me on LinkedIn"
       src="http://data.pkmmte.com/temp/social_linkedin_logo.png" />
</a>

License
--------

    The MIT License (MIT)
    
    Copyright (c) 2014 Pkmmte Xeleon
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.

Based on a work at https://github.com/lopspower/CircularImageView.
