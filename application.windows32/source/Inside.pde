// returns true if mouse is inside this rectangle
boolean inside(float left, float top, float right, float bottom ) {
    return (mouseX>left && mouseX<right && mouseY>top && mouseY<bottom );
}
