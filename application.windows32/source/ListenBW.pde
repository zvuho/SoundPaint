void ListenBW (){
    //Make signal point at mouse position inside the pixels array
    int mx = constrain(mouseX, 0, img.width-1);
    int my = constrain(mouseY, 0, img.height-1);
    signal = my*img.width + mx;
    int sx = int(signal) % img.width;
    int sy = int(signal) / img.width;
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


    freq = map(brightness(c), 0, 255, Low, High);
    //Link Amp to Saturation
    if (saturation(c)<20) {
      amp = map(saturation(c), 0, 255, 0.3, 0.0);
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
      wave.setAmplitude(0.0);

   set(0,0,img);
      Modo = 0;
    }
  }
