package demo;

import java.time.LocalDateTime;

public class Message {

    private String type;
    private String body;
    private String createTime;

    public Message() {
    }

    public Message(String type, String body) {
        this.type = type;
        this.body = body;
        this.createTime = LocalDateTime.now().toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return String.format("Message{type=%s, createTime=%s, body=%s}", getType(), getCreateTime(), getBody());
    }
}
