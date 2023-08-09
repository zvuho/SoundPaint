# SoundPaint


## Intro

You can try the app with the compiled Windows and Linux executables.

Listen to the colors under your fingertips. 
Your drawing or any picture, in an interactive or semirandom way. 
Creating a flexible relationship between colors and musical notes.

To work on it you need a processing IDE and import the MINIM audio library.

There s a colors palette in the shape of a piano, each key color is calibrated to sound like that piano key when the LISTEN mode is on.



![UI Snapshot 1](SoundPaint%20UI%201.png)
You can create semi symetric melodies this way: 
"ta di da di ta" 
"tu du di du tu"




![UI Snapshot 2](SoundPaint%20UI%202.png)
Use it as a music notation system
To visualize in a different way while you compose a song.




![UI Snapshot BW](SoundPaint%20UI%20BW.png)
Grayscale mode where you can applay the previous concepts too


And many other ways to use it...


## There are many ways to LISTEN to your drawings:

Mouse driven: SoundPaint will get the color code under the mouse or fingertip and translate it to sound in a configurable relationship between the colors spectrum and the sound spectrum.

Bug driven: A little bug that will crawl on the drawing walking in random directions making sound on its way.



Grayscale mode. You only paint with shades of gray and instead of hue, brightness is used to tune the sound.

You can choose between the 7 octaves of a real piano, and flip the color to sound mapping, so high pitch is red instead of blue.

The paint mode is most basic but has a Blank boton that clears the canvas.
A dropper to pick any color from the screen. No Undo, sorry.
You can choose from the piano colors or from a "continuous" palette, but beware... colors that are not calibrated will sound like a untunned piano so to speak.

I had a version that that could open any bmp or jpg so you could listen to photos, etc. And save the drawings as well. It had MIDI output option, but I lost the files. Sorry.


## Features still to develop:

THIS IS MEANT TO BE A PROOF OF CONCEPT.
Many things to improve
Tons of refactoring, botons size is mapped to the size of the screen in every frame.
Test classes?? haha 
It was my first attempt to making a real program.
Its a coding mess, yes. But it works and shows the potential of the concept if farther developed.

I probably leave this version as it is. And spend any coding fun time in the react and android verions.
Anyway, issues:

- Take the botons out of the rendering area to some settings windows. Leave at hand only the most used options

- Or being able to create "Custom made" pianos, asociating arbitrarily notes and colors without relationship betwen them all. Just make each color sound like any Hertz value or musical note in each piano key.

- I would like to create a "synesthia mode" a preset with with colors and notes associated as syneste...tic? people associate them.

- Multituch touches[], one synth for each finger.
- Multiple singing bugs each configurable: speed on canvas, octave, twitch ammount

- Currently you listen to one pixel under finger, Multi pixel Mode would listen to mean, max, min etc.. of a multi point matix centred under the finger.

- Phone camera eyetracking to be one step closer to "listening with the eyes" in the way that syneste..tic people do.


## Process


### Intro:

This project continues the process of this very simple program that I started in 2008:

Color to Sound
http://desalterain.blogspot.com.uy/2017/03/color-to-sound-and-grayscale-to-sound.html

Http://openprocessing.org/visuals/?visualID=3733
This used to be an applet you could use on chrome or ffox but the page changed and now it doesn't

Using the same idea, and code, for listening to the colors under the mouse pointer I added a "Paint Mode" to the program, and many options about the relationship between colors and notes.


I found several Paint codes in Processing.
I chose the one I thought had the simplest code and at the same time implemented buttons to select colors and two extra functions: Save the image as a file and exit the program. 

Simple Paint by Ferhat Sen!

Http://openprocessing.org/visuals/?visualID=13510
Here you used to be able to try it, broken link now.

### Version history

I attached my "Color to Sound" to the "Simple Paint" that I found. Like sewing a dog head to a snake tail.
So a "Mode" variable chooses between the two forms of operation (draw or listen) at the beginning of each processing cycle. 
I changed the color mode: from "RGB" by default, to "HSB", this way I have better control of the hue, saturation, etc, parameters without using external functions. 

