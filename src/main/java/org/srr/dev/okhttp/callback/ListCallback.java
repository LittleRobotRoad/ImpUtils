package org.srr.dev.okhttp.callback;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class ListCallback<T> implements Callback<List<T>>
{
    @Override
    public List<T> parseNetworkResponse(Response response) throws IOException
    {
        String string = response.body().string();
        List<T> user = new Gson().fromJson(string, List.class);
        return user;
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
