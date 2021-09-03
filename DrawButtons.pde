void DrawButtons() {


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
  line(map(85, 0, 800, 0, width), map(21, 0, 600, 0, height), map(85, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(202, 0, 800, 0, width), map(21, 0, 600, 0, height), map(202, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(289, 0, 800, 0, width), map(21, 0, 600, 0, height), map(289, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(376, 0, 800, 0, width), map(21, 0, 600, 0, height), map(376, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(492, 0, 800, 0, width), map(21, 0, 600, 0, height), map(492, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(608, 0, 800, 0, width), map(21, 0, 600, 0, height), map(608, 0, 800, 0, width), map(64, 0, 600, 0, height));
  line(map(695, 0, 800, 0, width), map(21, 0, 600, 0, height), map(695, 0, 800, 0, width), map(64, 0, 600, 0, height));
  strokeWeight(1);
  rect(map(62, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(178, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(352, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(468, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(584, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));
  rect(map(584, 0, 800, 0, width), map(15, 0, 600, 0, height), map(48, 0, 800, 0, width), map(38, 0, 600, 0, height));


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


  //map(Val, 0, 800, 0 , width)
  //map(Val, 0, 600, 0 , height)

  //Draw DRPR button mapped
  fill(0, 0, 255);
  rect(map(717, 0, 800, 0, width), map(70, 0, 600, 0 , height), map(30, 0, 800, 0, width), map(30, 0, 600, 0 , height));
  fill(0);
  text("Drpr", map(720, 0, 800, 0 , width), map(90, 0, 600, 0 , height));

  //Back for Octave slider mapped
  stroke(0);
  fill(0, 0, 70);
  rect(map(752, 0, 800, 0, width), 0, map(47, 0, 800, 0 , width), height-1);

  //Draw Octave slider
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

  //Back for PenSize
  stroke(0);
  fill(0, 0, 100);
  rect(335, height-35, 165, 20);
  //Draw PenSize selector
  fill(0);
  triangle(350, height-25, 479, height-20, 479, height-30);
  ellipseMode(CENTER);
  ellipse(345, height-25, 2, 2);
  ellipse(490, height-25, 15, 15);
  fill(255);
  text(PenSize, 410, 580);

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
  if (Inv==false) {
    if (BW==false) {
      int p;
      for (p=0; p<735; p++) {
        stroke (map(p, 0, 734, 255, 0), 255, 255);
        line (743-p, 1, 743-p, 19);
      }
      stroke(0);
      noFill();
      rect(ColOff, 0, 736, 20);
    }

    if (BW==true) {
      int p;
      for (p=0; p<735; p++) {
        stroke (0, 0, map(p, 0, 734, 255, 0));
        line (743-p, 1, 743-p, 19);
      }
      stroke(0);
      noFill();
      rect(ColOff, 0, 736, 20);
    }
  }     

  if (Inv==true) {
    if (BW==false) {
      int p;
      for (p=0; p<735; p++) {
        stroke (map(p, 0, 734, 255, 0), 255, 255);
        line (ColOff+1+p, 1, ColOff+1+p, 19);
      }
      stroke(0);
      noFill();
      rect(ColOff, 0, 736, 20);
    }

    if (BW==true) {
      int p;
      for (p=0; p<735; p++) {
        stroke (0, 0, map(p, 0, 734, 255, 0));
        line (ColOff+1+p, 1, ColOff+1+p, 19);
      }
      stroke(0);
      noFill();
      rect(ColOff, 0, 736, 20);
    }
  }




  //draw color selector buttons
  if (BW==false) {

    if (Inv==false) {
      stroke(0);
      for (n=0; n<13; n++)
      {
        fill(colors[12-n], 255, 255);
        rect(ColOff+n*ColSpacing, 20, 40, 30);
      }
    }

    if (Inv==true) {
      stroke(0);
      for (v=0; v<13; v++)
      {
        fill(colorsV[v], 255, 255);
        rect(ColOff+v*ColSpacing, 20, 40, 30);
      }
    }
  }

  if (BW==true) {

    if (Inv==false) {
      stroke(0);
      for (n=0; n<13; n++)
      {
        fill(0, 0, colors[12-n]);
        rect(ColOff+n*ColSpacing, 20, 40, 30);
      }
    }

    if (Inv==true) {
      stroke(0);
      for (v=0; v<13; v++)
      {
        fill(0, 0, colorsV[v]);
        rect(ColOff+v*ColSpacing, 20, 40, 30);
      }
    }
  }

  //Legends

  fill(0, 0, 0);
  text("C", 24, 39);
  text("C^", ColOff+16+1*ColSpacing, 39);
  text("D", ColOff+16+2*ColSpacing, 39);
  text("D^", ColOff+16+3*ColSpacing, 39);
  text("E", ColOff+16+4*ColSpacing, 39);
  text("F", ColOff+16+5*ColSpacing, 39);
  text("F^", ColOff+16+6*ColSpacing, 39);
  text("G", ColOff+16+7*ColSpacing, 39);
  text("G^", ColOff+16+8*ColSpacing, 39);
  text("A", ColOff+16+9*ColSpacing, 39);
  text("A^", ColOff+16+10*ColSpacing, 39);
  text("B", ColOff+16+11*ColSpacing, 39);
  text("C2", ColOff+16+12*ColSpacing, 39);
}
