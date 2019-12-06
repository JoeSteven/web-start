package com.joey.webstart.utils;


import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readFileByLines(String fileName) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        if (!file.exists()) return lines;
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                lines.add(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return  lines;
    }

    public static void writeToFile(String file, String content) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));// true,进行追加写。
            out.write(content+"\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getJarRootPath() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        //=> file:/root/tmp/demo-springboot-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/
//        log.debug("ResourceUtils.getURL(\"classpath:\").getPath() -> "+path);
        //创建File时会自动处理前缀和jar包路径问题  => /root/tmp
        File rootFile = new File(path);
        if(!rootFile.exists()) {
//            log.info("根目录不存在, 重新创建");
            rootFile = new File("");
//            log.info("重新创建的根目录: "+rootFile.getAbsolutePath());
        }
//        log.debug("项目根目录: "+rootFile.getAbsolutePath());        //获取的字符串末尾没有分隔符 /
        return rootFile.getAbsolutePath();
    }
}