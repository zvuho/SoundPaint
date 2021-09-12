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

public class SoundPaint extends PApplet {

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
    239, 223, 206, 188, 169, 148, 127, 104, 80, 55, 28, 0
  };

//Modified version of PixelArray 1.2.1
PImage img;
int direction = 1;
float signal;
float freq=255; //Link Variable between PixelArray and Minim
float amp=0; //Link Variable between PixelArray and Minim

//Paint VariableS
int oldX=0, oldY=0, drawSat=255, drawBri=255;
int ColSpacing= PApplet.parseInt (map(58, 0,800, 0 , width)*15);
int ColOff = PApplet.parseInt (map(8, 0, 800, 0 , width)*10);


int PenSize= PApplet.parseInt (map(30, 0, 800, 0 , width)*10);
int huePik;
boolean BW=false;
boolean Drpr=false;








Minim       minim;
AudioOutput out;
Oscil       wave;

public void settings(){
fullScreen();
  smooth();

}
 
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
//println("MouseX=" + (mouseX) + "MouseY=" + mouseY);  
 
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
public void mouseClicked() {
  ButtonsChk();
}

public void mousePressed() {
  ButtonsChk();
}
 
  public void ButtonsChk(){
    //map(Val, 0, 800, 0 , width)
  //map(Val, 0, 600, 0 , height)
    
    
      //check if the BLANK button is pressed mapped
      if (inside (map(5, 0, 800, 0 , width), map(70, 0, 600, 0 , height), map(35, 0, 800, 0 , width), map(100, 0, 600, 0 , height))) {
        if (BW==false) {

          background(0, 0, 255);
        }
        if (BW==true) {
          background(150, 50, 100);
          ;
        }
      }

      //Drpr button mapped
      if (inside(map(710, 0, 800, 0 , width), map(70, 0, 600, 0 , height), map(750, 0, 800, 0 , width), map(100, 0, 600, 0 , height))) {
        Drpr=true;
        Modo=1;
      }


      //check Listen boton mapped
      if (inside(map(680, 0, 800, 0, width), map(560, 0, 600, 0, height), map(740, 0, 800, 0, width),map(590, 0, 600, 0, height))) {
        Modo = 1;
      }  
      
      //check if AUTO button mapped
      if (inside(map(650, 0, 800, 0, width), map(560, 0, 600, 0, height), map(670, 0, 800, 0, width), map(590, 0, 600, 0, height))) {
       Auto = true;
      }

      //check if Mouse button mapped
      if (inside(map(630, 0, 800, 0, width), map(560, 0, 600, 0, height), map(650, 0, 800, 0, width), map(590, 0, 600, 0, height))) {
       Auto = false;
      }

      //Check if Inv button mapped
      if (inside(map(630, 0, 800, 0, width), map(70, 0, 600, 0 , height), map(697, 0, 800, 0, width), map(100, 0, 600, 0 , height))) {
      Inv=!Inv;
      }

      //check if BW button is pressed mapped
      if (inside(map(240, 0, 800, 0, width), map(560, 0, 600, 0 , height), map(255, 0, 800, 0, width), map(590, 0, 600, 0 , height))) {
        background(150, 50, 100);
        drawSat = 0;
        BW=true;
      }

      //check if C button is pressed mapped
      if (inside(map(265, 0, 800, 0, width), map(560, 0, 600, 0 , height), map(280, 0, 800, 0, width), map(590, 0, 600, 0 , height))) {
        background(0, 0, 255);
        BW=false;
      }

      //check if HueSlider is clicked mapped
      if (inside(ColOff, 0, map(741, 0, 800, 0 , width), map(19, 0, 600, 0 , height))) {
        drawSat = 255;
        drawBri = 255;
        Huepik();
      }
            //check if OCTAVE is clicked mapped
      if (inside(map(770, 0, 800, 0 , width), map(20, 0, 600, 0 , height), map(795, 0, 800, 0 , width), map(580, 0, 600, 0 , height))) {
          int o;
  for (o=0;o<7;o++) {
    if (mouseY>map(20, 0, 600, 0 , height)+o*((map(560, 0, 600, 0 , height))/7) && mouseY< (map(20, 0, 600, 0 , height)+(1+o)*(map(560, 0, 600, 0 , height))/7)) Octave=6-o;
            }
      }
      
      //check if PenSize is clicked mapped
      if (inside(map(335, 0, 800, 0 , width), map(560, 0, 600, 0 , height), map(500, 0, 800, 0 , width), map(590, 0, 600, 0 , height))) {
        PenSize=(mouseX - PApplet.parseInt(map(335, 0, 800, 0 , width)));
      }
      
       //color selector mapped A LOT OF REDUNDANT CODE!!
      if (BW==false) {

          if (Inv==false) {
            for (n=0;n<12;n++) {

              if (inside(ColOff+n*ColSpacing, map(20, 0, 800, 0 , width), 40+ColOff+n*ColSpacing, map(650, 0, 600, 0 , height))) {

     
                  huePik = colors[12-n];
                  drawSat=255;
                  drawBri=255;
 
              
                  // background(colors[12-n], 255, 255); 
              }
            }
          }
          if (Inv==true) {
            for (v=0;v<12;v++) {

              if (inside(ColOff+v*ColSpacing,  map(20, 0, 800, 0 , width), 40+ColOff+n*ColSpacing, map(65, 0, 600, 0 , height))) {
                  huePik = colorsV[v];
                  drawSat=255;
                  drawBri=255;
               
                 // background(colorsV[v], 255, 255);
                
              }
            }
          }
        }
      
      if (BW==true) {
         if (Inv==false) {
            for (n=0;n<12;n++) {

              if (inside(ColOff+n*ColSpacing, map(20, 0, 800, 0 , width), 40+ColOff+n*ColSpacing, map(65, 0, 600, 0 , height))) {

                  huePik = colors[12-n];
                  drawSat=0;
                  drawBri=huePik;
                
              }
            }
          }

          if (Inv==true) {
            for (v=0;v<12;v++) {

              if (inside(ColOff+v*ColSpacing, map(20, 0, 800, 0 , width), 40+ColOff+n*ColSpacing, map(65, 0, 600, 0 , height))) {

               
                  huePik = colorsV[v];

                  drawSat=0;
               
              }
            }
          }
      }
    }
