package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Pole extends  GameObject{
    Rectangle hitBox;
    Sprite sprite;
    Texture texture;
    @Override

    public int hits(Rectangle r) {
        return 0;
    }
    public  Pole(int x ,int y){
        hitBox = new Rectangle(0,0,17,160);
        texture = new Texture(Gdx.files.internal("sprite/pole (1).png"));
        sprite = new Sprite(texture,0,0,17,160);
        setPosition(x,y);
    }

    @Override
    public void action(int type, float x, float y) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
    hitBox.x= x;
    hitBox.y = y;
    sprite.setPosition(x,y);
    }

    @Override
    public void moveLeft(float delta) {

    }

    @Override
    public void moveRight(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
    sprite.draw(batch);
    }

    @Override
    public void jump() {

    }

    @Override
    public Rectangle getHitBox() {
        return hitBox;
    }

    @Override
    public int hitAction(int side) {
        return 4;
    }
}
