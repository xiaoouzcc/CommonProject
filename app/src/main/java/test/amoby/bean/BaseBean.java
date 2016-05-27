/**
 * @projectName ResultBean
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于淮安爱赢互通科技有限公司内部使用，禁止转发.
 */
package test.amoby.bean;

/**
 * @author 左成城
 * @desc
 * @date 2016/4/14 11:35
 */
public class BaseBean {


    /**
     * result : success
     * message : 成功
     */

    private int result;
    private String message;

    public void setResult(int result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}


