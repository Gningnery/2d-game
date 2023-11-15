package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.objects.Brick;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Mario;
import com.mygdx.game.objects.Spikes;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texture;
	private Sprite sprite;
	private OrthographicCamera camera;
	private Mario player;
	private ArrayList<GameObject> list = new ArrayList<GameObject>();




	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false ,800 ,480);
		batch =new SpriteBatch();

		player = new Mario();
		player.setPosition(200,100);

		FileHandle file = Gdx.files.internal("level1.txt");

		try {
			String fileContent = file.readString();
			StringTokenizer tokens = new StringTokenizer(fileContent, " \t\n\r\f");

			while (tokens.hasMoreTokens()) {
				String type = tokens.nextToken();
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());

				if (type.equals("Block")) {
					list.add(new Brick(x, y));
				} else if (type.equals("Spike")) {
					list.add(new Spikes(x, y));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



//		texture = new Texture(Gdx.files.internal("sprite/Safeimagekit-resized-img.png"));
//		sprite = new Sprite(texture,0,0,128,128);
//		sprite.setPosition(100,50);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.draw(batch);
		for (GameObject t : list){
			t.draw((batch));
		}
		batch.end();

		//updates
		player.update(Gdx.graphics.getDeltaTime());
		Rectangle temp = new Rectangle(0,0,800,10);
		if (player.hits(temp)!= -1){
			player.action(1,0,10);
		}
		for (GameObject t : list){
			switch (player.hits(t.getHitBox())){
				case 1:
					switch (t.hitAction(1)){
						case 1 :
						player.action(1,0,t.getHitBox().y +t.getHitBox().height);
						break;
						case 2 :
							player.setPosition(0, 400);
							break;
					}
					break;
				case 2:
					player.action(2,t.getHitBox().x + t.getHitBox().width+1,0);
					break;
				case 3:
					player.action(3,t.getHitBox().x - player.getHitBox().width - 1,0);
					break;
				case 4:
					player.action(4,0,t.getHitBox().y - player.getHitBox().height);
					break;
			}
		}

	updateCamera();

		//controls
		if (Gdx.input.isKeyPressed((Input.Keys.SPACE))){
			player.jump();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			player.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			player.moveRight(Gdx.graphics.getDeltaTime());
		}
	}
	
	@Override
	public void dispose () {

		batch.dispose();
//		texture.dispose();

	}
	public void updateCamera(){
		camera.position.x = player.getHitBox().x;
		camera.update();
	}
}