I enlarged the palette from 4 to 14 colors, to have an octave and its semitones. I labeled each color with the corresponding note.
I linked the amplitude of the sound to the saturation value of the color. To keep silent when scanning the white sheet and only sound is heard as it passes over the strokes of color. But this does have an effect when listening to a photo or any image which colors aren't fully saturated. The colors of SoundPaint palette are fully saturated, no option (for now 2016).

Then, I converted the "exit" button to the "BLANK" function which leaves the sheet white again.
I converted the "save image" button to the "save drawing to a memory array and start reading the color under the mouse and sounding the according note" function. Now it's the "Listen to Drawing" button. 


I used the Minim audio library of processing for the sin sinth and audio output.

Any key pressed in the keyboard returns us to "Paint" mode again. 

I still do not get to a relationship between colors and notes that feels natural. What I will do in future versions will be to make that configurable. 
Same as there are pairs of colors that work better together than others, there are pairs of notes more harmonic than others. I would like to find a relationship of colors and notes that works well in both domains.

The colors are organized naturally in the chromatic circle, while the notes work rather like a spiral staircase of 7 floors/octaves. 
When organizing the 7 notes in a circle is always a jump between the last and the first note of the octave.

So I made the default Hertz range to cover exactly one central octave instead of whatever.
If the chromatic circle makes a turn, it is well that the "sonic" circle also gives a single turn/octave.
Then I found the colors corresponding to each note and created the notes palette with a small program I wrote appart.

Here I tried to set up two octaves because there are melodies that require more than one octave, but it is more natural like that. Using two or more octaves for one chromatic circle doesn't feels natural.
There is a difference between the frequency in Hz of the colors-notes of maximum 2 Hz with the actual note. It happens that the "hue" is an integer value (from 0 to 255) and to convert Hz the fractions are lost. 


I will try to solve this issue too, the range of the hue variable is modifiable in the colorMode () function.
I Modified the button "Listen"
I created "Strike key to paint again" message in audio mode.
I tried graphic sliders searching one that gave me accuracy of at least 1 / 10,000, in order to select an exact Hz frequency.
I settled for one a bit slow to set up, but accurate. It's not often modified and needs accuracy.


I decided on a "tics" selector that sets the range by each of seven octaves, the other way of setting frequency range was not practical. But it took some research and codding.

I can now read the color of the screen pixels directly, without saving an image file on the hard disk and reading the pixels from there. 
Finally I understood how it all works :) 

Without the need of a file to save and load of, I can upload an applet that works to see online, with OpenProcessing.org having issues I'm now researching how to embed the applet here in the blog.

For this version (somehow numbered 15) you can load any image using the typical file selection dialog that all programs use. 
But I took this posibility out to make it internet frendly in next versions.
And then I didn't put it back because it's already crowded of buttons, sliders, after a while of going forward.


I found some fun in listening to photos. Somehow strange and really unpredictable.
I added slide for brush size. 
New slide to select any color not included in the palette. 
Midi simple instruments, or the sinusoid sinth from minim. 

Hability to invert the relationship between colors and sounds. In one mode cold colors mean high pitch, in the other hot colors mean high pitch. 
Tere's now a grayscale mode. The pallete is grayscale and it picks up the luminance value of the pixel instead of the hue value to set up the sound sinth.

I put the color palette up and draw a subtle design of piano keys. An idea I took from my arts degree professor Mr Laborde.
To give piano "affordance" and help the intuition of the user.
I replaced all the sliders from the Library ControlP5 by home made sliders more adapted to each function.
This is evident in the old Hue's slider, wich is now a homemade "colorpicker". 
By not using ControlP5 I save 100kb that occupy the library.
I went down from 600 to 500kbs weighing the program now, and the interface is more intuitive this way. 

