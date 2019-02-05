package inf112.roborally.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "RoboRally";
        cfg.width = 480;
        cfg.height = 320;

        new LwjglApplication(new inf112.roborally.app.MapLayout(480, 320, 20), cfg);
    }
}