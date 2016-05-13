package org.srr.dev.okhttp.callback;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class ItemCallback<T> implements Callback<T>
{

    private final Class clazz;

    public ItemCallback(Class clazz)
    {
        this.clazz=clazz;
    }

    @Override
    public T parseNetworkResponse(Response response) throws IOException
    {
        String string = response.body().string();
        T t = (T) new Gson().fromJson(string, clazz);
        return t;
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
