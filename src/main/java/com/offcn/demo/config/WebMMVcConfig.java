package com.offcn.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMMVcConfig  implements WebMvcConfigurer {
 /*
 静态资源分为默认路劲如：static public resource
 还有自定义静态资源访问：也就是不在这几个目录下的还要访问静态资源
 自定义的方式有两种，第一种就是下面的通过编写一个类的使用代码进行访问指定
                   第二只通过配置文件 默认会读取的配置文件为application文件
    场景：一个网站有文件上传的功能，若被上传的文件放在上述的那些文件夹中会有怎样的后果？
    网站数据与程序代码不能有效分离；
    当项目被打包成一个.jar文件部署时，会将目录中的文件也一并打包， 会造成很低的效率；
    网站数据的备份将会很痛苦。
    此时较好的解决办法是将静态资源路径设置到磁盘的基本个目录。*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //将所有D:\\springboot\\pic\\ 访问都映射到/myPic/** 路径下
        // registry.addResourceHandler("/myPic/**").addResourceLocations("file:D:\\springboot\\pic\\");
        registry.addResourceHandler("/myPic/**").addResourceLocations("file:/Users/travelround/Desktop/springboot/pic2/");
    }
}
