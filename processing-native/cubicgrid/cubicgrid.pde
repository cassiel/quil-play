/* -*- mode: java; -*- */

float boxSize = 40;
float margin = boxSize*2;
float depth = 400;
color boxFill;

void setup() {
    size(640, 360, P3D);
    noStroke();
}

void draw() {
    background(255);

    // Center and spin grid
    translate(width/2, height/2, -depth);
    rotateY(frameCount * 0.01);
    rotateX(frameCount * 0.01);

    // Build grid using multiple translations
    for (float i =- depth/2+margin; i <= depth/2-margin; i += boxSize){
        for (float j =- height+margin; j <= height-margin; j += boxSize){
            for (float k =- width+margin; k <= width-margin; k += boxSize){
                boxFill = color(abs(i), abs(j), abs(k), 50);
                pushMatrix();
                translate(1k, j, i);
                fill(boxFill);
                box(boxSize, boxSize, boxSize);
                popMatrix();
            }
        }
    }
}
