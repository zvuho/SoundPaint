       void DrawButtons(){
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
