# AndroidViewFlipperWithIndicator

This is a sample app that shows how to implement a view flipper with position indicators

How to use:

1.In the layout xml file, you only have to replace 'ViewFlipper' with 'com.byunghwa.demo.viewflipperwithindicator.ViewFlipperIndicator'.

2.In Java code, use 'com.byunghwa.demo.viewflipperwithindicator.ViewFlipperIndicator' instead of 'ViewFlipper'.
  You can customize the indicator's color by declaring a Paint object and then pass it to the ViewFlipper.
    
    Paint paint = new Paint();
    paint.setColor(getResources().getColor(android.R.color.white));
    flipper.setPaintCurrent(paint);

    paint = new Paint();
    paint.setColor(getResources().getColor(R.color.pink_a200));
    flipper.setPaintNormal(paint);
        
  You can also set its margin and radius by calling:
  
    flipper.setRadius(10);
    flipper.setMargin(10);
  

