package edu.fcu.game.wupojung.breakout.Game.GameComponent;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import java.util.ArrayList;

public class BlockManager {

    private ArrayList<BlockShapeDrawable> blocksList;
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;

    public BlockManager() {
        initialize();
    }

    private void initialize() {
        blocksList = new ArrayList<>();
    }

    public void initCoords(int width, int height) {
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
        reset();
    }

    public void drawToCanvas(Canvas canvas){
        for (int i = 0; i < blocksList.size(); i++) {
            blocksList.get(i).drawToCanvas(canvas);
        }
    }

    public void reset(){
        int blockHeight = SCREEN_HEIGHT / 36;
        int spacing = SCREEN_WIDTH / 144;
        int topOffset = SCREEN_HEIGHT / 10;
        int blockWidth = (SCREEN_WIDTH / 10) - spacing;

        blocksList.clear();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int y_coordinate = (i * (blockHeight + spacing)) + topOffset;
                int x_coordinate = j * (blockWidth + spacing);

                Rect r = new Rect();
                r.set(x_coordinate, y_coordinate, x_coordinate + blockWidth, y_coordinate + blockHeight);

                int color;

                if (i < 2)
                    color = Color.RED;
                else if (i < 4)
                    color = Color.YELLOW;
                else if (i < 6)
                    color = Color.GREEN;
                else if (i < 8)
                    color = Color.MAGENTA;
                else
                    color = Color.LTGRAY;

                BlockShapeDrawable block = new BlockShapeDrawable(r, color);

                blocksList.add(block);
            }
        }
    }

    public ArrayList<BlockShapeDrawable> getList(){
        return  blocksList;
    }
}