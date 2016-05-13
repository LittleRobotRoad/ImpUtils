package org.srr.dev.okhttp.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class BitmapCallback implements Callback<Bitmap>
{
    @Override
    public Bitmap parseNetworkResponse(Response response) throws Exception
    {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }

    @Override
    public void onBefore(Request request) {

    }

    @Override
    public void onAfter() {

    }

    @Override
    public void inProgress(float progress) {

    }

}
