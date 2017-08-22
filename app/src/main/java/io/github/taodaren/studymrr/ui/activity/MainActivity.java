package io.github.taodaren.studymrr.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.github.taodaren.studymrr.R;
import io.github.taodaren.studymrr.service.entity.BookBean;
import io.github.taodaren.studymrr.service.presenter.BookPresenter;
import io.github.taodaren.studymrr.service.view.BookView;

/**
 * Android 教你一步步搭建 MVP + Retrofit + RxJava 网络请求框架
 */

public class MainActivity extends AppCompatActivity {
    private TextView textShow;
    private BookPresenter mBookPresenter = new BookPresenter(this);

    private BookView mBookView = new BookView() {
        @Override
        public void onSuccess(BookBean bookBean) {
            textShow.setText(bookBean.toString());
        }

        @Override
        public void onError(String result) {
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);
    }

    private void initView() {
        textShow = (TextView) findViewById(R.id.text_show);
        setClickListener();
    }

    private void setClickListener() {
        findViewById(R.id.btn_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBookPresenter.getSearchBooks("金瓶梅", null, 0, 1);
            }
        });
        findViewById(R.id.btn_quit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
    }

}
