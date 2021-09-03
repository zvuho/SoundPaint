void Huepik() {
  //map(Val, 0, 800, 0 , width)
  //map(Val, 0, 600, 0 , height)
  
  if(Inv==false){
huePik=int (map((mouseX-ColOff),0,map(735, 0, 800, 0 , width),0,226));
} else {
huePik=int (map((mouseX-ColOff),0,map(735, 0, 800, 0 , width),255,0));
}

}
