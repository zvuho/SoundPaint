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

  void dibujar(){
    int mx = int(x);
    int my = int(y);
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
    int sx = int(signal) % img.width;
    int sy = int(signal) / img.width;
    //Get color for sinth
    color c = img.get(sx, sy);


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
      amp = map(saturation(c)*brightness(c), 0, 65536, 0.0, 0.3);

      //Set freq for Minim Sinth
      wave.setFrequency(freq);
      wave.setAmplitude(amp);

      //Print variables to see changes    
      print ("\n Brillo= " + brightness (c) + "   hue= " + hue (c) + "   Freq= " + freq + "   Amp= " + amp);
    }

    if (Inv==true) {  
      freq = map(hue(c), 0, 255, High, Low);
      //Link Amp to Saturation
      amp = map(saturation(c)*brightness(c), 0, 65536, 0.0, 0.3);

      //Set freq for Minim Sinth
      wave.setFrequency(freq);
      wave.setAmplitude(amp);

      //Print variables to see changes    
      print ("\n Brillo= " + brightness (c) + "   hue= " + hue (c) + "   Freq= " + freq + "   Amp= " + amp);
    }



    //Pressing any key brings back paint mode
    if (keyPressed == true) {
      wave.setAmplitude(0.0);
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
   
  void mover(){
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