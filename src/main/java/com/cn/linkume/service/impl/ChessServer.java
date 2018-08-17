package com.cn.linkume.service.impl;


import com.cn.linkume.pojo.ChessMsg;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChessServer extends ChessSockets {
    @Value("${chess.server.port}")
    private int port;
    @Value("${chess.server.encode}")
    private int encode;
    @Value("${chess.server.password}")
    private String password;

    private ExecutorService es;
    private ServerSocket ss;
    private ServerListener serverListener;

    public interface ServerListener {
        public void onStop(String err);

        public void onReceive(ChessMsg msg);

        public void onLogin(Socket socket, String name);

        public void onLogout(Socket socket);
    }

    public ChessServer(int size, ServerListener serverListener) {
        super(size);
        this.serverListener = serverListener;
        this.es = Executors.newCachedThreadPool();
    }
    @Override
    public void run() {
        try {
            this.ss = new ServerSocket(port);
            while (true) {
                Socket socket = this.ss.accept();
                es.execute(new ChessUserService(socket, this));
            }
        } catch (IOException e) {
            serverListener.onStop(e.getMessage());
        }
    }

    public void logout(Socket socket) {
        remove(socket);
        try {
            socket.close();
        } catch (IOException e) {
        }
        serverListener.onLogout(socket);
    }

    public boolean login(Socket socket) {
        if (isFull()) {
            return false;
        }
        byte[] by = new byte[64];
        try {
            if (socket.getInputStream().read(by) != -1) {
                String name = new String(by, encode);
                if (name.contains(password)) {
                    add(socket);
                    serverListener.onLogin(socket, name.replace(password, "")
                            .trim());
                    try {
                        ChessMsg.send(socket, "success");
                    } catch (Exception e) {
                    }
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        try {
            ChessMsg.send(socket, "failed");
        } catch (Exception e1) {
        }
        try {
            socket.close();
        } catch (IOException e) {
        }
        return false;
    }

    public void dealMsg(ChessMsg msg) {
        serverListener.onReceive(msg);
    }
}
