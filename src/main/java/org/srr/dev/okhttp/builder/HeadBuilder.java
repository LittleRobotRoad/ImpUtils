package org.srr.dev.okhttp.builder;

import org.srr.dev.okhttp.OkHttpUtils;
import org.srr.dev.okhttp.request.OtherRequest;
import org.srr.dev.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers).build();
    }
}
