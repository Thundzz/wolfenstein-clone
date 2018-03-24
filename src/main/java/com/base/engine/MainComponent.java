package com.base.engine;

public class MainComponent {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE= "3D Engine";

    public MainComponent()
    {

    }

    private void start()
    {
        run();
    }

    public void stop()
    {

    }

    private void run()
    {
        while(!Window.isCloseRequested()){
            render();
        }
    }

    private void render()
    {
        Window.render();
    }

    public void cleanUp()
    {

    }

    public static void main(String[] args)
    {
        Window.createWindow(WIDTH, HEIGHT, TITLE);

        MainComponent game = new MainComponent();

        game.start();
    }
}
