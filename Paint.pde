void Paint(){
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