
import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.*;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.*;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;
import javax.swing.JPanel;

class Renderer implements GLEventListener {

	int renderingProgram;
	int vao[] = new int[1]; //vertex attribute object
	int vbo[] = new int[2]; //vertex buffer object
	int texo; 		//texture id
	int numVerts = 0;
	int numFaceIndex = 0;
	long startTime = 0;
	float width;
	float height;
	FloatBuffer vBuf;
	FloatBuffer tBuf;
	GLAutoDrawable glAutoDrawable;
	OptionsPanel options;

	public Renderer(OptionsPanel op) {
		
		options = op;
	}
	
	@Override
	public void init(GLAutoDrawable glAutoDrawable) {
		
		this.glAutoDrawable = glAutoDrawable;	
		GL3 gl = glAutoDrawable.getGL().getGL3();
		
		this.startTime = System.currentTimeMillis();
		
		//load texture
		loadTexture(options.fileName);

		gl.glPointSize(15.0f);
		//gl.glEnable(GL3.GL_DEPTH_TEST);  
		//gl.glPolygonMode(GL3.GL_FRONT_AND_BACK, GL3.GL_LINE);
		
		//set background colour
		gl.glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
		gl.glClear(GL3.GL_COLOR_BUFFER_BIT);
		
		//generate OPENGL buffers
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glGenBuffers(vbo.length, vbo, 0);	//generate vertex AND normal buffer AND texture buffer
		
		//VAO
		gl.glBindVertexArray(vao[0]);	//make vertex attribute object 0 active 	
		
//		gl.glBindBuffer(GL3.GL_ARRAY_BUFFER, vbo[1]);								//make normal buffer active 
//		gl.glBufferData(GL3.GL_ARRAY_BUFFER, nBuf.limit() * Buffers.SIZEOF_FLOAT, nBuf, GL3.GL_STATIC_DRAW);	//copy normals to VBO[1] 
		
//		gl.glBindBuffer(GL3.GL_ELEMENT_ARRAY_BUFFER, ebo[0]);								//make faces buffer active 
//		gl.glBufferData(GL3.GL_ELEMENT_ARRAY_BUFFER, fBuf.limit() * Buffers.SIZEOF_INT, fBuf, GL3.GL_STATIC_DRAW);	//copy fance indexs to EBO[0]
		
		//load/compile shaders from file
		renderingProgram = createShaders();
	}
		
	@Override
	public void display(GLAutoDrawable glAutoDrawable) {

		GL3 gl = glAutoDrawable.getGL().getGL3();
		
		//use compiled shaders
		gl.glUseProgram(renderingProgram);
		
		//shader uniform variables
		int panelResolution = gl.glGetUniformLocation(renderingProgram, "panelResolution");
		gl.glUniform2f(panelResolution, glAutoDrawable.getSurfaceWidth(), glAutoDrawable.getSurfaceHeight());

		int time = gl.glGetUniformLocation(renderingProgram, "time");
		gl.glUniform1f(time, System.currentTimeMillis() - this.startTime);
		
		boolean b = options.jCheckBox1.isSelected();
		int SDFFlag = (b == true) ? 1 : 0;
		
		int flag = gl.glGetUniformLocation(renderingProgram, "flag");
		gl.glUniform1i(flag, SDFFlag);
		
		// activate texture unit #0 and bind it to the texture object
//		gl.glActiveTexture(GL3.GL_TEXTURE0);
//		gl.glBindTexture(GL3.GL_TEXTURE_2D, texo);

		//vert position
		gl.glBindBuffer(GL3.GL_ARRAY_BUFFER, vbo[0]);		///make vert buffer active
		gl.glVertexAttribPointer(0, 3, GL3.GL_FLOAT, false, Buffers.SIZEOF_FLOAT * 3, 0);
		gl.glEnableVertexAttribArray(0);
		
		//tex position
		gl.glBindBuffer(GL3.GL_ARRAY_BUFFER, vbo[1]);		//make normal buffer active
		gl.glVertexAttribPointer(1, 2, GL3.GL_FLOAT, false, Buffers.SIZEOF_FLOAT * 2, 0);
		gl.glEnableVertexAttribArray(1);
		
		//set background colour and clear the screen
		gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		gl.glClear(GL3.GL_COLOR_BUFFER_BIT | GL3.GL_DEPTH_BUFFER_BIT);
		
		int spriteWidth = (int) options.widthSpinner.getValue();
		int spriteHeight = (int) options.heightSpinner.getValue();
		int spriteScaleWidth = (int) options.scaleSpinnerX.getValue();
		int spriteScaleHeight = (int) options.scaleSpinnerY.getValue();
		int spritePosX = (int) options.posSpinnerX.getValue();
		int spritePosY = (int) options.posSpinnerY.getValue();
		int spriteIndex = (int) options.indexSpinner.getValue();
		
		Sprite2D sprite = new Sprite2D(512, 512);		
		sprite.setIndex(spriteIndex);
		sprite.setSize(spriteWidth, spriteHeight);
		sprite.setScale(spriteScaleWidth, spriteScaleHeight);
		sprite.setPosition(spritePosX, spritePosY);
		
		//DRAW
		drawSprite(gl, sprite);
	}
	
