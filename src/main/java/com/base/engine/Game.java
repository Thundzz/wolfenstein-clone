package com.base.engine;

import org.lwjgl.input.Keyboard;

import javax.annotation.Resource;

public class Game {

    private Mesh mesh;
    private Shader shader;

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
        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));

        shader.compileShader();
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

    public void update()
    {

    }

    public void render()
    {
        mesh.draw();
        shader.bind();
    }

}
