    void LoadPx(){
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
