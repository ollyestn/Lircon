package com.taiji.Lircon.controller;

import com.taiji.Lircon.service.Model3dBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 基础3d模型表 前端控制器
 * </p>
 *
 * @author cao shunmao
 * @since 2024-03-16
 */
@RestController
@RequestMapping("/model3dBase")
public class Model3dBaseController {
    @Autowired
    private Model3dBaseService model3dBaseService;

    // controller的实现都得自己写
    @RequestMapping("/GetAll")
    public String GetAll() {
        return "model3dBase/index";
    }
}
