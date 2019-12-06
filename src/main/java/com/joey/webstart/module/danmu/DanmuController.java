package com.joey.webstart.module.danmu;

import com.joey.webstart.common.CommonEmptyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blessing")
public class DanmuController {
    private final IDanmuService service;

    @Autowired
    public DanmuController(IDanmuService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<String> danmuList() {
        return service.danmuList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public CommonEmptyResponse sendDanmu(@RequestBody Danmu danmu) {
        service.sendDanmu(danmu);
        return null;
    }
}
