package test.amoby.basic.mvp;

/**
 * @author 左成城
 * @desc
 * @date 2016/3/21 11:03
 */
public interface PresenterFactory<T extends Presenter>{

    T create();
}


