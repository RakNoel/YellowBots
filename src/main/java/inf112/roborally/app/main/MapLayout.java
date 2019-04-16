package inf112.roborally.app.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import inf112.roborally.app.editor.Console;
import inf112.roborally.app.editor.EditorInput;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.game.GameController;
import inf112.roborally.app.sprite.SpriteLoader;

/**
 * Class used to render the Maps layout
 * for the main GameController
 *
 * @author RakNoel
 * @version 1.0
 * @since 04.02.19
 */
public class MapLayout implements ApplicationListener {

    private Renderer renderer;

    private InputManager inputManager;
    private EditorInput editorInput;
    private Console console;

    public MapLayout() {
        inputManager = new InputManager(Main.ID_OF_CURRENT_PLAYER);
        editorInput = new EditorInput(GameController.getBoard());
    }

    public void newInputManager(InputManager inputManager){
        this.inputManager = inputManager;
    }

    @Override
    public void create() {
        renderer = new Renderer(GameController.getBoard());
        new SpriteLoader();
        console = new Console();
    }

    @Override
    public void render() {
        try {
            inputManager.checkForInput();
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
        //editorInput messes with grid, and needs to throw OutsideGridExcepetions
        try {
            editorInput.checkForInput();
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }

        //Clear and set background
        Gdx.gl.glClearColor(0F, 0F, 0F, 0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //just a simple grid
        renderer.drawGrid();

        //drawing the board
        try {
            renderer.drawBoard();
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }

        //Draw editor UI if in editor mode
        if (Main.gameState == GameState.EDITOR)
            renderer.drawEditorUI();

        console.render(1);

    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void pause() {
        //Empty for now
    }

    @Override
    public void resume() {
        //Empty for now
    }

    @Override
    public void resize(int i, int i1) {
        //Empty for now
    }

}
