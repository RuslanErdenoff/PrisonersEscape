package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Ruslan on 03.10.2016.
 */
public class IntroScreen  implements Screen{
    StartClass game;
    Viewport viewport;
    Stage stage;
    Intro intro;

    public IntroScreen(StartClass game){
        this.game = game;
        viewport = new StretchViewport(Gdx.graphics. getWidth(), Gdx.graphics.getHeight());
        stage = new Stage();
        intro = new Intro(game);
        stage.addActor(intro);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());
        if(intro.animation.getIsAnimationFinished()){
            game.setScreen(new GameScreen(game));
        }

    }

    @Override
    public void resize(int width, int height) {

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
        intro.animation.dispose();
        stage.dispose();
    }
}
