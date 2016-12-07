package Yue.IO;

import java.io.*;
import java.util.concurrent.CountDownLatch;

/**
 * 用于计算符号数目的线程类
 */
public class CalcThread extends Thread {
    File file = null;
    private CountDownLatch latch;
    
    public CalcThread(File file, CountDownLatch latch) {
        this.file = file;
        this.latch = latch;
    }

    /*设置查找标点符号的元素，以及定义保存本线程中每个符号个数的数组*/
    public static String[] words = new String[]{"，", "。", "！", "？", "、", "：", "“", "”"};
    int[] count = new int[words.length];
    
    /**
     * 用于计算标点符号数量的方法
     * @param buffer 从文本中读取的每一行
     * @param count  存放标点符号数量的数组
     */
    static void Calculate(String buffer, int[] count) {
        /*将每一行的字符串类型转换成字符型并存放在数组中*/
        char[] c = buffer.toCharArray();
        String[] array = new String[c.length];
        for (int j = 0; j < words.length; j++) {
            for (int i = 0; i < array.length; i++) {
                array[i] = String.valueOf(c[i]);
                if (array[i].equals(words[j]))
                    count[j]++;
            }
        }
    }

    /*读文件，并计算标点符号数目*/
    public void doCalculate() {
        BufferedReader bRead = null;
        String buffer;

        /*生成读取文件的类，并将文本编码格式改为GBK*/
        try {
            InputStream inputStream = new FileInputStream(this.file);
            InputStreamReader reader = new InputStreamReader(inputStream, "GBK");
            bRead = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件！");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*按行用字符流形式读文件，并将标点符号的数量记录下来*/
        try {
            buffer = bRead.readLine();
            while (buffer != null) {
                Calculate(buffer, count);
                buffer = bRead.readLine();
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                bRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        this.doCalculate();
        latch.countDown();
    }
}