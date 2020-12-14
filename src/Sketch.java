/** MAKE SURE TO READ THE README CAREFULLY BEFORE YOU BEGIN EDITING THIS CODE */
import processing.core.PApplet;
import java.lang.Math;

public class Sketch extends PApplet {

    /*
     * SUMMATIVE REQUIRED Declare at least four balls, four bubbles, and four
     * snowflakes as instance variables. I have made the first ball for you.
     * 
     * SUMMATIVE OPTIONAL Use *arrays* to store the elements, rather than individual
     * variables.
     */

    Ball b1;
    Ball b2;
    Ball b3;
    Ball b4;

    Bubble bu1;
    Bubble bu2;
    Bubble bu3;
    Bubble bu4;

    Snowflake sn1;
    Snowflake sn2;
    Snowflake sn3;
    Snowflake sn4;

    boolean b1stop = false;
    boolean b2stop = false;
    boolean b3stop = false;
    boolean b4stop = false;


    public void settings() {
        size(500, 500);
    }

    /*
     * SUMMATIVE REQUIRED Initialize the balls, bubbles, and snowflakes using your
     * constructors inside of setup(). You must use a non-default-constructor at
     * least once and a default constructor at least once for each type.
     * 
     * I have done the first ball for you.
     */
    public void setup() {
        frameRate(30);
        b1 = new Ball(this, color(153,204,0));
        b2 = new Ball(this, color(255,43,0));
        b3 = new Ball(this, 100, 100, 60,color(255,102,0), 4, 2);
        b4 = new Ball(this, 250, 250, 80,color(255,255,0), 2, 4);

        bu1 = new Bubble(this);
        bu2 = new Bubble(this);
        bu3 = new Bubble(this, 150, 100, 65, 255, 150, 10, 150, 2, -3);
        bu4 = new Bubble(this, 350, 100, 80, 255, 150, 10, 150, -3, 1);

        sn1 = new Snowflake(this);
        sn2 = new Snowflake(this);
        sn3 = new Snowflake(this, 150, 100, 100, 255, 150, 255, 50, -2, 2);
        sn4 = new Snowflake(this, 350, 100, 100, 255, 150, 255, 50, 1, 2);
    }

    public void draw() {
        background(45);

        /* SUMMATIVE REQUIRED Draw and move all balls, snowflakes, and bubbles */
        b1.drawBall();
        b1.moveBall();
        b2.drawBall();
        b2.moveBall();
        b3.drawBall();
        b3.moveBall();
        b4.drawBall();
        b4.moveBall();

        bu1.drawBubble();
        bu1.moveBubble();
        bu2.drawBubble();
        bu2.moveBubble();
        bu3.drawBubble();
        bu3.moveBubble();
        bu4.drawBubble();
        bu4.moveBubble();

        sn1.drawSnowflake();
        sn1.moveSnowflake();
        sn2.drawSnowflake();
        sn2.moveSnowflake();
        sn3.drawSnowflake();
        sn3.moveSnowflake();
        sn4.drawSnowflake();
        sn4.moveSnowflake();

        coll();
    }

    /**
     * Convenience method to return a random color
     * 
     * @param transluscent if true, make the color transluscent, otherwise solid
     */
    public int randomColor(boolean transluscent) {
        int alpha;
        if (transluscent) {
            alpha = 125;
        } 
        else {
            alpha = 255;
        }
        return color(random(0, 255), random(0, 255), random(0, 255), alpha);
    }

