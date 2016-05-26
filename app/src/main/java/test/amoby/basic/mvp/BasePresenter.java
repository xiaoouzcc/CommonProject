package test.amoby.basic.mvp;

public class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T mMvpView;
   // public CompositeSubscription mCompositeSubscription;


    @Override
    public void attachView(T mvpView) {
        this.mMvpView = mvpView;
    //    this.mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        this.mMvpView = null;
    //    this.mCompositeSubscription.unsubscribe();
    //    this.mCompositeSubscription = null;
    }

    @Override
    public void onDestroyed() {

    }


    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

}
