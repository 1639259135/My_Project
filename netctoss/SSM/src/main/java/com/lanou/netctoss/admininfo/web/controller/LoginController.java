package com.lanou.netctoss.admininfo.web.controller;

import com.lanou.netctoss.admininfo.domain.AdminInfoExt;
import com.lanou.netctoss.admininfo.service.AdminInfoService;
import com.lanou.netctoss.util.ImageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RequestMapping(value = "/login")
@Controller
public class LoginController {

    @Resource
    private AdminInfoService adminInfoService;


    @ResponseBody
    @RequestMapping(value = "/login")
    public AdminInfoExt login(AdminInfoExt adminInfoExt, HttpSession session){
        AdminInfoExt adminByAdminCode = adminInfoService.findAdminByAdminCode(adminInfoExt,session);
        session.setAttribute("loginAdmin",adminByAdminCode);
        return adminByAdminCode;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "../../login";
    }

    @RequestMapping(value = "/createImg")
    public void createImg(HttpSession session, HttpServletResponse response) throws IOException {
        Object[] image = ImageUtils.createImage();
        session.setAttribute("imgCode",image[0]);
        System.out.println("image:"+image[0]);
        BufferedImage img = (BufferedImage) image[1];
        response.setContentType("d:/1.jpg");
        OutputStream os = response.getOutputStream();
        ImageIO.write(img, "jpeg", os);
        os.close();
    }


}
