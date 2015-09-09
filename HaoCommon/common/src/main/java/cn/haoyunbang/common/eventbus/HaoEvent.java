package cn.haoyunbang.common.eventbus;

/**
 * Created by fangxiao on 15/9/9.
 */
public class HaoEvent<T> {

    /**
     * event数据
     */
    private T data;

    /**
     * 用于区分不同event
     */
    private String eventType = "";

    public HaoEvent(String eventType) {
        this(eventType, null);
    }

    public HaoEvent(String eventType, T data) {
        this.eventType = eventType;
        this.data = data;
    }

    /**
     * 获取event类型
     *
     * @return
     */
    public String getEventType() {
        return this.eventType;
    }

    /**
     * 获取event数据
     *
     * @return
     */
    public T getData() {
        return this.data;
    }
}