	@Override
	public void dispose(GLAutoDrawable glAutoDrawable) {
		
		
	}
	
	@Override
	public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height) {
		
		GL3 gl = glAutoDrawable.getGL().getGL3();
		this.width = (float) width;
		this.height = (float) height;
		System.out.println("W = " + width + " H = " + height);
	}
	
	private String[] readShaderSource(String path) {
		
		ArrayList<String> vertexList = new  ArrayList<>();

		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			
			String line = in.readLine();

			while (line != null) {

				vertexList.add(line);
				vertexList.add("\n");
				line = in.readLine();
			}

		} catch (Exception ex) {
			
			System.out.println(ex.toString());
		}

		return vertexList.toArray(new String[0]);
	}

	public int createShaders() {
			
		GL3 gl = (GL3) GLContext.getCurrentGL();

		String vshaderSource[] = readShaderSource("vertex.glsl");
		String fshaderSource[] = readShaderSource("fragment.glsl");
		
		int vShader = gl.glCreateShader(GL3.GL_VERTEX_SHADER);
		gl.glShaderSource(vShader, vshaderSource.length, vshaderSource, null, 0);
		gl.glCompileShader(vShader);
		
		int fShader = gl.glCreateShader(GL3.GL_FRAGMENT_SHADER);
		gl.glShaderSource(fShader, fshaderSource.length, fshaderSource, null, 0);
		gl.glCompileShader(fShader);
		
		int vfprogram = gl.glCreateProgram();
		gl.glAttachShader(vfprogram, vShader);
		gl.glAttachShader(vfprogram, fShader);
		gl.glLinkProgram(vfprogram);
		gl.glDeleteShader(vShader);
		gl.glDeleteShader(fShader);
		
		return vfprogram;
	}
	
	public void drawSprite(GL3 gl, Sprite2D s) {

		//shader uniform variables
		int ortho = gl.glGetUniformLocation(renderingProgram, "ortho");
		gl.glUniformMatrix4fv(ortho, 1, false, Buffers.newDirectFloatBuffer(Matrix.orthographic(0f, width, 0f, height, -1f, 1f)));
		
		int scale = gl.glGetUniformLocation(renderingProgram, "scale");
		gl.glUniform2f(scale, s.scale[0], s.scale[1]);
		
		int pos = gl.glGetUniformLocation(renderingProgram, "pos");
		gl.glUniform2f(pos, s.position[0], s.position[1]);
		
		this.vBuf = Buffers.newDirectFloatBuffer(s.verts);
		this.tBuf = Buffers.newDirectFloatBuffer(s.uvs);
		this.numVerts = s.verts.length / 3;
		
		gl.glBindBuffer(GL3.GL_ARRAY_BUFFER, vbo[0]);								//make vert buffer active
		gl.glBufferData(GL3.GL_ARRAY_BUFFER, vBuf.limit() * Buffers.SIZEOF_FLOAT, vBuf, GL3.GL_STATIC_DRAW);	//copy verts to VBO[0] 
		
		gl.glBindBuffer(GL3.GL_ARRAY_BUFFER, vbo[1]);								//make tex buffer active 
		gl.glBufferData(GL3.GL_ARRAY_BUFFER, tBuf.limit() * Buffers.SIZEOF_FLOAT, tBuf, GL3.GL_STATIC_DRAW);	//copy normals to VBO[1] 

		gl.glDrawArrays(GL3.GL_TRIANGLES, 0, numVerts);
		gl.glDrawArrays(GL3.GL_POINTS, 0, numVerts);
	}
	
	public void loadTexture(String fileName) {
		
		if (fileName != null) {
			
			try {				
				
				Texture tex = TextureIO.newTexture(new File(fileName), false);
				texo = tex.getTextureObject();

			} catch (Exception e) { 

				e.printStackTrace(); 
			}
		}	
	}
	
	public void loadMesh(String fileName) {
		
//		PlyParser object = new PlyParser();
//		
//		try {
//			
//			object.parseFile(fileName);
//			this.vertices = object.getVertArray();
//			this.normals = object.getNormArray();
//			this.faces = object.getFacesArray();
//			this.numVerts = object.numElements("vertex");
//			this.numFaceIndex = this.faces.length;
//			
//			this.vBuf = Buffers.newDirectFloatBuffer(vertices);
//			this.nBuf = Buffers.newDirectFloatBuffer(normals);
//			this.fBuf = Buffers.newDirectIntBuffer(faces);
//		
//		} catch (Exception ex) {
//			
//			System.err.println("Could not load PLY file");
//			ex.printStackTrace();
//		}		
	}
	
}
