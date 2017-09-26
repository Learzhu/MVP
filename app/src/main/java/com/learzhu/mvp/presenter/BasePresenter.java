package com.learzhu.mvp.presenter;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<T> {
    //View接口弱引用
    protected Reference<T> mViewRef;

    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    //获取View
    protected T getView() {
        return mViewRef.get();
    }

    ////判断是否与View建立了关联
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    //解除关联
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
