package test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FromEndRF {
    //记录时间的路径
    private static String filename = System.getProperty("user.dir") + File.separator + "runLibraryTime.txt";

    public static void read(String filename) {
        read(filename, "GBK");
    }

    public static String read(String filename, String charset) {
        File file = new File(filename);
        if (!file.exists()) {
            return null;
        }
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(filename, "r");
            long len = rf.length();
            long start = rf.getFilePointer();
            long nextend = start + len - 1;
            String line;
            rf.seek(nextend);
            int c = -1;
            while (nextend > start) {
                c = rf.read();
                if (c == '\n' || c == '\r') {
                    line = rf.readLine();
                    if (line != null) {
                        return new String(line.getBytes("ISO-8859-1"), charset);
                    } else {
                        System.out.println(line);
                    }
                    nextend--;
                }
                nextend--;
                rf.seek(nextend);
                if (nextend == 0) {// 当文件指针退至文件开始处，输出第一行  
                    line = rf.readLine();
                    System.out.println(new String(line.getBytes("ISO-8859-1"), charset));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rf != null) {
                    rf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethod(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        System.out.println(System.getProperty("user.dir"));
        appendMethod(filename, System.getProperty("line.separator") + System.currentTimeMillis());
        String s = read(filename, "gbk");
        System.out.println(s);
    }
}