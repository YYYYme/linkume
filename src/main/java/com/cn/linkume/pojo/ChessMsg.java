package com.cn.linkume.pojo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class ChessMsg {
    private String from;
    private String to;
    private String content;
    //空格分隔符
    private final String SPLIT = " ";
    //空格
    private final String REPLACE_SPLIT = "&nbsp;";
    //换行
    private final String NEW_LINE="<br>";

    public ChessMsg(String info) throws Exception {
        if (info == null) {
            throw new Exception("创建消息失败");
        }
        String tag[] = info.split(" ");
        if (tag.length < 3) {
            throw new Exception("创建消息失败");
        }
        this.from = tag[0];
        this.to = tag[1];
        this.content = tag[2];
    }

    public ChessMsg(String from, String to, String content) {
        this.from = encode(from);
        this.to = encode(to);
        this.content = encode(content);
    }

    /**
     * 将消息转换为正常字符格式
     *
     * @param str
     * @return
     */
    private String decode(String str) {
        str = str.replace(REPLACE_SPLIT, SPLIT);
        return str.replace(NEW_LINE, "\n");
    }

    /**
     * 将字符转换为消息格式
     *
     * @param str
     * @return
     */
    private String encode(String str) {
        str = str.replace(SPLIT, REPLACE_SPLIT);
        return str.replace("\n", NEW_LINE);
    }

    public String getContent() {
        return decode(content);
    }

    public String getFrom() {
        return decode(from);
    }

    public String getTo() {
        return decode(to);
    }

    public void setContent(String content) {
        this.content = encode(content);
    }

    public void setFrom(String from) {
        this.from = encode(from);
    }

    public void setTo(String to) {
        this.to = encode(to);
    }
    @Override
    public String toString() {
        return encode(this.from) + " " + encode(this.to) + " "
                + encode(this.content);
    }
    public static void send(Socket socket, String msg) throws Exception{
        msg+="\n\r";
        socket.getOutputStream().write(msg.getBytes("utf8"));
    }
    public static String read(Socket socket) throws Exception{
        return new BufferedReader(new InputStreamReader(
                socket.getInputStream(), "utf8")).readLine();
    }

}