package com.jt.service;
import com.jt.vo.ImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@Service
public class FileServiceImpl implements FileService {
    private String localDir = "/usr/local/src/images";
    private String urlPath = "http://image.jt.com";

    @Autowired
    private FileService fileService;


    @Override
    public ImageVo upload(MultipartFile file) {
        //xxxxxx.jpg|png|gif|  防止大小写的问题，将所有的字母转化为小写
        String fileName = file.getOriginalFilename().toLowerCase();//到这全部小写
        if (!fileName.matches("^.+\\.(jpg|png|gif)$")) {
            //如果校验不通过，则终止程序
            return null;
        }


        System.out.println("图片的类型是正确的！！！");
        //第二部  防止恶意程序判断图片是否有宽度和高度
        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            System.out.println("用户上传的图片是图片");
            //第三步：目录如何划分  yyyy/mm/dd
            String dateDir =
                    new SimpleDateFormat("/yyyy/MM/dd/")
                            .format(new Date());
            //生成新的文件的名称
            String dirPath = localDir + dateDir;
            File dirFile = new File(dirPath);
            if (!dirFile.exists()) {   //创建目录
                //如果我们的目录不存在时，就要创建目录
                dirFile.mkdirs();

            }
            //第四部：使用UUID实现文件的名称  UUID。jpg
            //4.1生成UUID
            String uuid = UUID.randomUUID().toString().replace("-", "");
            int index = fileName.lastIndexOf(".");
            String fileType = fileName.substring(index);
            String newFile = uuid + fileType;
            //第五步：实现文件的上传   全文件的全路径的上传

            String path = dirPath + newFile;
            file.transferTo(new File(path));
            System.out.println("文件上传成功!!!");

            //第六步返回ImageVo的数据
            //6.1虚拟路径只写动态变化的数据   /2021/11/11/uuid.jpg
            String virtualPath = dateDir + newFile;

            //6.2真实的图片名称
            String fileNameVo = newFile;
            //6.3网络地址          http://image.jt.com/xx/uuid.jpg

            String url = urlPath + virtualPath;
            System.out.println(url);
            return new ImageVo(virtualPath, url, fileNameVo);


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    /*
     * 1.准备全文件的路劲
     * 2.实现文件的删除
     * */

    @Override
    public void deleteFile(String virtualPath) {
        String path = localDir + virtualPath;
        File file=new File(path);
        if (file.exists()){
            //如果文件存在则删除文件
            file.delete();

        }
    }

}
