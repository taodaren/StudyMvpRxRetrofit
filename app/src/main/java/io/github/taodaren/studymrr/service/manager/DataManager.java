package io.github.taodaren.studymrr.service.manager;

import android.content.Context;

import io.github.taodaren.studymrr.service.RetrofitHelper;
import io.github.taodaren.studymrr.service.RetrofitService;
import io.github.taodaren.studymrr.service.bean.BookBean;
import rx.Observable;

/**
 * 该类为了更方便调用 RetrofitService 中定义的方法
 */

public class DataManager {
    private RetrofitService mRetrofitService;

    public DataManager(Context context) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Observable<BookBean> getSearchBooks(String name, String tag, int start, int count) {
        return mRetrofitService.getSearchBooks(name, tag, start, count);
    }
}
