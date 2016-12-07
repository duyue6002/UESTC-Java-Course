package Yue.IO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 将文本内容尽量分成n份，使n个线程处理对应的文本
 */
public class SplitFile {
    int fileNum;                                                    //分离的文件数
    File fileIn = new File("E:\\白夜行.txt");
    int bufSize;

    SplitFile(int threadsNum) {
        fileNum = threadsNum;
        bufSize = (int) (fileIn.length() / fileNum);                //一次读取的字节数
    }

    FileChannel fileChaIn, fileChaOut;
    ByteBuffer rBuffer, wBuffer;

    /*设置缓冲区，读文件时，最后一行往往不完整，需要将存在断点的那一行保存，与下一次读文本时的第一行合并*/
    byte[] temp = new byte[0];

    /**
     * 按行具体读出每一个线程所要处理的文本内容
     *
     * @param NO    Thread-NO
     */
    public void readByLine(int NO) {
        String enter = "\n";
        byte[] lineByte;                                            //保存每一行读取内容

        /*确认读取范围*/
        try {
            RandomAccessFile raf = new RandomAccessFile(fileIn, "r");
            raf.seek(NO * bufSize);                                 //根据分离文本进程定位
            fileChaIn = raf.getChannel();
            rBuffer = ByteBuffer.allocate(bufSize);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (fileChaIn.read(rBuffer) != -1) {
                /*生成输出文件Part-No.txt*/
                try {
                    fileChaOut = new RandomAccessFile("E:\\Part-" + NO + ".txt", "rws").getChannel();
                    wBuffer = ByteBuffer.allocateDirect(bufSize);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                /*根据一次读取，确定本次输出的字节长度*/
                int rSize = rBuffer.position();
                byte[] bs = new byte[rSize];
                rBuffer.rewind();
                rBuffer.get(bs);
                rBuffer.clear();

                int startNum = 0;
                int LF = 10;                                        //换行符
                int CR = 13;                                        //回车符
                boolean hasLF = false;                              //是否有换行符
                for (int i = 0; i < rSize; i++) {
                    if (bs[i] == LF) {
                        hasLF = true;
                        int tempNum = temp.length;
                        int lineNum = i - startNum;
                        lineByte = new byte[tempNum + lineNum];     //数组大小已经去掉换行符

                        /*把上一次读取保存在缓冲区的内容和本次读取的这一行的内容合并，保存到lineByte[]中*/
                        System.arraycopy(temp, 0, lineByte, 0, tempNum);
                        temp = new byte[0];
                        System.arraycopy(bs, startNum, lineByte, tempNum, lineNum);

                        /*把该行内容转换成String类型，写入输出文件中*/
                        String line = new String(lineByte, 0, lineByte.length, "GBK");
                        writeByLine(line + enter);

                        /*过滤回车和换行*/
                        if (i == rSize - 1 && bs[i + 1] == CR) {
                            startNum = i + 2;
                        } else {
                            startNum = i + 1;
                        }
                    }
                }

                /*对每次读取的最后一行做特殊处理，将未读完整的当前行不输出，保存在缓冲区中，与下一次读取时合并*/
                if (hasLF) {
                    temp = new byte[bs.length - startNum];
                    System.arraycopy(bs, startNum, temp, 0, temp.length);
                } else {
                    /*兼容单次读取不足一行的情况*/
                    byte[] toTemp = new byte[bs.length + temp.length];
                    System.arraycopy(temp, 0, toTemp, 0, temp.length);
                    System.arraycopy(bs, 0, toTemp, temp.length, bs.length);
                    temp = toTemp;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileChaIn.close();
                fileChaOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写入输出文件
     *
     * @param line 已转换成String类型的当前行文本内容
     */
    public void writeByLine(String line) {
        try {
            fileChaOut.write(wBuffer.wrap(line.getBytes("GBK")), fileChaOut.size());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
