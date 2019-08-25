package edu.fcu.game.wupojung.breakout.Game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.fcu.game.wupojung.breakout.Game.GameComponent.PaddleShapeDrawable;

public class BreakoutGame {

    //region  // Fields

    private int points; //得分
    private int lives;  //生命

    //筆刷
    private Paint scorePaint;
    private Paint livesPaint;

    private PaddleShapeDrawable paddle;

    //endregion

    //region  // Ctor
    public BreakoutGame() {
        Initialize();
    }

    //endregion

    //region  // Utilities
    private void Initialize() {
        //TODO:初始化所有 變數 (NEW)
        paddle = new PaddleShapeDrawable();

        points = 0;
        lives = 3;

        scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(25);

        livesPaint = new Paint();
        livesPaint.setTextAlign(Paint.Align.RIGHT);
        livesPaint.setColor(Color.WHITE);
        livesPaint.setTextSize(25);
    }

    private void RefreshUI(Canvas canvas) {
        canvas.drawText("得分:" + points, 0, 25, scorePaint); //scorePaint 筆刷
        canvas.drawText("生命:" + lives, canvas.getWidth(), 25, livesPaint);
    }

    private void RefreshGameComponent(Canvas canvas) {
        //TODO:更新遊戲元件
        paddle.drawToCanvas(canvas);
    }
    //endregion

    //region  // Methods
    boolean isReady = false;
    public void Update(Canvas canvas) {
        // 我需要 這樣初始化
        if(!isReady) {  //旗標法   來確定下面的code  只會執行1次
            paddle.initCoords(canvas.getWidth(), canvas.getHeight());
            isReady = true;
        }
        //
        RefreshUI(canvas);
        RefreshGameComponent(canvas);
    }


    //endregion

    //region  // Properties

    //endregion
}
