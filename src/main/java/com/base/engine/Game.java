package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {

    private Mesh mesh;
    private Shader shader;
    private Transform transform;
    private Texture texture;
    private Camera camera;


    public Game()
    {
        //mesh = ResourceLoader.loadMesh("box.obj");
        texture = ResourceLoader.loadTexture("test.png");
        shader = new Shader();
        camera = new Camera();
        Vertex[] vertices = new Vertex[]{
                new Vertex(new Vector3f(-1, -1, 0), new Vector2f(0,0)),
                new Vertex(new Vector3f(0,  1, 0), new Vector2f(0.5f,0)),
                new Vertex(new Vector3f(1, -1, 0), new Vector2f(1.0f,0)),
                new Vertex(new Vector3f(0, -1, 1), new Vector2f(0,0.5f))
        };

        int[] indices = new int[]{  3, 1, 0,
                                    2, 1, 3,
                                    0, 1, 2,
                                    0, 2, 3  };

        mesh = new Mesh();
        mesh.addVertices(vertices, indices);

        transform = new Transform();
        transform.setProjection(70f, Window.getWidth(), Window.getHeight(), 0.1f, 1000f);
        Transform.setCamera(camera);

        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));


        shader.compileShader();

        shader.addUniform("transform");
    }

    public void input()
    {
        camera.input();
        /*if(Input.GetKeyDown(Keyboard.KEY_UP))
            System.out.println("We've just pressed up!");

        if(Input.GetKeyUp(Keyboard.KEY_UP))
            System.out.println("We've just released up!");

        if(Input.GetMouseDown(1))
            System.out.println("We've just right clicked at "+ Input.GetMousePosition());

        if(Input.GetMouseUp(1))
            System.out.println("We've just released right mouse button!");
            */
    }

    float temp = 0.0f;
    public void update()
    {
        temp += Time.getDelta();

        float sinTemp = (float)Math.sin(temp);

        transform.setTranslation(sinTemp, 0, 5);
        transform.setRotation(0, sinTemp * 180, 0);
        //transform.setScale(0.7f*sinTemp, 0.7f*sinTemp, 0.7f*sinTemp);

    }

    public void render()
    {
        RenderUtil.setClearColor(Transform.getCamera().getPos().div(2048f).abs());
        shader.bind();
        shader.setUniform("transform", transform.getProjectedTransformation());
        texture.bind();
        mesh.draw();

    }

}
