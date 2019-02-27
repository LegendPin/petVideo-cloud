package io.renren.common.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UploadUtils {


    public  static String saveFile(String commonPath, String identity, MultipartFile file){
        //文件名
        String filename = file.getOriginalFilename();
        String basePath = commonPath +"/" + identity +"/";
        String tempname= new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date());       //创建文件路径
        //获取文件后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        tempname += suffix;
        //String retPath = "/renren-fast/static/"+ identity +"/" + tempname;
        //获取绝对路径
        File tempFile = new File(basePath);
        String absFilePath = tempFile.getAbsolutePath() + "/" + tempname;

        //创建文件，注：使用transferTo，采用绝对路径
        File desFile = new File(absFilePath);
        File fileParent = desFile.getParentFile();

        try {
            //判断文件夹是否存在
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            //创建文件
            if (!desFile.exists()) {
                desFile.createNewFile();
            }
            //储存文件
            return basePath+tempname;            //返回文件路径URL,不带盘符
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
