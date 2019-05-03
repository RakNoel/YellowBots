package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import static inf112.roborally.app.editor.Console.clear;

public class Menu implements Screen {

    public static Stage stage;

    private static boolean active = true;
    private Table table;
    private BitmapFont font;

    public Menu() {

        stage = new Stage();
        table = new Table();
        table.setFillParent(true);

        //shows lines
        //table.setDebug(true);
        stage.addActor(table);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        new Button.ButtonStyle();
        font = new BitmapFont();
        font.getData().setScale(2);
        style.font = font;
        style.fontColor = Color.RED;
        labelStyle.font = font;
        labelStyle.fontColor = Color.RED;

        Texture robo = new Texture(Gdx.files.internal("src/main/resources/inf112/roborally/app/Menu/RoboMenu.png"));
        Texture editor = new Texture(Gdx.files.internal("src/main/resources/inf112/roborally/app/Menu/editor1.png"));
        Texture play = new Texture(Gdx.files.internal("src/main/resources/inf112/roborally/app/Menu/play3.png"));
        Texture exit = new Texture(Gdx.files.internal("src/main/resources/inf112/roborally/app/Menu/exit1.png"));


        ImageButton rr = new ImageButton(new TextureRegionDrawable(new TextureRegion(robo)));
        ImageButton playbutton = new ImageButton(new TextureRegionDrawable(new TextureRegion(play)));
        ImageButton editorbutton = new ImageButton(new TextureRegionDrawable(new TextureRegion(editor)));
        ImageButton exitbutton = new ImageButton(new TextureRegionDrawable(new TextureRegion(exit)));

        //adds buttons to table
        table.add(rr).center().size(600,300);
        table.row().padBottom(10);
        table.add(playbutton).height(0).height(100);
        table.row().padBottom(10);
        table.add(editorbutton).height(0).height(100);
        table.row();
        table.add(exitbutton).height(0).height(100);

        playbutton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Main.gameState = GameState.PLAYING;
            }
        });

        editorbutton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.gameState = GameState.EDITOR;
            }
        });

        exitbutton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.exit();
            }
        });

        Gdx.input.setInputProcessor(stage);

    }


    @Override
    public void render(float v) {
        if(active && Main.gameState == GameState.MENU){
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stage.act();
            stage.draw();

        }
    }


    public static void openMenu() {
       active = true;
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {

    }
}
