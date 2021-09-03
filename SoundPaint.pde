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

import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

Minim       minim;
AudioOutput out;
Oscil       wave;

void settings(){
fullScreen();
  smooth();

}
 
void setup() {
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
 
 
void draw(){
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
 
void mouseReleased() {
  ButtonsChk();
}
