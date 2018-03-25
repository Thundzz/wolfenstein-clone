package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {

    private Mesh mesh;

    public Game()
    {
        mesh = new Mesh();
        Vertex[] data = new Vertex[]{
                new Vertex(new Vector3f(-1, -1, 0)),
                new Vertex(new Vector3f(0,  1, 0)),
                new Vertex(new Vector3f(1, -1, 0)),

        };
        mesh.addVertices(data);
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
    }

}
