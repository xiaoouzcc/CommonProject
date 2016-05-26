package test.amoby.basic.mvp;

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();

    void onDestroyed();

}
