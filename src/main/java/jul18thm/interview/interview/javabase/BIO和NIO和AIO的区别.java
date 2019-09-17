package jul18thm.interview.interview.javabase;

import lombok.Data;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Jul.18th.M
 * @date 2019-09-16 15:43
 * description BIO、NIO、AIO 有什么区别
 * 转自：https://github.com/hollischuang/toBeTopJavaer/blob/master/basics/java-basic/bio-vs-nio-vs-aio.md
 */
public class BIO和NIO和AIO的区别 {

    /*
     IO:
     IO是指计算机与外部世界或者一个程序与计算机其他部分之间的接口。所有I/O的主体是内置在操作系统中的。
     */


    /*
     BIO：
     Block I/O，同步阻塞I/O，传统的java.io包下面的代码实现；
     在BIO同步阻塞模式下，数据的读写必须阻塞在一个线程内等待其完成。
     */


    /*
     NIO:
     New I/O与原有I/O有着相同的作用和目的，但NIO的数据打包和传输方式与传统I/O有区别。原有I/O是以流的方式处理数据，NIO是以块的方式处理数据。
     面向流的I/O是一个字节一个字节处理数据的，为流式数据创建过滤器是十分简单的，但面向流的I/O的效率很慢。
     NIO是以块的形式处理数据，处理数据效率高于面向流的I/O，但又缺少面向流I/O处理数据的优雅型和简单性。
     NIO同时支持同步阻塞I/O和同步非阻塞I/O两个模式，同步非阻塞I/O模式是通过一个线程轮询查询所有IO操作状态变化，从而进行下一波操作
     */


    /*
     AIO:
     Asynchronous I/O，异步非阻塞I/O模型，本模型不需要一个线程去轮询所有IO操作状态的改变，在相应的状态改变后，系统会通知对应的线程进行处理。
     */

}

/**
 * 使用BIO实现文件的读取和写入
 *
 * @author Jul.18th.M
 */
class BIO {
    public static void main(String[] args) {
        // 写入BIO
        writeBIO();
        // 读取BIO
        readBIO();
    }

    /**
     * 写入BIO
     *
     * @return void
     * @author Jul.18th.M
     */
    static void writeBIO() {
        // 创建并在控制台输出author对象
        Author author = new Author();
        author.setName("Jul.18th.M");
        author.setAge(24);
        System.out.println(author);
        // 写入author对象👇
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("tempFile"));
            outputStream.writeObject(author);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    /**
     * 读取BIO
     *
     * @return void
     * @author Jul.18th.M
     */
    static void readBIO() {
        // 读取author对象👇
        // 创建一个文件对象
        File file = new File("tempFile");
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            Author newAuthor = (Author) inputStream.readObject();
            System.out.println(newAuthor);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            try {
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


/**
 * 使用NIO方式进行读取和写入
 *
 * @author Jul.18th.M
 */
class NIO {

    private int length;

    public static void main(String[] args) {
        // 读取文件
        readNIO();
        // 写入文件
        writeNIO();

    }

    /**
     * 读取NIO
     *
     * @return void
     * @author Jul.18th.M
     */
    static void readNIO() {
        // 读取文件👇
        String pathName = "C:\\Users\\Administrator\\.gitconfig";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(pathName));
            FileChannel channel = fileInputStream.getChannel();
            // 字节↓
            int capacity = 100;
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + byteBuffer.limit() + ";容量是：" + byteBuffer.capacity() + ";位置是：" + byteBuffer.position());

            int length = -1;

            while ((length = channel.read(byteBuffer)) != -1) {
                /*
                  读取后，将位置置为0，将limit置为容量，已被下次读入到字节缓冲中，从0开始存储
                 */
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                System.out.write(bytes, 0, length);
                System.out.println();
                System.out.println("限制是：" + byteBuffer.limit() + ";容量是：" + byteBuffer.capacity() + ";位置是：" + byteBuffer.position());
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 写入NIO
     *
     * @return void
     * @author Jul.18th.M
     */
    static void writeNIO() {
        String filename = "writeNIO.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(filename));
            FileChannel channel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = Charset.forName("utf8").encode("author: Jul.18th.M");

            // 字节缓冲的容量和limit会随着数据长度变化，不是固定不变的
            System.out.println("初始化容量和limit：" + byteBuffer.capacity() + "," + byteBuffer.limit());

            int length = 0;
            while ((length = channel.write(byteBuffer)) != 0) {
                /*
                 * 这里不需要clear(),将缓冲中的数据写入到通道中，第二次接着上一次的顺序往下读
                 */
                System.out.println("写入长度为：" + length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/**
 * 使用AIO实现文件的读取和写入
 *
 * @author Jul.18th.M
 */
class AIO {

    public static void main(String[] args) {
        // 读取
        readAIO();
        // 写入
        writeAIO();
    }

    static void readAIO() {
        try {
            Path file = Paths.get("C:\\Users\\Administrator\\.gitconfig");
            AsynchronousFileChannel channel = null;
            channel = AsynchronousFileChannel.open(file);
            ByteBuffer byteBuffer = ByteBuffer.allocate(100_100);
            Future<Integer> result = channel.read(byteBuffer, 0);
            while (!result.isDone()) {
                ProfitCalculator.calculatorTax();
            }
            Integer bytesRead = result.get();
            System.out.println("Bytes read [" + bytesRead + "]");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static void writeAIO() {
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get("E:\\debug.log"), StandardOpenOption.READ,
                    StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    System.out.println("Attachment:" + attachment + "" + result + "bytes written");
                    System.out.println("CompletionHandler Thread ID:" + Thread.currentThread().getId());
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.err.println("Attachment:" + attachment + "failed with:");
                    exc.printStackTrace();
                }
            };

            System.out.println("Main Thread ID:" + Thread.currentThread().getId());
            fileChannel.write(ByteBuffer.wrap("Sample".getBytes()),0,"First Wirte",handler);
            fileChannel.write(ByteBuffer.wrap("Box".getBytes()),0,"Second Write",handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ProfitCalculator {
        public ProfitCalculator() {
        }

        public static void calculatorTax() {
        }
    }
}


/**
 * Author对象
 *
 * @author Jul.18th.M
 */
@Data
class Author implements Serializable {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
