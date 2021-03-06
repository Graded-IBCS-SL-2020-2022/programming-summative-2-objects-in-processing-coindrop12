/* YOU SHOULD COMPLETE AND UNDERSTAND THE Ball.java PART OF THIS PROJECT FIRST */
/* DON'T FORGET TO RENAME THIS FILE TO Bubble.java WHEN YOU ARE READY TO TEST IT */

class Bubble {

    public Sketch s;
    public float diameter;
    public float x;
    public float y;
    public int col; 
    public int borderColor; 
    public float speedY;
    public float speedX;

    /**
     * SUMMATIVE REQUIRED Add two constructors for the Bubble class, one that is
     * mostly default and one that allows custom values for whichever you want to be
     * able to change. Remember that bubbles should RISE - when setting default values,
     * take that into account!
     * 
     * You can use `s.color(255, 150)` to create a transluscent 
     * white color if you wish
     * 
     * SUMMATIVE OPTIONAL Make it so that some of your constructors (including
     * possibly the default) use a random number to set the position and/or speed of
     * the object.
     * 
     * SUMMATIVE OPTIONAL Add more than two constructors for varying levels of
     * customization
     */
     public Bubble (Sketch sketch)
     {
       s = sketch;
       diameter = s.random(50, 70);
       x = s.random(diameter / 2, s.width - diameter / 2);
       y = s.random(diameter / 2, s.height - diameter / 2);
       col = s.color(255, 150);
       borderColor = s.color(10, 150);
       speedX = s.random(1, 2);
       speedY = s.random(1, 2);
     }
     public Bubble (Sketch k, float X, float Y, float ballDiam, int ballColor, int ballAlpha, int borderC, int borderA, float sx, float sy){
       s = k;
       x = X;
       y = Y;
       diameter = ballDiam;
       col = s.color(ballColor, ballAlpha); 
       borderColor = s.color(borderC, borderA);
       speedX = sx;
       speedY = sy;
     }
     

    /*
     * SUMMATIVE REQUIRED Add a method called `getRadius()` that returns a float
     * representing the radius of the bubble
     */
      public float getRadius()
      {
        float f = diameter/2;
        return f;
      }

    /** Draws the bubble. */
    public void drawBubble() {
        s.stroke(borderColor);
        s.fill(col);
        s.ellipse(x, y, diameter, diameter);
    }

    /** Moves the balls. */
    public void moveBubble() {

        /*
         * SUMMATIVE OPTIONAL Tweak this method so that the bubbles don't bounce off the
         * left and right sides, but loop around to the other side instead. 
         */

        /* SUMMATIVE OPTIONAL Tweak bubble movement so that it moves more randomly */

        /* If the bubble is on the left or right edge, bounce! */
        if (x > (s.width + getRadius())) {
          x = -getRadius();
        }
        if ( x < (-getRadius())){
          x = s.width + getRadius();
        }
        /* If the ball goes off the top, move it to the bottom. */
        if (y < (-getRadius())) {
            y = s.height + getRadius();
        }
        /* If the bubble goes off the bottom, move it to the top. */
        if (y > (s.height + getRadius())) {
            y = -getRadius();
        }
        x += speedX;
        y += speedY;

    }
}