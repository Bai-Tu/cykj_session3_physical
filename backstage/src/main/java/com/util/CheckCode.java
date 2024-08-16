package com.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;


/*
* 验证码
* */
public class CheckCode {


    public String convertImageToBase64(BufferedImage image) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image,"png",baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public String generateCode(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // 生成数字
        }
        return sb.toString();
    }

    public BufferedImage createImage(String code) {
        int width = 120, height = 40;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // 设置背景颜色和文字颜色
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));

        // 将验证码绘制到图片中
        int x = 20;
        for (int i = 0; i < code.length(); i++) {
            g2d.drawString(code.substring(i, i + 1), x, 28);
            x += 20;
        }

        // 释放图形上下文使用的系统资源
        g2d.dispose();

        return image;
    }
}