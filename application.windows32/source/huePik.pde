void Huepik() {
  if(Inv==false){
huePik=int (map((mouseX-ColOff),0,width-65,0,255));
} else {
huePik=int (map((mouseX-ColOff),0,width-65,255,0));
}

}
