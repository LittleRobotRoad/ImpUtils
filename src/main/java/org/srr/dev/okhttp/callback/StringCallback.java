package org.srr.dev.okhttp.callback;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class StringCallback implements Callback<String>
{
    @Override
    public String parseNetworkResponse(Response response) throws IOException
    {
        return response.body().string();
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
