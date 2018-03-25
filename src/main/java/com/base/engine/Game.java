package com.base.engine;

import org.lwjgl.input.Keyboard;

import javax.annotation.Resource;

public class Game {

    private Mesh mesh;
    private Shader shader;
    private Transform transform;

    public Game()
    {
        mesh = new Mesh();
        shader = new Shader();

        Vertex[] data = new Vertex[]{
                new Vertex(new Vector3f(-1, -1, 0)),
                new Vertex(new Vector3f(0,  1, 0)),
                new Vertex(new Vector3f(1, -1, 0)),

        };

        mesh.addVertices(data);

        transform = new Transform();

        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));


        shader.compileShader();

        shader.addUniform("transform");
    }

    public void input()
    {
        if(Input.GetKeyDown(Keyboard.KEY_UP))
            System.out.println("We've just pressed up!");

        if(Input.GetKeyUp(Keyboard.KEY_UP))
            System.out.println("We've just released up!");

        if(Input.GetMouseDown(1))
            System.out.println("We've just right clicked at "+ Input.GetMousePosition());

        if(Input.GetMouseUp(1))
            System.out.println("We've just released right mouse button!");
    }

    float temp = 0.0f;
    public void update()
    {
        temp += Time.getDelta();
        transform.setTranslation((float) Math.sin(temp), 0, 0);
    }

    public void render()
    {
        shader.bind();
        shader.setUniform("transform", transform.getTransformation());
        mesh.draw();

    }

}
