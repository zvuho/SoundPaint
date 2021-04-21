// returns Octave value
void octave() {
  int o;
for (o=0;o<7;o++) {

if (mouseX>width-30 && mouseY>20+o*((height-40)/7) && mouseX<width-5 && mouseY<20+(1+o)*((height-40)/7)) {
     
  Octave=6-o;
              }
            }

}