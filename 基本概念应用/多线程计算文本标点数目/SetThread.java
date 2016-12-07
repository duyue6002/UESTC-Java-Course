package Yue.IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 运行各线程，并输出结果
 */
public class SetThread {
    /*用HashMap保存最终结果*/
    static HashMap<String, Integer> dataList = new HashMap<String, Integer>();

    String[] words = CalcThread.words;

    SetThread(int threadsNum) {
        /*初始化HashMap*/
        for (int i = 0; i < words.length; i++) {
            dataList.put(words[i], 0);
        }

        /*分割文本内容，并输出到各个新文件中*/
        SplitFile sf = new SplitFile(threadsNum);
        for (int i = 0; i < threadsNum; i++) {
            sf.readByLine(i);
        }

        /*设置起始时间*/
        Date before = new Date();

        /*对分离出的文件计算标点符号数目*/
        ArrayList<CalcThread> threads = new ArrayList<CalcThread>();
        CountDownLatch latch = new CountDownLatch(threadsNum);
        for (int i = 0; i < threadsNum; i++) {
            File file = new File("E:\\Part-" + i + ".txt");
            CalcThread thread = new CalcThread(file, latch);
            thread.start();
            threads.add(thread);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*对分线程的结果归总合并*/
        for (int i = 0; i < threadsNum; i++) {
            for (int j = 0; j < words.length; j++) {
                int value = dataList.get(words[j]) + threads.get(i).count[j];
                dataList.put(words[j], value);
            }
        }

        /*控制台输出结果*/
        for (int i = 0; i < words.length; i++) {
            System.out.println("\"" + words[i] + "\"\t数目为：  " + dataList.get(words[i]));
        }

        /*输出用时*/
        int ms = (int) ((new Date()).getTime() - before.getTime());
        System.out.println(threadsNum + "个线程用时：" + ms + "ms");

        /*删除处理的文件*/
        for (int i = 0; i < threadsNum; i++) {
            try {
                File file = new File("E:\\Part-" + i + ".txt");
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}