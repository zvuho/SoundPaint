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
        stroke (map(p, 0, map(734, 0, 800, 0 , width), 255, 0), map(255, 0, 800, 0 , width), 255);
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
  
  


  
  //map(Val, 0, 800, 0 , width)
  //map(Val, 0, 600, 0 , height)

  //Legends mapped
  int off = int (map(6, 0, 800, 0 , width));
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
