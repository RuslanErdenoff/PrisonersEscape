package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Ruslan on 03.10.2016.
 */
public class GameScreen implements Screen {

    Rectangle restartRectangle;
    StartClass game = new StartClass();
    MovementCircle movementCirlce;
    SitCircle sitCircle;
    AttackCircle attackCircle;
    Hero hero;
    Weapons weapons;
    private Stage stage;
    private Stage screenStage;
    private Viewport viewport;
    private Viewport screenViewport;
    Group group;
    Group screenGroup;
    PrisonMap map;


    boolean move;

    public GameScreen(StartClass game){
        this.game = game;
        viewport = new StretchViewport(Gdx.graphics. getWidth(), Gdx.graphics.getHeight(),game.camera);
        screenViewport = new FitViewport(Gdx.graphics. getWidth(), Gdx.graphics.getHeight());


        move = false;

        stage = new Stage(viewport,game.batch);
        screenStage = new Stage(screenViewport,game.batch);
        group = new Group();
        screenGroup = new Group();
        screenGroup.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        group.setSize(210, 100);

        addMap();
        spawnHero(0, 0, game.WIDTH * 15 / 100, game.HEIGHT * 30 / 100, 0, 0, 0, 550, 25, true);

        for(int i = 0 ; i < 25 ; i ++){
        spawnHero(MathUtils.random(0, 500), MathUtils.random(0,500), game.WIDTH * MathUtils.random(10,25) / 100, game.HEIGHT * MathUtils.random(20,45) / 100, 0, 0, 0,550,25,true);
    }
        //spawnWeapon(250, 250, game.WIDTH*5/100, game.HEIGHT*2.5f/100, 0, 0, 0);
        addMovementCircle();
        addAttackCircle();
        addSitCircle();

        stage.addActor(group);
        screenStage.addActor(screenGroup);
        //addActorAt(int index , Actor actor)
        //removeActor()
        //getActors()
        restartRectangle = new Rectangle(game.WIDTH/1.3f,game.HEIGHT/2.3f,100,100);
        game.camera.position.set(hero.bounds.x+hero.bounds.getWidth()/2,hero.bounds.y+(game.WIDTH*15/100), 0);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);


        stage.draw();//Отрисовка всех актеров(у всех вызывает метод draw)
        stage.act(Gdx.graphics.getDeltaTime());//Вызывет у всех метод act, переопределение движения и тд
        screenStage.draw();
        screenStage.act(Gdx.graphics.getDeltaTime());

        if(Gdx.input.isTouched()) {
            game.touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.touchPos.y=game.HEIGHT-game.touchPos.y;
            //camera.unproject(game.touchPos);
            //sample1 ="Mouse X = " + game.touchPos.x;
            //sample2 ="Mouse Y = "+game.touchPos.y;
            //if(game.testRect.contains(game.touchPos.x,game.touchPos.y)){
               // game.testRect.y += 1;
           // }
        }else{
            game.touchPos.x=0;
            game.touchPos.y=0;
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
        stage.dispose();
        game.dispose();
    }

    private void spawnHero(float posX , float posY ,float Width,float Height,float OriginX , float OriginY, float Rotation,float speed,float fps,boolean flip){
        hero = new Hero(posX,posY,Width,Height,OriginX,OriginY,Rotation,speed,fps,flip,game.camera);
        group.addActor(hero);
    }
    private void spawnWeapon(float posX , float posY ,float Width,float Height,float OriginX , float OriginY, float Rotation){
        weapons = new Weapons(posX , posY , Width, Height, OriginX ,  OriginY,  Rotation);
        group.addActor(weapons);
    }
    private void addMovementCircle(){
        movementCirlce = new MovementCircle(game,hero);
        screenGroup.addActor(movementCirlce);
    }
    private void addSitCircle(){
        sitCircle = new SitCircle(game,hero);
        screenGroup.addActor(sitCircle);
    }
    private void addAttackCircle(){
        attackCircle = new AttackCircle(game,hero);
        screenGroup.addActor(attackCircle);
    }
    private void addMap(){
        map = new PrisonMap(game);
        group.addActor(map);
    }
}
