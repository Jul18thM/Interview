package jul18thm.interview.interview.javabase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jul.18th.M
 * @date 2019-09-17 9:38
 * description Files的常用方法都有哪些？
 */
public class Files的常用方法 {

    public static void main(String[] args) throws IOException {

        /*
         * 常用方法一：检查文件路径是否存在 Files.exists()
         */
        // 文件路径
        Path path = Paths.get("E:/debug.log");
        // LinkOption.NOFOLLOW_LINKS表示不追踪符号链接
        Boolean fileIsExist = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        // 控制台输出结果↓
        if(fileIsExist){
            System.out.println("E盘下文件debug.log存在;" + "fileIsExist的值为：" + fileIsExist);
        }else {
            System.out.println("E盘下文件debug.log不存在;" + "fileIsExist的值为：" + fileIsExist);
        }


        /*
         * 常用方法二：创建文件 Files.createFile()
         */
        // 指定文件创建目录和文件名
        Path createFilePath = Paths.get("E:/Demo.txt");
        // 创建文件
        Files.createFile(createFilePath);


        /*
         * 常用方法三：创建文件夹 Files.createDirectory()
         */
        // 制定文件夹创建目录和文件夹名称
        Path directoryLocation = Paths.get("E:/demo");
        // 创建文件夹
        Files.createDirectory(directoryLocation);


        /*
         * 常用方法四：删除一个文件夹或者目录 Files.delete()
         */
        // 指定需要删除的文件或文件夹路径
        Path deleteFilePath = Paths.get("E:/demo");
        // 删除文件或文件夹
        Files.delete(deleteFilePath);


        /*
         * 常用方法五：复制文件 Files.copy()
         */
        Path fileCopy1 = Paths.get("E:/Demo01.txt");
        Path fileCopy2 = Paths.get("E:/Demo02.txt");
        // 将fileCopy1复制给fileCopy2
        Files.copy(fileCopy1,fileCopy2);


        /*
         * 常用方法六：移动文件 Files.remove()
         */
        Path movePath = Paths.get("E:/Demo01.txt");
        Path locationPath = Paths.get("E:/Demo03.txt");
        // 将movePath移动并修改为Demo03.txt
        Files.move(movePath,locationPath);


        /*
         * 常用方法七：查看文件个数 Files.size()
         */
        Path filesPath = Paths.get("E:/Demo01.txt");
        System.out.println(Files.size(filesPath));
    }
}
