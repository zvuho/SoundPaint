    void Dropper(){
    //Make signal point at mouse position inside the pixels array
    int mx = constrain(mouseX, 0, img.width-1);
    int my = constrain(mouseY, 0, img.height-1);
    signal = my*img.width + mx;
    int sx = int(signal) % img.width;
    int sy = int(signal) / img.width;
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
    color c = img.get(sx, sy);

    if (mousePressed) {
      if(mouseButton==LEFT){
      if (inside(717, 70, 747, 100)) {
      } 
      else {
        //Set the dropped color to paint
        drawSat=int(saturation(c));
        drawBri=int(brightness(c));
        huePik=int(hue(c));
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