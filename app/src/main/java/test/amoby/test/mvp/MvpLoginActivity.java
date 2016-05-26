package test.amoby.test.mvp;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import test.amoby.basic.mvp.PresenterLoader;
import test.amoby.com.testproject.R;
import test.amoby.test.mvp.factory.LoginFactory;
import test.amoby.test.mvp.presenter.LoginPresenter;
import test.amoby.test.mvp.view.LoginViewImpl;
import test.amoby.utils.ToastUtil;

public class MvpLoginActivity extends Activity implements LoginViewImpl,LoaderManager.LoaderCallbacks<LoginPresenter>{

    private LoginPresenter mLoginPresenter;
    private int LOADER_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_login);
        getLoaderManager().initLoader(LOADER_ID, null, this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        mLoginPresenter.attachView(this);
        mLoginPresenter.login("111111","111111");
    }

    @Override
    protected void onStop() {
        mLoginPresenter.detachView();

        super.onStop();
    }
    @Override
    public void loginSuccess(String message) {

        ToastUtil.showToast(getApplicationContext(),"success");
    }

    @Override
    public void loginFail(String message) {
        ToastUtil.showToast(getApplicationContext(),"fail");
    }

    @Override
    public Loader<LoginPresenter> onCreateLoader(int i, Bundle bundle) {
        return new PresenterLoader<>(this,new LoginFactory());
    }

    @Override
    public void onLoadFinished(Loader<LoginPresenter> loader, LoginPresenter loginPresenter) {

        this.mLoginPresenter = loginPresenter;
    }

    @Override
    public void onLoaderReset(Loader<LoginPresenter> loader) {

        this.mLoginPresenter = null;
    }
}
