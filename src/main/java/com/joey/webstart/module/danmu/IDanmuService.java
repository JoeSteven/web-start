package com.joey.webstart.module.danmu;

import java.util.List;

public interface IDanmuService {
    List<String> danmuList();
    void sendDanmu(Danmu danmu);
}
