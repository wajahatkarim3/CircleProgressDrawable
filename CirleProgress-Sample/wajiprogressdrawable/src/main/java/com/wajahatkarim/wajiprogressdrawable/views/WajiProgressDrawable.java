package com.wajahatkarim.wajiprogressdrawable.views;

/**
 * Created by Wajahat Karim on 12/12/2016.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.facebook.drawee.drawable.ProgressBarDrawable;

public class WajiProgressDrawable extends ProgressBarDrawable {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mLevel = 0;
    private int maxLevel = 10000;

    public int frontColor = Color.RED, backColor = Color.GRAY;


    @Override
    protected boolean onLevelChange(int level) {
        mLevel = level;
        invalidateSelf();
        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        if (getHideWhenZero() && mLevel == 0) {
            return;
        }
        drawBar(canvas, maxLevel, backColor);
        drawBar(canvas, mLevel, frontColor);
    }

    private void drawBar(Canvas canvas, int level, int color) {
        Rect bounds = getBounds();
        RectF rectF = new RectF((float) (bounds.right * .4), (float) (bounds.bottom * .4),
                (float) (bounds.right * .6), (float) (bounds.bottom * .6));
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        if (level != 0)
            canvas.drawArc(rectF, 0, (float) (level * 360 / maxLevel), false, mPaint);
    }
}
