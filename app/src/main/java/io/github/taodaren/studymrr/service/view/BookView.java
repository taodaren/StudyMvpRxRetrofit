package io.github.taodaren.studymrr.service.view;

import io.github.taodaren.studymrr.service.entity.BookBean;

/**
 * 展示 book 接口
 */

public interface BookView extends View {
    //如果 presenter 请求成功，将向该方法传入请求下来的实体类
    void onSuccess(BookBean bookBean);

    //如果请求失败，就会向这个 view 传入失败信息
    void onError(String result);
}
