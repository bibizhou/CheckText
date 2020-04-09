package com.example.checkspamtext.controller;

import com.example.checkspamtext.utils.SensitivewordFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/check")
public class CheckSpamTextController {

    @RequestMapping("/v1/checkText")
    public String checkText(String utext) {
        SensitivewordFilter filter = new SensitivewordFilter();

        Set<String> set = filter.getSensitiveWord(utext, 1);
        if (set.size()>0) {
            return"输入不合法";
        }
        return"输入成功";
    }
}
