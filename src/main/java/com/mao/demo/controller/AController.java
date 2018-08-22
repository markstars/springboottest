package com.mao.demo.controller;


import com.mao.demo.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 豪
 * @date 2018/8/19 14:17
 */
@RestController
@Api("刚刚")
@RequestMapping("/A")
public class AController {
    @ApiOperation(value = "helo", notes = "返回hello world")
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "Hello World!";
    }

    @ApiOperation(value = "map", notes = "返回一个map")
    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public Map<String,String> index2(@RequestParam String name) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", name);
        map.put("value", "hello world!");
        return map;
    }

    @ApiOperation(value = "user", notes = "返回一个user")
    @RequestMapping(value = "/index3/{id}/{name}", method = RequestMethod.GET)
    public User index3(@PathVariable int id,@PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setData(new Date());
        return user;
    }
}
