
# JOGL Sprite Viewer
This is a simple Java program that opens a image file that is used as a sprite 
sheet. Then displays that image using OpenGL. It allows you to specify a fixed
rectangular region within the sprite sheet to render, and allows you to scroll
through the different sprites within it by incrementing the index value. It also
allows you to scale the sprite to any width or height, and position the sprite
anywhere in the viewable area.

It was written to test code used to display text and also use fixed and animated 
sprites in game projects.

In order to compiles the JOGL libs must be available on the java classpath. The jogl libs
can be found at https://jogamp.org/deployment/v2.3.2/archive/jogamp-all-platforms.7z

Compilation instructions on a linux system are as follows... (browse to the src directory)

	$ javac -cp .:path_to_jogl/jar/jogl-all.jar:path_to_jogl/jar/gluegen-rt.jar 
	$ JavaSpriteViewer.java *all other .java files in src dir*

that should compile all .java files. to run the program type the command

	$ java -cp .:path_to_jogl/jar/jogl-all.jar:path_to_jogl/jar/gluegen-rt.jar 
	$ JavaSpriteViewer

## Images 
![swing screenshot](https://i.imgur.com/1hODp8Z.png)

