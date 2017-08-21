package io.github.taodaren.studymrr.service;

import io.github.taodaren.studymrr.app.I;
import io.github.taodaren.studymrr.service.bean.BookBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Retrofit 网络请求服务接口
 */

public interface RetrofitService {
    @GET(I.ADD_BOOK_SEARCH)
    Observable<BookBean> getSearchBooks(@Query("q") String name,
                                        @Query("tag") String tag,
                                        @Query("start") int start,
                                        @Query("count") int count);
}
