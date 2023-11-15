package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Coin extends  GameObject {
    Rectangle hitBox;
    Sprite sprite;
    Texture texture;

    public Coin (int x , int y){
        hitBox = new Rectangle(0,0,15,16);
        texture = new Texture(Gdx.files.internal("sprite/coin (1).png"));
        sprite = new Sprite(texture,0,0,15,16);
        setPosition(x,y);
    }
    @Override
    public int hits(Rectangle r) {
        return 0;
    }

    @Override
    public void action(int type, float x, float y) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
    hitBox.x =x;
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
        return 3;
    }
}
