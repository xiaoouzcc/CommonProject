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


