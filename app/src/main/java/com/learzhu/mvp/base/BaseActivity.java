package com.learzhu.mvp.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.learzhu.mvp.presenter.BasePresenter;

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    ////Presenter对象
    protected T mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建Presenter
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter.isViewAttached()) {
            mPresenter.detachView();
        }
    }

    protected abstract T createPresenter();
}
