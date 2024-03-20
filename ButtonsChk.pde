 
  void ButtonsChk(){
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

            //check if OCTAVE is clicked mapped
      if (inside(map(770, 0, 800, 0 , width), map(20, 0, 600, 0 , height), map(795, 0, 800, 0 , width), map(580, 0, 600, 0 , height))) {
          int o;
  for (o=0;o<7;o++) {
    if (mouseY>map(20, 0, 600, 0 , height)+o*((map(560, 0, 600, 0 , height))/7) && mouseY< (map(20, 0, 600, 0 , height)+(1+o)*(map(560, 0, 600, 0 , height))/7)) Octave=6-o;
            }
      }
      
      //check if PenSize is clicked mapped
      if (inside(map(335, 0, 800, 0 , width), map(560, 0, 600, 0 , height), map(500, 0, 800, 0 , width), map(590, 0, 600, 0 , height))) {
        PenSize=(mouseX - int(map(335, 0, 800, 0 , width)));
      }
      
       //color selector mapped A LOT OF REDUNDANT CODE!!
      if (BW==false) {

          if (Inv==false) {
            for (n=0;n<12;n++) {

              if (inside(ColOff+n*ColSpacing, map(16, 0, 800, 0 , width), 40+ColOff+n*ColSpacing, map(65, 0, 600, 0 , height))) {

     
                  huePik = colors[12-n];
                  drawSat=255;
                  drawBri=255;
 
              
                  // background(colors[12-n], 255, 255); 
              }
            }
          }
          if (Inv==true) {
            for (v=0;v<12;v++) {

              if (inside(ColOff+v*ColSpacing,  map(16, 0, 800, 0 , width), 40+ColOff+n*ColSpacing, map(65, 0, 600, 0 , height))) {
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

              if (inside(ColOff+n*ColSpacing, map(16, 0, 800, 0 , width), 40+ColOff+n*ColSpacing, map(65, 0, 600, 0 , height))) {

                  huePik = colors[12-n];
                  drawSat=0;
                  drawBri=huePik;
                
              }
            }
          }

          if (Inv==true) {
            for (v=0;v<12;v++) {

              if (inside(ColOff+v*ColSpacing, map(16, 0, 800, 0 , width), 40+ColOff+n*ColSpacing, map(65, 0, 600, 0 , height))) {

               
                  huePik = colorsV[v];

                  drawSat=0;
               
              }
            }
          }
      }
    }
