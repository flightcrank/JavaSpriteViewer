#version 330 core

layout (location = 0) in vec4 vertex;
layout (location = 1) in vec2 tex;

uniform mat4 ortho;
uniform vec2 scale;
uniform vec2 pos;

out vec2 uv;

void main() {
	
	//rotate verts
	
	//scale verts
	vec4 size = vertex * vec4(scale.x, -scale.y, 1.0, 1.0);

	//translate verts to screen space
	vec4 screen = size + vec4(scale.xy, 0.0, 0.0);

	//translate to screen position
	vec4 position = screen + vec4(pos.xy, 0.0, 0.0);
	
	//final vert position
	vec4 clipPos = ortho * position;

	//uv = vec2(0.4) + tex;
	uv = tex;

	//plot final vertex position
	gl_Position = clipPos;
}
