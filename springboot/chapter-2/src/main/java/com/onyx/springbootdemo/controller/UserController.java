package com.onyx.springbootdemo.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "User Service", tags = {"用户模块"})
@RestController
public class UserController {
    @ApiOperation("helloGet方法")
    @ApiImplicitParams(@ApiImplicitParam(name = "username", value = "名字", required = true))
    @GetMapping("/helloGet")
    public String helloGet(String username) {
        // another way
        // public String helloGet(@RequestParam("username") @ApiParam("用户名") String username) {
        return "hello: " + username;
    }

    @ApiOperation("helloPost方法")
    @PostMapping("/helloPost")
    public String helloPost(@RequestBody UserVO userVO) {
        return "hello: " + userVO.getUserName();
    }
}

@ApiModel(description = "用户实体类")
class UserVO {
    @ApiModelProperty("用户名")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