    /*
     * SUMMATIVE OPTIONAL Add a void method called mousePressed() that stops some or
     * all of the balls from moving when you click the mouse. (it will run
     * automatically when you click if the name is correct)
     * 
     * EXTRA CHALLENGE - can you make it so that only the ball you actually CLICKED
     * stops? (this is a major challenge - you can use the variables mouseX and
     * mouseY to see where the mouse was clicked.)
     */
     public void mousePressed(){
       if(b1.x - b1.getRadius() <= mouseX && mouseX <= b1.x + b1.getRadius() && mouseY <= b1.y + b1.getRadius() && b1.y - b1.getRadius() <= mouseY && !b1stop){
         b1.stop();
         b1stop = true;
       }
       else if(b1.x - b1.getRadius() <= mouseX && mouseX <= b1.x + b1.getRadius() && mouseY <= b1.y + b1.getRadius() && b1.y - b1.getRadius() <= mouseY && b1stop){
         b1.start();
         b1stop = false;
       }
       
       if(b2.x - b2.getRadius() <= mouseX && mouseX <= b2.x + b2.getRadius() && mouseY <= b2.y + b2.getRadius() && b2.y - b2.getRadius() <= mouseY && !b2stop){
         b2.stop();
         b2stop = true;
       }
       else if(b2.x - b2.getRadius() <= mouseX && mouseX <= b2.x + b2.getRadius() && mouseY <= b2.y + b2.getRadius() && b2.y - b2.getRadius() <= mouseY && b2stop){
         b2.start();
         b2stop = false;
       }
       
       if(b3.x - b3.getRadius() <= mouseX && mouseX <= b3.x + b3.getRadius() && mouseY <= b3.y + b3.getRadius() && b3.y - b3.getRadius() <= mouseY && !b3stop){
         b3.stop();
         b3stop = true;
       }
       else if(b3.x - b3.getRadius() <= mouseX && mouseX <= b3.x + b3.getRadius() && mouseY <= b3.y + b3.getRadius() && b3.y - b3.getRadius() <= mouseY && b3stop){
         b3.start();
         b3stop = false;
       }
       
       if(b4.x - b4.getRadius() <= mouseX && mouseX <= b4.x + b4.getRadius() && mouseY <= b4.y + b4.getRadius() && b4.y - b4.getRadius() <= mouseY && !b4stop){
         b4.stop();
         b4stop = true;
       }
       else if(b4.x - b4.getRadius() <= mouseX && mouseX <= b4.x + b4.getRadius() && mouseY <= b4.y + b4.getRadius() && b4.y - b4.getRadius() <= mouseY && b4stop){
         b4.start();
         b4stop = false;
       }

       if(bu1.x - bu1.getRadius() <= mouseX && mouseX <= bu1.x + bu1.getRadius() && mouseY <= bu1.y + bu1.getRadius() && bu1.y - bu1.getRadius() <= mouseY){
        bu2.x = bu1.x; 
        bu3.x = bu1.x;
        bu4.x = bu1.x;
        bu2.y = bu1.y;
        bu3.y = bu1.y;
        bu4.y = bu1.y;
        bu1.speedX = random(-4, 4);
        bu1.speedY = random(-4, 4);
        bu2.speedX = random(-4, 4);
        bu2.speedY = random(-4, 4);
        bu3.speedX = random(-4, 4);
        bu3.speedY = random(-4, 4);
        bu4.speedX = random(-4, 4);
        bu4.speedY = random(-4, 4);
       }
       else if(bu2.x - bu2.getRadius() <= mouseX && mouseX <= bu2.x + bu2.getRadius() && mouseY <= bu2.y + bu2.getRadius() && bu2.y - bu2.getRadius() <= mouseY){
        bu1.x = bu2.x; 
        bu3.x = bu2.x;
        bu4.x = bu2.x;
        bu1.y = bu2.y;
        bu3.y = bu2.y;
        bu4.y = bu2.y;
        bu1.speedX = random(-4, 4);
        bu1.speedY = random(-4, 4);
        bu2.speedX = random(-4, 4);
        bu2.speedY = random(-4, 4);
        bu3.speedX = random(-4, 4);
        bu3.speedY = random(-4, 4);
        bu4.speedX = random(-4, 4);
        bu4.speedY = random(-4, 4);
       }
        else if(bu3.x - bu3.getRadius() <= mouseX && mouseX <= bu3.x + bu3.getRadius() && mouseY <= bu3.y + bu3.getRadius() && bu3.y - bu3.getRadius() <= mouseY){
        bu1.x = bu3.x; 
        bu2.x = bu3.x;
        bu4.x = bu3.x;
        bu1.y = bu3.y;
        bu2.y = bu3.y;
        bu4.y = bu3.y;
        bu1.speedX = random(-4, 4);
        bu1.speedY = random(-4, 4);
        bu2.speedX = random(-4, 4);
        bu2.speedY = random(-4, 4);
        bu3.speedX = random(-4, 4);
        bu3.speedY = random(-4, 4);
        bu4.speedX = random(-4, 4);
        bu4.speedY = random(-4, 4);
       }
        else if(bu4.x - bu4.getRadius() <= mouseX && mouseX <= bu4.x + bu4.getRadius() && mouseY <= bu4.y + bu4.getRadius() && bu4.y - bu4.getRadius() <= mouseY){
        bu1.x = bu4.x;
        bu2.x = bu4.x;
        bu3.x = bu4.x;   
        bu1.y = bu4.y;
        bu2.y = bu4.y;
        bu3.y = bu4.y;
        bu1.speedX = random(-4, 4);
        bu1.speedY = random(-4, 4);
        bu2.speedX = random(-4, 4);
        bu2.speedY = random(-4, 4);
        bu3.speedX = random(-4, 4);
        bu3.speedY = random(-4, 4);
        bu4.speedX = random(-4, 4);
        bu4.speedY = random(-4, 4);
       }
     }

    
    public void coll()
    {
      if(Math.sqrt((b2.x-b1.x)*(b2.x-b1.x)+(b2.y-b1.y)*(b2.y-b1.y)) <= b1.getRadius()+b2.getRadius())
      {
        b1.speedX = -b1.speedX;
        b1.speedY = -b1.speedY;
        b2.speedX = -b2.speedX;
        b2.speedY = -b2.speedY;
      }
      if(Math.sqrt((b3.x-b1.x)*(b3.x-b1.x)+(b3.y-b1.y)*(b3.y-b1.y)) <= b1.getRadius()+b3.getRadius())
      {
        b1.speedX = -b1.speedX;
        b1.speedY = -b1.speedY;
        b3.speedX = -b3.speedX;
        b3.speedY = -b3.speedY;
      }
      if(Math.sqrt((b4.x-b1.x)*(b4.x-b1.x)+(b4.y-b1.y)*(b4.y-b1.y)) <= b4.getRadius()+b4.getRadius())
      {
        b1.speedX = -b1.speedX;
        b1.speedY = -b1.speedY;
        b4.speedX = -b4.speedX;
        b4.speedY = -b4.speedY;
      }
      if(Math.sqrt((b2.x-b3.x)*(b2.x-b3.x)+(b2.y-b3.y)*(b2.y-b3.y)) <= b1.getRadius()+b3.getRadius())
      {
        b2.speedX = -b2.speedX;
        b2.speedY = -b2.speedY;
        b3.speedX = -b3.speedX;
        b3.speedY = -b3.speedY;
      }
      if(Math.sqrt((b2.x-b4.x)*(b2.x-b4.x)+(b2.y-b4.y)*(b2.y-b4.y)) <= b2.getRadius()+b4.getRadius())
      {
        b2.speedX = -b2.speedX;
        b2.speedY = -b2.speedY;
        b4.speedX = -b4.speedX;
        b4.speedY = -b4.speedY;
      }
     if(Math.sqrt((b3.x-b4.x)*(b3.x-b4.x)+(b3.y-b4.y)*(b3.y-b4.y)) < b3.getRadius()+b4.getRadius()||Math.sqrt((b3.x-b4.x)*(b3.x-b4.x)+(b3.y-b4.y)*(b3.y-b4.y)) == b3.getRadius()+b4.getRadius())
      {
        b3.speedX = -b3.speedX;
        b3.speedY = -b3.speedY;
        b4.speedX = -b4.speedX;
        b4.speedY = -b4.speedY; 
      }
    }

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }
}