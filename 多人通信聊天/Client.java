package Yue.Socket;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private Socket socket = null;
    private BufferedReader br = null;
    private PrintWriter pw = null;
    private boolean quit = false;

    public Client() {
        BufferedReader sbr = null;
        System.out.println("Please enter your nickname:");
        String name = new Scanner(System.in).nextLine();

        try {
            socket = new Socket("127.0.0.1", 5858);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(name);


            new Thread(new ClientThread()).start();

            sbr = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            while (!quit && (str = sbr.readLine()) != null) {
                if (quit)
                    break;
                pw.println(str);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (sbr != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void receive() {
        try {
            String str = br.readLine();
            if (str.equalsIgnoreCase("disconnect")) {
                quit = true;
            }
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientThread implements Runnable {
        public void run() {
            while (true) {
                if (quit) break;
                receive();
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
