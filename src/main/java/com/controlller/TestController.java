package com.controlller;

import com.google.common.collect.Maps;
import com.ro.TestRo;
import com.vo.TestVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @PostMapping("testInteger")
    Integer testInteger(Integer a, Integer b) {
        return a + b;
    }

    @PostMapping("testMap")
    Map<String, String> testMap(@RequestParam Map<String, Integer> paramMap) {
        Map<String, String> result = Maps.newHashMap();
        for (Map.Entry<String, Integer> entry : paramMap.entrySet()) {
            result.put(String.format("Key:%s", entry.getKey()), String.format("Value:%s", entry.getValue()));
        }
        return result;
    }

    @PostMapping("testVo")
    TestRo testVo(@RequestBody TestVo vo) {
        TestRo ro = new TestRo();
        ro.setKey(String.format("Key:%s", vo.getKey()));
        ro.setValue(String.format("Value:%s", vo.getValue()));
        return ro;
    }

    @PostMapping("testList")
    List<String> testList(@RequestParam("paramList") List<String> list) {
        return list;
    }
}
