package Yue.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private Server() {
        ServerSocket ss = null;
        Socket socket = null;
        try {
            ss = new ServerSocket(5858);
            while (true) {
                socket = ss.accept();
                ServerThread st = new ServerThread(socket);
                new Thread(st).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ss != null) {
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private class ServerThread implements Runnable {
        private Socket socket = null;
        private BufferedReader br;
        private PrintWriter pw;
        private String name;
        private boolean quit = false;

        public ServerThread(Socket socket) throws IOException {
            this.socket = socket;
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(), true);
            String str = br.readLine();
            name = str;
            clients.add(this);
            send(name + "上线了！");
        }

        //送出用户信息
        private void send(String msg) {
            for (ServerThread st : clients) {
                st.pw.println(msg);
            }
        }

        //接收客户端发出的信息
        private void receive() throws IOException {
            String str = null;
            while ((str = br.readLine()) != null) {
                if (str.equalsIgnoreCase("bye")) {
                    stop();
                    pw.println("disconnect");
                    break;
                }
                send(name + ":\t" + str);
            }
        }

        //提示客户端下线
        private void stop() {
            clients.remove(this);
            quit = true;
            send(name + "下线了！");
        }

        public void run() {
            try {
                while (true) {
                    if (quit)
                        break;
                    receive();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}

