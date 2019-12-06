package com.joey.webstart.module.danmu;

import com.joey.webstart.utils.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DanmuServiceImpl implements IDanmuService{
    private List<String> danmuList = new ArrayList<>();
    private String filePath;

    DanmuServiceImpl() {
        try {
            initList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> danmuList() {
        return danmuList;
    }

    @Override
    public void sendDanmu(Danmu danmu) {
        storeDanmu(danmu);
    }

    private void storeDanmu(Danmu danmu) {
        danmuList.add(danmu.blessing);
        // 写入到本地文件中
        FileUtils.writeToFile(filePath, danmu.blessing);
        System.out.println(filePath);
    }

    private void initList() throws FileNotFoundException {
        // 获取本地文件
        String rootPath = FileUtils.getJarRootPath();
        filePath = rootPath + "/blessing.txt";
        danmuList = FileUtils.readFileByLines(filePath);
    }
}
