import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 
import ddf.minim.analysis.*; 
import ddf.minim.effects.*; 
import ddf.minim.signals.*; 
import ddf.minim.spi.*; 
import ddf.minim.ugens.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SoundPaint_NEW_2 extends PApplet {

int Modo=0;

//Minim sinth parameters variables linked to colors
public float Low = 261;
public float High = 523;
public int Octave = 3;
boolean Inv = false;
boolean Auto = false;


//Auto
Agente juan;

  //array of sinth notes
  int n=0;
  int colors[]= {
    254, 226, 199, 174, 150, 127, 106, 85, 66, 48, 31, 15, 0
  };
  //array of inverted sinth notes
  int v=0;
  int colorsV[]= {
    254, 239, 223, 206, 188, 169, 148, 127, 104, 80, 55, 28, 0
  };

//Modified version of PixelArray 1.2.1
PImage img;
int direction = 1;
float signal;
float freq=255; //Link Variable between PixelArray and Minim
float amp=0; //Link Variable between PixelArray and Minim

//Paint VariableS
int oldX=0, oldY=0, drawSat=255, drawBri=255;
int ColSpacing=58;
int ColOff=8;
int PenSize=30;
int huePik;
boolean BW=false;
boolean Drpr=false;








Minim       minim;
AudioOutput out;
Oscil       wave;
 
public void setup() {
  
  background(255);
  
  frameRate(123);
  colorMode (HSB, 255);
 
  //Inicialize Minim
 
  minim = new Minim(this);
 
  // use the getLineOut method of the Minim object to get an AudioOutput object
  out = minim.getLineOut();
 
  // create a sine wave Oscil, set to 440 Hz, at 0.5 amplitude
  wave = new Oscil( 440, 0.5f, Waves.SINE );
  // patch the Oscil to the output
  wave.patch( out );
  wave.setAmplitude(amp);
  //Auto
 juan = new Agente();
}
 
 
public void draw(){
println("MouseX=" + (mouseX) + "MouseY=" + mouseY);
 
  
 
 //MODO = 0 => Run Paint color
  if (Modo==0) {
    if (mousePressed) {
Paint();
}
    oldX=mouseX;
    oldY=mouseY;

    DrawButtons();
}
  
  //Modo = 1 => Load Pixels 
  if (Modo==1) {
    LoadPx();
}

  //Modo = 2 => LISTEN COLOR
  if (Modo==2) {
    ListenCR();
}

  //Modo 3 Dropper
  if (Modo==3) {
    Dropper();
  }
  
  if(Modo==4) {
           //Auto
  juan.mover();
  juan.dibujar();
}

  //Modo = 5 => LISTEN B/W Sinth
  if (Modo==5) {
ListenBW();
}}
 
public void mouseReleased() {
  ButtonsChk();
}
  public void ButtonsChk(){
  
      //check if the BLANK button is pressed
      if (inside (5, 70, 35, 100)) {
        if (BW==false) {

          background(0, 0, 255);
        }
        if (BW==true) {
          background(150, 50, 100);
          ;
        }
      }

      //Drpr button
      if (inside(717, 70, 747, 100)) {
        Drpr=true;
        Modo=1;
      }


      //check if LISTEN button is pressed
      if (inside(width-120, height-40, width-60, height-10)) {
        Modo = 1;
      }  
      
      //check if AUTO button is pressed
      if (inside(650, height-40, 670, height-10)) {
       Auto = true;
      }

      //check if Mouse button is pressed
      if (inside(630, height-40, 649, height-10)) {
       Auto = false;
      }

      //Check if Inv button
      if (inside(width-48, height/2-20, width-33, height/2+20)) {
      Inv=true;
      noFill();
      stroke(255);
      rect(width-65, height/2-22, 19, 44);
      }

      //Check if Inv2 button
      if (inside(width-63, height/2-20, width-48, height/2+20)) {         
        Inv=false;
       }

      //check if BW button is pressed
      if (inside(240, height-40, 255, height-10)) {
        background(150, 50, 100);
        drawSat = 0;
        BW=true;
      }

      //check if C button is pressed
      if (inside(265, height-40, 280, height-10)) {
        background(0, 0, 255);
        BW=false;
      }

      //check if HueSlider is clicked
      if (inside(ColOff, 0, width-65, 19)) {
        drawSat = 255;
        drawBri = 255;
        Huepik();
      }
            //check if OCTAVE is clicked
      if (inside(width-30, 20, width-5, height-20)) {
octave();
//println(Octave);
      }
      
      //check if PenSize is clicked
      if (inside(335, 565, 500,585)) {
Pensize();
      }
      
       //color selector
      if (BW==false) {

          if (Inv==false) {
            for (n=0;n<13;n++) {

              if (inside(ColOff+n*ColSpacing, 20, 40+ColOff+n*ColSpacing, 65)) {

                if (mouseButton==LEFT) {
                  huePik = colors[12-n];
                  drawSat=255;
                  drawBri=255;
                }
                else {
                  background(colors[12-n], 255, 255);
                }
              }
            }
          }
          if (Inv==true) {
            for (v=0;v<13;v++) {

              if (inside(ColOff+v*ColSpacing, 20, 40+ColOff+n*ColSpacing, 65)) {

                if (mouseButton==LEFT) {
                  huePik = colorsV[v];
                  drawSat=255;
                  drawBri=255;
                }
                else {
                  background(colorsV[v], 255, 255);
                }
              }
            }
          }
        }
      
      if (BW==true) {
         if (Inv==false) {
            for (n=0;n<13;n++) {

              if (inside(ColOff+n*ColSpacing, 20, 40+ColOff+n*ColSpacing, 65)) {

                if (mouseButton==LEFT) {
                  huePik = colors[12-n];

                 // println  ("Pik" + Pik);
                  drawSat=0;
                  drawBri=huePik;
                }
                else {
                  background(0, 0, colors[12-n]);
                }
              }
            }
          }

          if (Inv==true) {
            for (v=0;v<13;v++) {

              if (inside(ColOff+v*ColSpacing, 20, 40+ColOff+n*ColSpacing, 65)) {

                if (mouseButton==LEFT) {
                  huePik = colorsV[v];

                  drawSat=0;
                  drawBri=huePik;
                }
                else {
                  background(0, 0, colorsV[v]);
                }
              }
            }
          }
      }
    }
       public void DrawButtons(){
    //D R A W Back for colors
    

    strokeWeight(1);
    stroke(0);
    noFill();
    line(5,height-45,width-55,height-45);
    fill(0, 0, 220);
    rect(0, 0, width-1,65);

    
    //draw semitones
    fill(0,0,50);
    rect(62,15,48,38);
    rect(178,15,48,38);
    rect(352,15,48,38);
    rect(468,15,48,38);
    rect(584,15,48,38);
    rect(584,15,48,38);
    strokeWeight(2);
    line(85,21,85,64);
    line(202,21,202,64);
    line(289,21,289,64);
    line(376,21,376,64);
    line(492,21,492,64);
    line(608,21,608,64);
    line(695,21,695,64);
    
    //draw BLANK button
    stroke(0);
    strokeWeight(1);
    noFill();
    rect(5, 70, 30, 30);
    line(5, 70, 35, 100);
    line(35, 70, 5, 100);
    fill(0, 0, 0);
    text("BLANK", 2, 112);

//Draw the MOUSE/AUTO Listen button
    stroke(0);
    strokeWeight(1);
    fill(255);
    rect(width-150, height-40, 20, 30);
    fill(0,150,255);
    triangle(width-134,height-20,width-145,height-37,width-144,height-17);
    fill(255);
    rect(width-170, height-40, 20, 30);
    ellipse(width-160, height-24,14,20);
    line(width-166, height-26,width-154, height-26);
    line(width-160, height-26,width-160, height-39);
    if(Auto==false){
      noFill();
      stroke(255);
      rect(width-152, height-42, 24, 34);
      stroke(0);
      rect(width-172, height-42, 24, 34);

    }
    
      if(Auto==true){
      noFill();
      stroke(255);
      rect(width-172, height-42, 24, 34);
      stroke(0);
      rect(width-152, height-42, 24, 34);
    }
    
    //draw BW & C button
    stroke(0);
    fill(0, 0, 0);
    rect(240, height-40, 15, 15);
    fill(0, 0, 255);
    rect(240, height-25, 15, 15);
    fill(0, 255, 255);
    rect(265, height-40, 15, 10);
    fill(80, 255, 255);
    rect(265, height-30, 15, 10);
    fill(160, 255, 255);
    rect(265, height-20, 15, 10);
    if (BW==false) {
      noFill();
      rect(262, height-42, 21, 34);
      stroke(255);
      rect(237, height-42, 21, 34);
    }
    if (BW==true) {
      noFill();
      rect(237, height-42, 21, 34);
      stroke (255);
      rect(262, height-42, 21, 34);
    }

    //draw LISTEN button
    stroke(0);
    fill(0, 0, 200);
    rect(width-120, height-40, 60, 30);
    noFill();
    rect(width-115, height-35, 50, 20);
    fill(0, 0, 0);
    text("LISTEN", width-110, height-20);

    //Draw DRPR button
    fill(0, 0, 255);
    rect(width-83, 70, 30, 30);
    fill(0);
    text("Drpr", width-80, 90);

    //Back for Octave slider
    stroke(0);
    fill(0, 0, 70);
    rect(width-48, 0, 47, height-1);
    
    //Draw Octave slider
          stroke(0);
          int o;
          for (o=0;o<7;o++)
          {
            fill(0, 0, 100);
            rect(width-30, 20+o*((height-40)/7),25, ((height-40)/7));
          }
          fill(255);
          rect(width-30, 20+(6-Octave)*((height-40)/7),25, ((height-40)/7));
          fill(0);
          text((Octave),width-20,(65+(6-Octave)*((height-40)/7)));
    fill(0,0,255);
    text("octave",width-40, height-5);

    //Back for PenSize
    stroke(0);
    fill(0, 0, 100);
    rect(335, height-35, 165, 20);
    //Draw PenSize selector
    fill(0);
    triangle(350,height-25,479,height-20,479,height-30);
    ellipseMode(CENTER);
    ellipse(345,height-25,2,2);
    ellipse(490,height-25,15,15);
    fill(255);
    text(PenSize,410,580);

    //Draw Inv button
    fill(255);
    stroke(0);
    rect(width-48, height/2-20, 15, 40);
    rect(width-63, height/2-20, 15, 40);
    line(width-55, height/2-8, width-55, height/2+14);
    triangle(width-55, height/2-15, width-59, height/2-8, width-51, height/2-8);
    line(width-40, height/2-14, width-40, height/2+10);
    triangle(width-40, height/2+15, width-44, height/2+8, width-36, height/2+8);
    if (Inv==false) {
      noFill();
      rect(width-65, height/2-22, 19, 44);
    }
    if (Inv==true) {
      noFill();
      rect(width-50, height/2-22, 19, 44);
    }

   // draw color Piker
   if (Inv==false){
   if(BW==false){
int p;
for(p=0;p<735;p++){
  stroke (map(p,0,734,255,0),255,255);
  line (743-p,1,743-p,19);
}
stroke(0);
noFill();
rect(ColOff,0,736,20);
   }
   
   if(BW==true){
     int p;
for(p=0;p<735;p++){
  stroke (0,0,map(p,0,734,255,0));
  line (743-p,1,743-p,19);
}
stroke(0);
noFill();
rect(ColOff,0,736,20);
}
   }     

   if (Inv==true){
   if(BW==false){
int p;
for(p=0;p<735;p++){
  stroke (map(p,0,734,255,0),255,255);
  line (ColOff+1+p,1,ColOff+1+p,19);
}
stroke(0);
noFill();
rect(ColOff,0,736,20);
   }
   
   if(BW==true){
     int p;
for(p=0;p<735;p++){
  stroke (0,0,map(p,0,734,255,0));
  line (ColOff+1+p,1,ColOff+1+p,19);
}
stroke(0);
noFill();
rect(ColOff,0,736,20);
}
   }

     
     

//draw color selector buttons
    if (BW==false) {

        if (Inv==false) {
          stroke(0);
          for (n=0;n<13;n++)
          {
            fill(colors[12-n], 255, 255);
            rect(ColOff+n*ColSpacing, 20, 40, 30);
          }
        }

        if (Inv==true) {
          stroke(0);
          for (v=0;v<13;v++)
          {
            fill(colorsV[v], 255, 255);
            rect(ColOff+v*ColSpacing, 20, 40, 30);
          }
        }
    }

    if (BW==true) {

        if (Inv==false) {
          stroke(0);
          for (n=0;n<13;n++)
          {
            fill(0, 0, colors[12-n]);
            rect(ColOff+n*ColSpacing, 20, 40, 30);
          }
        }

        if (Inv==true) {
          stroke(0);
          for (v=0;v<13;v++)
          {
            fill(0, 0, colorsV[v]);
            rect(ColOff+v*ColSpacing, 20, 40, 30);
          }
        }
    }
   
       //Legends

      fill(0, 0, 0);
      text("C", 24, 39);
      text("C^",ColOff+16+1*ColSpacing,39);
      text("D",ColOff+16+2*ColSpacing,39);
      text("D^",ColOff+16+3*ColSpacing,39);
      text("E",ColOff+16+4*ColSpacing,39);
      text("F",ColOff+16+5*ColSpacing,39);
      text("F^",ColOff+16+6*ColSpacing,39);
      text("G",ColOff+16+7*ColSpacing,39);
      text("G^",ColOff+16+8*ColSpacing,39);
      text("A",ColOff+16+9*ColSpacing,39);
      text("A^",ColOff+16+10*ColSpacing,39);
      text("B",ColOff+16+11*ColSpacing,39);
      text("C2",ColOff+16+12*ColSpacing,39);
  }
    public void Dropper(){
    //Make signal point at mouse position inside the pixels array
    int mx = constrain(mouseX, 0, img.width-1);
    int my = constrain(mouseY, 0, img.height-1);
    signal = my*img.width + mx;
    int sx = PApplet.parseInt(signal) % img.width;
    int sy = PApplet.parseInt(signal) / img.width;
    set(0, 0, img);  // fast way to draw an image
//Pick Now Message
    fill(0, 20, 200);
    rect(10, height-40, 640, 30);
    fill(0, 0, 0);
    text("P    I    C    K        C    O    L    O    R        N    O    W", 23, height-20);

    //Draw Pointer on the image for current pixel
    stroke(0, 0, 0);
    point(sx, sy);
    noFill();
    rect(sx - 5, sy - 5, 10, 10);
    
    //Make C the color under mouse
    int c = img.get(sx, sy);

    if (mousePressed) {
      if(mouseButton==LEFT){
      if (inside(717, 70, 747, 100)) {
      } 
      else {
        //Set the dropped color to paint
        drawSat=PApplet.parseInt(saturation(c));
        drawBri=PApplet.parseInt(brightness(c));
        huePik=PApplet.parseInt(hue(c));
        oldX=mouseX;
        oldY=mouseY;
        set(0,0,img);
        Modo=0;
        Drpr=false;
      }} else {
        background(c);
        Drpr=false;
      Modo=0;}
    }
  }
// returns true if mouse is inside this rectangle
public boolean inside(int left, int top, int right, int bottom ) {
   
  if (mouseX>left && mouseX<right && mouseY>top && mouseY<bottom ) {
 
    return true;
  }
 
  else {
    return false;
  }
}
public void ListenBW (){
    //Make signal point at mouse position inside the pixels array
    int mx = constrain(mouseX, 0, img.width-1);
    int my = constrain(mouseY, 0, img.height-1);
    signal = my*img.width + mx;
    int sx = PApplet.parseInt(signal) % img.width;
    int sy = PApplet.parseInt(signal) / img.width;
    set(0, 0, img);  // fast way to draw an image


    fill(150, 255, 255);
    rect(10, height-40, 190, 30);
    fill(0, 0, 0);
    text("STRIKE KEY TO PAINT AGAIN", 23, height-20);

    //Draw Pointer on the image for current pixel
    stroke(0, 0, 0);
    point(sx, sy);
    noFill();
    rect(sx - 5, sy - 5, 10, 10);
    int c = img.get(sx, sy);

    //Octave selector

    if (Octave == 0) {
      Low = 33;
      High = 65;
    }


    if (Octave == 1) {
      Low = 65;
      High = 131;
    }



    if (Octave == 2) {
      Low = 131;
      High = 261;
    }


    if (Octave == 3) {
      Low = 261;
      High = 523;
    }

    if (Octave == 4) {
      Low = 523;
      High = 1046;
    }

    if (Octave == 5) {
      Low = 1046;
      High = 2093;
    }


    if (Octave == 6) {
      Low = 2093;
      High = 4186;
    }


    freq = map(brightness(c), 0, 255, Low, High);
    //Link Amp to Saturation
    if (saturation(c)<20) {
      amp = map(saturation(c), 0, 255, 0.3f, 0.0f);
      ;
    }
    else {
      amp=0;
    }

    //Set freq for Minim Sinth
    wave.setFrequency(freq);
    wave.setAmplitude(amp);

    //Print variables to see changes    
    print ("\n Brillo= " + brightness (c) + "   hue= " + hue (c) + "   Freq= " + freq + "   Amp= " + amp);

    //Pressing any key brings back paint mode
    if (keyPressed == true) {
      wave.setAmplitude(0.0f);

   set(0,0,img);
      Modo = 0;
    }
  }
    public void ListenCR(){
      
    //Make signal point at mouse position inside the pixels array
    int mx = constrain(mouseX, 0, img.width-1);
    int my = constrain(mouseY, 0, img.height-1);
    signal = my*img.width + mx;
    int sx = PApplet.parseInt(signal) % img.width;
    int sy = PApplet.parseInt(signal) / img.width;
    set(0, 0, img);  // fast way to draw an image


    fill(150, 255, 255);
    rect(10, height-40, 190, 30);
    fill(0, 0, 0);
    text("STRIKE KEY TO PAINT AGAIN", 23, height-20);

    //Draw Pointer on the image for current pixel
    stroke(0, 0, 0);
    point(sx, sy);
    noFill();
    rect(sx - 5, sy - 5, 10, 10);
    int c = img.get(sx, sy);

    //Octave selector

    if (Octave == 0) {
      Low = 33;
      High = 65;
    }


    if (Octave == 1) {
      Low = 65;
      High = 131;
    }



    if (Octave == 2) {
      Low = 131;
      High = 261;
    }


    if (Octave == 3) {
      Low = 261;
      High = 523;
    }

    if (Octave == 4) {
      Low = 523;
      High = 1046;
    }

    if (Octave == 5) {
      Low = 1046;
      High = 2093;
    }


    if (Octave == 6) {
      Low = 2093;
      High = 4186;
    }


    //Map color as sound freq for Minim.
    if (Inv==false) {  
      freq = map(hue(c), 0, 255, Low, High);
      //Link Amp to Saturation
      amp = map(saturation(c)*brightness(c), 0, 65536, 0.0f, 0.3f);

      //Set freq for Minim Sinth
      wave.setFrequency(freq);
      wave.setAmplitude(amp);

      //Print variables to see changes    
      print ("\n Brillo= " + brightness (c) + "   hue= " + hue (c) + "   Freq= " + freq + "   Amp= " + amp);
    }

    if (Inv==true) {  
      freq = map(hue(c), 0, 255, High, Low);
      //Link Amp to Saturation
      amp = map(saturation(c)*brightness(c), 0, 65536, 0.0f, 0.3f);

      //Set freq for Minim Sinth
      wave.setFrequency(freq);
      wave.setAmplitude(amp);

      //Print variables to see changes    
      print ("\n Brillo= " + brightness (c) + "   hue= " + hue (c) + "   Freq= " + freq + "   Amp= " + amp);
    }



    //Pressing any key brings back paint mode
    if (keyPressed == true) {
      wave.setAmplitude(0.0f);

      //Erase PAINT TEXT
      fill(0, 0, 255);
      noStroke();
      rect(10, height-40, 190, 30);
    set(0,0,img);
    Modo = 0;
    }
  }
    public void LoadPx(){
    //Load display pixels to array "img" to read colours
    img = get();
    //Mode change to 2 makes app to start sounding now that image is loaded
    if (Drpr==true) {
      Modo=3;
    }
    else {
      if (Auto==false){
      if (BW==false) {
          Modo = 2;
        } 
      if (BW==true) {
           Modo=5;
        }
      }
      else {
 Modo=4;
  }
    
  }}
// returns Octave value
public void octave() {
  int o;
for (o=0;o<7;o++) {

if (mouseX>width-30 && mouseY>20+o*((height-40)/7) && mouseX<width-5 && mouseY<20+(1+o)*((height-40)/7)) {
     
  Octave=6-o;
              }
            }

}
public void Paint(){
      //if outside buttons, draw line.
if (inside(0, 66, width-50,height-50)) {

        if (BW==false) {

          //Draw line of seted colour
          strokeWeight(PenSize);

            stroke(huePik, drawSat, drawBri);
            line(mouseX, mouseY, oldX, oldY);
 
        }

        if (BW==true) {
          //Draw line of seted gray
          strokeWeight(PenSize);
            stroke(0, 0, huePik);
            line(mouseX, mouseY, oldX, oldY);

        }
}
}
// PenSize slider
public void Pensize() {
PenSize=(mouseX-335);
}
class Agente{

  float x,y;
  float vel;
  float dir;

  Agente(){
    x = 400;
    y = 300;
    vel = 1;
    dir = radians( 180 );
  }

  Agente( float x_ , float y_ ){
    x = x_;
    y = y_;
    vel = 2;
    dir = radians( 30 );
  }

  public void dibujar(){
    int mx = PApplet.parseInt(x);
    int my = PApplet.parseInt(y);
    //draw img & Auto Pointer 
    set(0, 0, img);  // fast way to draw an image
    pushMatrix();
    translate( x, y );
    rotate( dir );
    noFill();
    triangle( 20 , 0 , 0 , 5 , 0 , - 5);
    line(3,0,-3,0);
    popMatrix(); 
    //Draw Msg
    fill(150, 255, 255);
    rect(10, height-40, 190, 30);
    fill(0, 0, 0);
    text("STRIKE KEY TO PAINT AGAIN", 23, height-20);
   

    //Make signal point at mouse position inside the pixels array
 
    signal = my*img.width + mx;
    int sx = PApplet.parseInt(signal) % img.width;
    int sy = PApplet.parseInt(signal) / img.width;
    //Get color for sinth
    int c = img.get(sx, sy);


    //Octave selector

    if (Octave == 0) {
      Low = 33;
      High = 65;
    }


    if (Octave == 1) {
      Low = 65;
      High = 131;
    }



    if (Octave == 2) {
      Low = 131;
      High = 261;
    }


    if (Octave == 3) {
      Low = 261;
      High = 523;
    }

    if (Octave == 4) {
      Low = 523;
      High = 1046;
    }

    if (Octave == 5) {
      Low = 1046;
      High = 2093;
    }


    if (Octave == 6) {
      Low = 2093;
      High = 4186;
    }


    //Map color as sound freq for Minim.
    if (Inv==false) {  
      freq = map(hue(c), 0, 255, Low, High);
      //Link Amp to Saturation
      amp = map(saturation(c)*brightness(c), 0, 65536, 0.0f, 0.3f);

      //Set freq for Minim Sinth
      wave.setFrequency(freq);
      wave.setAmplitude(amp);

      //Print variables to see changes    
      print ("\n Brillo= " + brightness (c) + "   hue= " + hue (c) + "   Freq= " + freq + "   Amp= " + amp);
    }

    if (Inv==true) {  
      freq = map(hue(c), 0, 255, High, Low);
      //Link Amp to Saturation
      amp = map(saturation(c)*brightness(c), 0, 65536, 0.0f, 0.3f);

      //Set freq for Minim Sinth
      wave.setFrequency(freq);
      wave.setAmplitude(amp);

      //Print variables to see changes    
      print ("\n Brillo= " + brightness (c) + "   hue= " + hue (c) + "   Freq= " + freq + "   Amp= " + amp);
    }



    //Pressing any key brings back paint mode
    if (keyPressed == true) {
      wave.setAmplitude(0.0f);
    set(0, 0, img);  // fast way to draw an image
    Modo = 0;
    }
    if (inside(width-120, height-40, width-60, height-10)) {}
    else{
    if(mousePressed){
    x=mouseX;
    y=mouseY;    
   }}
}
   
  public void mover(){
    dir += radians( random( -10 , 10 ));
    
    float dx = vel * cos( dir );
    float dy = vel * sin( dir );
    x = x+dx;
    y = y+dy;
    
    x = ( x<0 ? x+width-48 : x );
    x = ( x>width-48 ? x-width+48 : x );
    y = ( y<66 ? y+height-111 : y );
    y = ( y>height-45 ? y-height+111 : y );
  }  
}
public void Huepik() {
  if(Inv==false){
huePik=PApplet.parseInt (map((mouseX-ColOff),0,width-65,0,255));
} else {
huePik=PApplet.parseInt (map((mouseX-ColOff),0,width-65,255,0));
}

}
  public void settings() {  size (800, 600);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "SoundPaint_NEW_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
