/**
 * @projectName PresenterFactory
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于淮安爱赢互通科技有限公司内部使用，禁止转发.
 */
package test.amoby.basic.mvp;

/**
 * @author 左成城
 * @desc
 * @date 2016/3/21 11:03
 */
public interface PresenterFactory<T extends Presenter>{

    T create();
}


