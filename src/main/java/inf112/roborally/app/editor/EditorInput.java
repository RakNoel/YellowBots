package inf112.roborally.app.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.board.Grid;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.GameState;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.*;

import java.lang.reflect.Constructor;

public class EditorInput {

    private static Board board;
    private static Grid grid;
    public static IBoardTile currentTile;
    public static Vector2 gridVec;
    public static Vector2 mouseVec;
    private int rotation = 90;

    public EditorInput(Board board) {
        EditorInput.board = board;
    }

    public void checkForInput() throws OutsideGridException {

        if (Main.gameState != GameState.EDITOR) return;

        float x = Gdx.input.getX();
        float y = Main.WINDOW_HEIGHT - Gdx.input.getY();
        mouseVec = new Vector2(x,y);
        int gridX, gridY;

        //Calculate the grid positions
        gridX = (int) (x / Main.WINDOW_WIDTH * Main.GRID_WIDTH);
        gridY = (int) (y / (Main.WINDOW_HEIGHT - Main.TOP_MARGIN) * Main.GRID_HEIGHT);
        gridVec = new Vector2(gridX, gridY);
        if(gridVec.x > (Main.GRID_WIDTH - 1) || gridVec.y > (Main.GRID_HEIGHT - 1)) gridVec = null;

        if (Gdx.input.isTouched()) {
            //If mouse is not on grid, check if an editor tile is selected. If that's the
            //case, then switch currentTile to the desired tiles.
            //TODO: Make IButtons, so we can call Button.insideBounds() instead of manually checking.
            //TODO: Make EditorButtons that can return the tile we wanna get.
            if (y > Main.WINDOW_HEIGHT - Main.TOP_MARGIN - 1) {
                if(insideBounds(new Vector2(0, Main.WINDOW_HEIGHT - Main.TILE_SIZE), mouseVec)) {
                    currentTile = new Floor(rotation);
                    System.out.println("Floor is selected");
                } else if(insideBounds(new Vector2(Main.TILE_SIZE, Main.WINDOW_HEIGHT - Main.TILE_SIZE), mouseVec)) {
                    currentTile = new Hole(rotation);
                    System.out.println("Hole is selected");
                } else if (insideBounds(new Vector2(Main.TILE_SIZE*2, Main.WINDOW_HEIGHT - Main.TILE_SIZE), mouseVec)) {
                    currentTile = new Wall(rotation);
                    System.out.println("Wall is selected");
                }
                return;
            }


            if (gridVec == null) return;
            if (currentTile == null) return;

            //PLACE HOLE
            if (currentTile instanceof Hole) {

                //Remove tiles if placing a hole
                while(grid.getTiles(gridVec).size() != 0)
                    grid.removeTile(gridVec, grid.getTiles(gridVec).getFirst());

                //Place tile in grid
                grid.addTile(gridVec, new Hole(rotation));
            }

            //PLACE FLOOR
            else {
                if(grid.getTiles(gridVec).size() != 0)
                    //Remove hole if any
                    if (grid.getTiles(gridVec).getFirst() instanceof Hole)
                        grid.removeTile(gridVec, grid.getTiles(gridVec).getFirst());
                    else for (IBoardTile t : grid.getTiles(gridVec)) {
                        if (t.getClass().equals(currentTile.getClass())) {
                            return;
                        }
                    }

                    try {
                        IBoardTile t = currentTile.getClass().getDeclaredConstructor(int.class).newInstance(rotation);
                        grid.addTile(gridVec, t);
                    } catch (Exception e) { e.printStackTrace(); }

            }
        }

        if(currentTile == null) return;
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            currentTile.setRotation(rotation += 90);
            if (rotation > 360) rotation = 90;
            System.out.println("rotation is: " + rotation);
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            currentTile.setRotation(rotation -= 90);
            if (rotation < 0) rotation = 270;
            System.out.println("rotation is: " + rotation);
        }
    }

    public static void enterEditorMode() {
        board.loadEmptyMap();
        grid = board.getGrid();
        Main.gameState = GameState.EDITOR;
    }

    public static void exitEditorMode() {
        board.loadMap("map1");
        Main.gameState = GameState.PLAYING;
    }

    public static void saveMap(String name) {
        board.saveMap(grid, name);
    }

    public static void loadMap(String name) {
        board.loadMap(name);
        Main.gameState = GameState.PLAYING;
    }

    private boolean insideBounds(Vector2 boundsStartPos, Vector2 mousePos) {
        return mousePos.x > boundsStartPos.x && mousePos.x < (boundsStartPos.x + Main.TILE_SIZE)
                && mousePos.y > boundsStartPos.y && mousePos.y < boundsStartPos.y + Main.TILE_SIZE;
    }
}