I organized the code in "void functions ()",
Now each routine is in a different tab, now the main code only has calls to those functions, but it does not the code body of each.
Order and progress!

I created "Automatic" mode of listening. 
A "living bug"... called Juan, is crawling on the screen and singing according to the color by which it passes. 
A restless arrow, rather than a bug, if imagination does not rule in your kingdom. 
I learned to make those object oriented bugs in the course of "Artificial life forms applied to the art" by Ing. Emiliano Causa. 

For now that's it.
I worked on it till 2017.

Similar Programs:

At the beginning of this project, 2008, I started to investigate and found 9 programs that converted image to sound in different ways, some interactive.


Audio Paint
Audio Paint 1.0, released in 2002
Now, 2011, goes the 2.2
Http://www.nicolasfournel.com/audiopaint.htm

Listen to the picture.
Touching a button scans the image from right to left and produces sharp sound if there are strokes in the upper part of the image and bass for what one drew down.
But as I did not find any that did it as my SoundPaint started from scratch, imagining.

Singing Fingers
July 2010, Singing Fingers 1.0
Http://singingfingers.com/
With the slogan: "Finger Paint with Your Voice"

Published by Beginner's Mind, almost a year after I uploaded my "Color to Sound" sketch to Openprocessing.
I wrote them mail to exchange experiences.
Eric told me how they control the color of the stroke by analyzing the predominant musical note of the microphone.
Applies the same concept of converting color to musical notes and vice versa.
Analyzing the microphone input and with the possibility of touching the screen directly.
I love the twist they gave the concept!
With the possibilities offered by an Ipad
The interactivity of Singing Fingers is very good!
Beginner's Mind seems to be a work group at the Massachusetts Institute of Technology.

My approach has been more scientific than ludic.
And less commercial, less Ipod, Ipad, Ibook.
More Openpod, Openpad, Openbook, open source for developers and free application for users.
Go open software / hardware!

Twinkle
Investigating further I found Jay Silver, one of the creators of Singing Fingers.
Another crazy loon who likes to play with 555, computers and sensors.
He created the Twinkle.
Basically a web camera with built-in light that when passing near colored surfaces causes the pc to emit sounds of different notes according to the color of the surface.
Something similar to my initial project that then became Sound Paint and other ramifications.
This thing works similar to old wand barcode readers, but picking up the dominant color under the cam and making them sound, in intervals of time that depend on the computer speed behind the cam to some point.
Here it is in action. 
Http://vimeo.com/10697723 

http://photosounder.com/
Scans the image from left to right

http://www.skytopia.com/software/sonicphoto/
Scans the image from left to right

Paint2Sound
http://bedroomproducersblog.com/2012/04/11/paint2sound-free-image-to-audio-converter-by-flexibeatzii/
Scans the image from left to right

https://www.seeingwithsound.com/im2sound.htm
Scans the image from left to right (Ctrl+C, Ctrl+V, yeah)

https://highc.org/Scans the image from left to right (Ctrl+C, Ctrl+V, yeah)

http://www.uisoftware.com/MetaSynth/Scans the image from left to right (Ctrl+C, Ctrl+V, yeah)

http://www.emusician.com/gear/1332/say-it-with-pictures/40102
Here hey list and analize many programs, not mine.

"Audition, FL Studio, MetaSynth, and Poseidon convert the graphics file into a 2-D sonogram display, which shows frequency on the y-axis and time on the x-axis and uses intensity (brightness) to represent amplitude"

HighC uses a hybrid musical-score/piano-roll metaphor and, like the original UPIC system, provides tools for drawing the gestures and shapes that will control musical parameters. Coagula and MetaSynth also provide tools for drawing an image from scratch, while AudioPaint lets you generate a new image automatically with its configurable Lines & Curves and Clouds of Points tools."

I couldn't find any program that does what SoundPaint does, not remotelly.


I found this page that documents the relationship between colors and music throughout history. 
Http://home.vicnet.net.au/~colmusic/ 
