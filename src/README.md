
# JOGL Sprite Viewer
This is a simple Java program that opens a image file that is used as a sprite 
sheet. Then displays that image using OpenGL. It allows you to specify a fixed
rectangular region within the sprite sheet to render, and allows you to scroll
through the different sprites within it by incrementing the index value. It also
allows you to scale the sprite to any width or height, and position the sprite
anywhere in the viewable area.

It was written to test code used to display text and also use fixed and animated 
sprites in game projects.

It is dependent on having the JOGL libs available to the java classpath to compile
correctly. 

to compile

	$ javac JavaSpriteViewer.java

that should compile all .java files. to run the program type the command

	$ java JavaSpriteViewer

## Images 
![swing screenshot](https://i.imgur.com/1hODp8Z.png)