public void DrawButtons() {



  
  //map(Val, 0, 800, 0 , width)
  //map(Val, 0, 600, 0 , height)
  
  
  //back for colors Mapped


  strokeWeight(1);
  stroke(0);
  noFill();
  line(map(5, 0, 800, 0, width), map(555, 0, 600, 0, height), map(745, 0, 800, 0, width), map(555, 0, 600, 0, height));
  fill(0, 0, 220);
  rect(0, 0, width-1, map(65, 0, 600, 0, height));


  //draw semitones Mapped
  fill(0, 0, 50);
  strokeWeight(2);
  line(map(89, 0, 800, 0, width), map(21, 0, 600, 0, height), map(89, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(215, 0, 800, 0, width), map(21, 0, 600, 0, height), map(215, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(311, 0, 800, 0, width), map(21, 0, 600, 0, height), map(311, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(404, 0, 800, 0, width), map(21, 0, 600, 0, height), map(404, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(532, 0, 800, 0, width), map(21, 0, 600, 0, height), map(532, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(658, 0, 800, 0, width), map(21, 0, 600, 0, height), map(658, 0, 800, 0, width), map(64, 0, 600, 0, height));
  strokeWeight(1);
  rect(map(65, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(191, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(381, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(508, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(635, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));


  //draw BLANK button mapped
  stroke(0);
  strokeWeight(1);
  noFill();
  rect(map(5, 0, 800, 0, width), map(70, 0, 600, 0, height), map(30, 0, 800, 0, width), map(30, 0, 600, 0, height));
  line(map(5, 0, 800, 0, width), map(70, 0, 600, 0, height), map(35, 0, 800, 0, width), map(100, 0, 600, 0, height));
  line(map(35, 0, 800, 0, width), map(70, 0, 600, 0, height), map(5, 0, 800, 0, width), map(100, 0, 600, 0, height));
  fill(0, 0, 0);
  textSize(map(10, 0, 600, 0, height));
  text("WHITE OUT", map(2, 0, 800, 0, width), map(112, 0, 600, 0, height));

  //Draw the MOUSE/AUTO Listen button mapped
  stroke(0);
  strokeWeight(1);
  fill(255);
  rect(map(650, 0, 800, 0, width), map(560, 0, 600, 0, height), map(20, 0, 800, 0, width), map(30, 0, 600, 0, height));
  fill(0, 150, 255);
  triangle(map(666, 0, 800, 0, width), map(580, 0, 600, 0, height), map(655, 0, 800, 0, width), map(563, 0, 600, 0, height), map(656, 0, 800, 0, width), map(583, 0, 600, 0, height));
  fill(255);
  rect(map(630, 0, 800, 0, width), map(560, 0, 600, 0, height), map(20, 0, 800, 0, width), map(30, 0, 600, 0, height));
  ellipse(map(640, 0, 800, 0, width), map(576, 0, 600, 0, height), map(14, 0, 800, 0, width), map(20, 0, 600, 0, height));
  line(map(634, 0, 800, 0, width), map(574, 0, 600, 0, height), map(646, 0, 800, 0, width), map(574, 0, 600, 0, height));
  line(map(640, 0, 800, 0, width), map(574, 0, 600, 0, height), map(640, 0, 800, 0, width), map(561, 0, 600, 0, height));
  if (Auto==false) {
    noFill();
    stroke(255);
    rect(map(648, 0, 800, 0, width), map(558, 0, 600, 0, height), map(24, 0, 800, 0, width), map(34, 0, 600, 0, height));
    stroke(0);
    rect(map(628, 0, 800, 0, width), map(558, 0, 600, 0, height), map(24, 0, 800, 0, width), map(34, 0, 600, 0, height));
  }

  if (Auto==true) {
    noFill();
    stroke(255);
    rect(map(628, 0, 800, 0, width), map(558, 0, 600, 0, height), map(24, 0, 800, 0, width), map(34, 0, 600, 0, height));
    stroke(0);
    rect(map(648, 0, 800, 0, width), map(558, 0, 600, 0, height), map(24, 0, 800, 0, width), map(34, 0, 600, 0, height));
  }


  //draw BW & C button mapped
  stroke(0);
  fill(0, 0, 0);
  rect(map(240, 0, 800, 0, width), map(560, 0, 600, 0, height), map(15, 0, 800, 0, width), map(15, 0, 600, 0, height));
  fill(0, 0, 255);
  rect(map(240, 0, 800, 0, width), map(575, 0, 600, 0, height), map(15, 0, 800, 0, width), map(15, 0, 600, 0, height));
  fill(0, 255, 255);
  rect(map(265, 0, 800, 0, width), map(560, 0, 600, 0, height), map(15, 0, 800, 0, width), map(10, 0, 600, 0, height));
  fill(80, 255, 255);
  rect(map(265, 0, 800, 0, width), map(570, 0, 600, 0, height), map(15, 0, 800, 0, width), map(10, 0, 600, 0, height));
  fill(160, 255, 255);
  rect(map(265, 0, 800, 0, width), map(580, 0, 600, 0, height), map(15, 0, 800, 0, width), map(10, 0, 600, 0, height));
  if (BW==false) {
    noFill();
    rect(map(262, 0, 800, 0, width), map(558, 0, 600, 0, height), map(21, 0, 800, 0, width), map(34, 0, 600, 0, height));
    stroke(255);
    rect(map(237, 0, 800, 0, width), map(558, 0, 600, 0, height), map(21, 0, 800, 0, width), map(34, 0, 600, 0, height));
  }
  if (BW==true) {
    noFill();
    rect(map(237, 0, 800, 0, width), map(558, 0, 600, 0, height), map(21, 0, 800, 0, width), map(34, 0, 600, 0, height));
    stroke(255);
    rect(map(262, 0, 800, 0, width), map(558, 0, 600, 0, height), map(21, 0, 800, 0, width), map(34, 0, 600, 0, height));
  }


  //draw LISTEN button mapped
  stroke(0);
  fill(0, 0, 200);
  rect(map(680, 0, 800, 0, width), map(560, 0, 600, 0, height), map(60, 0, 800, 0, width), map(30, 0, 600, 0, height));
  noFill();
  rect(map(685, 0, 800, 0, width), map(565, 0, 600, 0, height), map(50, 0, 800, 0, width), map(20, 0, 600, 0, height));
  fill(0, 0, 0);
  textSize(map(16, 0, 600, 0, height));
  text("LISTEN", map(690, 0, 800, 0, width), map(581, 0, 600, 0, height));

  //Draw DRPR button mapped
  fill(0, 0, 255);
  rect(map(710, 0, 800, 0, width), map(70, 0, 600, 0 , height), map(40, 0, 800, 0, width), map(30, 0, 600, 0 , height));
  fill(0);
  text("Drop", map(715, 0, 800, 0 , width), map(90, 0, 600, 0 , height));

  //Back for Octave slider mapped
  stroke(0);
  fill(0, 0, 70);
  rect(map(752, 0, 800, 0, width), 0, map(47, 0, 800, 0 , width), height-1);

  //Draw Octave slider mapped
  stroke(0);
  int o;
  for (o=0; o<7; o++)
  {
    fill(0, 0, 100);
    rect(map(770, 0, 800, 0 , width), map(20, 0, 600, 0 , height)+o*(map(560, 0, 600, 0 , height)/7), map(25, 0, 800, 0 , width), (map(540, 0, 600, 0 , height))/7);
  }
  fill(255);
  rect(map(770, 0, 800, 0 , width), map(20, 0, 600, 0 , height)+(6-Octave)*(map(560, 0, 600, 0 , height)/7), map(25, 0, 800, 0 , width), (map(540, 0, 600, 0 , height))/7);
  fill(0);
  text((Octave), map(780, 0, 800, 0 , width), map(65, 0, 600, 0 , height)+(6-Octave)*((map(560, 0, 600, 0 , height))/7));
  fill(0, 0, 255);
  text("octave", map(760, 0, 800, 0 , width), map(595, 0, 600, 0 , height));

  
  //Back for PenSize mapped
  stroke(0);
  fill(0, 0, 100);
  rect(map(335, 0, 800, 0 , width), map(560, 0, 600, 0 , height), map(165, 0, 800, 0 , width), map(30, 0, 600, 0 , height));
  //Draw PenSize selector
  fill(0);
  triangle(map(350, 0, 800, 0 , width), map(575, 0, 600, 0 , height), map(479, 0, 800, 0 , width), map(580, 0, 600, 0 , height), map(479, 0, 800, 0 , width),map(570, 0, 600, 0 , height));
  ellipseMode(CENTER);
  ellipse(map(345, 0, 800, 0 , width), map(575, 0, 600, 0 , height), 5, 5);
  ellipse(map(490, 0, 800, 0 , width), map(575, 0, 600, 0 , height), map(15, 0, 800, 0 , width), map(15, 0, 800, 0 , width));
  fill(255);
  text(PenSize, map(410, 0, 800, 0 , width), map(580, 0, 600, 0 , height));
  
  //Draw Inv button mapped
  
  fill(255);
  rect(map(630, 0, 800, 0, width), map(70, 0, 600, 0 , height), map(67, 0, 800, 0, width), map(30, 0, 600, 0 , height));
  fill(0);
  if (Inv==false) {
    text("RED>BLUE", map(633, 0, 800, 0 , width), map(90, 0, 600, 0 , height));
  }
  if (Inv==true) {
    text("BLUE>RED", map(633, 0, 800, 0 , width), map(90, 0, 600, 0 , height));
  }
  

  // draw color Piker mapped
  if (Inv==false) {
    if (BW==false) {
      int p;
      for (p=0; p<map(735, 0, 800, 0 , width); p++) {
        stroke (map(p, 0, map(734, 0, 800, 0 , width), 226, 0), 255, 255);
        line (map(741, 0, 800, 0 , width)-p, 1, map(741, 0, 800, 0 , width)-p, 19);
      }
      stroke(0);
      noFill();
      rect(ColOff, 0, map(736, 0, 800, 0 , width), 20);
    }

    if (BW==true) {
      int p;
      for (p=0; p<map(735, 0, 800, 0 , width); p++) {
        stroke (0, 0, map(p, 0, map(734, 0, 800, 0 , width), 255, 0));
        line (map(741, 0, 800, 0 , width)-p, 1, map(741, 0, 800, 0 , width)-p, 19);
      }
      stroke(0);
      noFill();
      rect(ColOff, 0, map(736, 0, 800, 0 , width), 20);
    }
  }     

  if (Inv==true) {
    if (BW==false) {
      int p;
      for (p=0; p<map(735, 0, 800, 0 , width); p++) {
        stroke (map(p, 0, map(734, 0, 800, 0 , width), 226, 0), map(255, 0, 800, 0 , width), 255);
        line (ColOff+1+p, 1, ColOff+1+p, 19);
      }
      stroke(0);
      noFill();
      rect(ColOff, 0, map(736, 0, 800, 0 , width), 20);
    }

    if (BW==true) {
      int p;
      for (p=0; p<map(735, 0, 800, 0 , width); p++) {
        stroke (0, 0, map(p, 0, map(734, 0, 800, 0 , width), 255, 0));
        line (ColOff+1+p, 1, ColOff+1+p, 19);
      }
      stroke(0);
      noFill();
      rect(ColOff, 0, map(736, 0, 800, 0 , width), 20);
    }
  }


  //draw color selector buttons mapped
  if (BW==false) {

    if (Inv==false) {
      stroke(0);
      for (n=0; n<12; n++)
      {
        fill(colors[12-n], 255, 255);
        rect(ColOff+n*ColSpacing, map(20, 0, 600, 0 , height), map(40, 0, 800, 0 , width), map(30, 0, 600, 0 , height));
      }
    }

    if (Inv==true) {
      stroke(0);
      for (v=0; v<12; v++)
      {
        fill(colorsV[v], 255, 255);
        rect(ColOff+v*ColSpacing,  map(20, 0, 600, 0 , height), map(40, 0, 800, 0 , width), map(30, 0, 600, 0 , height));
      }
    }
  }

  if (BW==true) {

    if (Inv==false) {
      stroke(0);
      for (n=0; n<12; n++)
      {
        fill(0, 0, colors[12-n]);
        rect(ColOff+n*ColSpacing,  map(20, 0, 600, 0 , height), map(40, 0, 800, 0 , width), map(30, 0, 600, 0 , height));
      }
    }

    if (Inv==true) {
      stroke(0);
      for (v=0; v<12; v++)
      {
        fill(0, 0, colorsV[v]);
        rect(ColOff+v*ColSpacing,  map(20, 0, 600, 0 , height), map(40, 0, 800, 0 , width), map(30, 0, 600, 0 , height));
      }
    }
  }

  //Legends mapped
  int off = PApplet.parseInt (map(6, 0, 800, 0 , width));
  fill(0, 0, 0);
  text("C", map(23, 0, 800, 0 , width), map(39, 0, 600, 0 , height));
  text("C^", off + ColOff+16+1*ColSpacing, map(39, 0, 600, 0 , height));
  text("D", off +ColOff+16+2*ColSpacing, map(39, 0, 600, 0 , height));
  text("D^", off +ColOff+16+3*ColSpacing, map(39, 0, 600, 0 , height));
  text("E", off +ColOff+16+4*ColSpacing, map(39, 0, 600, 0 , height));
  text("F", off +ColOff+16+5*ColSpacing, map(39, 0, 600, 0 , height));
  text("F^", off +ColOff+16+6*ColSpacing, map(39, 0, 600, 0 , height));
  text("G", off +ColOff+16+7*ColSpacing, map(39, 0, 600, 0 , height));
  text("G^", off +ColOff+16+8*ColSpacing, map(39, 0, 600, 0 , height));
  text("A", off +ColOff+16+9*ColSpacing, map(39, 0, 600, 0 , height));
  text("A^", off +ColOff+16+10*ColSpacing, map(39, 0, 600, 0 , height));
  text("B", off +ColOff+16+11*ColSpacing, map(39, 0, 600, 0 , height));
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
public boolean inside(float left, float top, float right, float bottom ) {
    return (mouseX>left && mouseX<right && mouseY>top && mouseY<bottom );
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
  //map(Val, 0, 800, 0 , width)
  //map(Val, 0, 600, 0 , height)
  
  if(Inv==false){
huePik=PApplet.parseInt (map((mouseX-ColOff),0,map(735, 0, 800, 0 , width),0,226));
} else {
huePik=PApplet.parseInt (map((mouseX-ColOff),0,map(735, 0, 800, 0 , width),255,0));
}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "SoundPaint" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
