package edu.fcu.game.wupojung.breakout.Game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.fcu.game.wupojung.breakout.Game.GameComponent.PaddleShapeDrawable;

public class BreakoutGame {

    //region  // Fields

    //狀態機
    private enum eGameStatus {
        INIT,
        READY,
        INGAME,
        OVER,
    }
    private eGameStatus gameStatus;

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
        gameStatus = eGameStatus.INIT;

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
    public void Update(Canvas canvas) {
        switch (gameStatus){
            case INIT:
                paddle.initCoords(canvas.getWidth(), canvas.getHeight());
                gameStatus = eGameStatus.READY; // 切換狀態
                break;
            case READY:
                RefreshUI(canvas);
                RefreshGameComponent(canvas);
                break;
            case INGAME:
                RefreshUI(canvas);
                RefreshGameComponent(canvas);
                break;
            case OVER:
                RefreshUI(canvas);
                RefreshGameComponent(canvas);
                break;
        }

    }


    //endregion

    //region  // Properties

    //endregion
}
