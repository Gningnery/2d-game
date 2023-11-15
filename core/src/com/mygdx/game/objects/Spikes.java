package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Spikes extends  GameObject {
    Rectangle hitBox;
    Sprite sprite;
    Texture texture;

    public Spikes (int x, int y){
       hitBox = new Rectangle(x , y , 64 , 40);
       texture = new Texture(Gdx.files.internal("sprite/4_Conjoined_Spikes (1).png"));
       sprite = new Sprite(texture , 0, 27, 64 , 40);
       setPosition(x,y);
    }

    @Override
    public int hits(Rectangle r) {
        return -1;
    }

    @Override
    public void action(int type, float x, float y) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        hitBox.x = x;
        hitBox.y = y;
        sprite.setPosition(x , y);

    }

    @Override
    public void moveLeft(float delta) {

    }

    @Override
    public void moveRight(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(hitBox.x, hitBox.y);
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
        if (side == 1) return  2;

        return 1;
    }
}
