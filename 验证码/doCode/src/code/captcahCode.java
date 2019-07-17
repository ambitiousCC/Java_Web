package code;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 * 验证码工具类
 */
public class captcahCode {
    /**
     * 数字验证码
     * @param response
     * @return
     */
    public static String drawImage(HttpServletResponse response) {
        //拼接字符串
        StringBuilder builder = new StringBuilder();
        //准备随机数
        for (int i = 0; i < 4; i++) {
            builder.append(randomChar());
        }
        String code = builder.toString();

        //定义图片的宽度和高度
        int width = 120;
        int height = 25;

        //简历缓冲流对象，指定图片的长度和宽度以及色彩
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        //获取到绘制类绘制验证码
        Graphics2D g = bi.createGraphics();

        //设置字体和大小
        Font font = new Font("微软雅黑", Font.PLAIN, 20);

        Color color = new Color(0, 0, 0);
        //设置字体
        g.setFont(font);
        //color
        g.setColor(color);
        //设置背景
        g.setBackground(new Color(226, 226, 240));
        //开始绘制对象
        g.clearRect(0, 0, width, height);
        //绘制矩形对象
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        //计算文件的坐标和间距
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        //结束绘制
        g.dispose();
        //
        try {
            ImageIO.write(bi, "jpg", response.getOutputStream());
            //刷新响应流
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 算数表达式的验证码
     * 随机数字的产生
     * 颜色随机
     * 随机干扰线
     * @return
     */
    public static String drawImageVerificate(HttpServletResponse response) {
        //定义验证码的宽度和亮度
        int width = 100, height = 30;
        //在内存中创建图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //创建图片上下文
        Graphics2D g = image.createGraphics();
        //产生随机对象，随机对象主要用于算数表达式的数字
        Random random = new Random();
        //设置背景
        g.setColor(getRandomColor(240, 250));
        //设置字体
        g.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        //开始绘制
        g.fillRect(0, 0, width, height);
        //绘制线条
        g.setColor(getRandomColor(180, 230));
        //不要超过图片呢
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(60);
            int y1 = random.nextInt(60);
            //绘制干扰线！！！！
            g.drawLine(x, y, x1, y1);
        }

        //开始进行对算是验证码表达式的拼接
        //注意，Math.random()产生的是0-1的小数*10永远是0
        int num1 = (int) (Math.random() * 10 + 1);
        int num2 = (int) (Math.random() * 10 + 1);
        int fuhao = random.nextInt(3);
        //记录符号
        String fuhaostr = "";
        int result = 0;
        switch (fuhao) {
            case 0:
                fuhaostr = "+";
                result = num1 + num2;
                break;
            case 1:
                fuhaostr = "-";
                result = num1 - num2;
                break;
            case 2:
                fuhaostr = "*";
                result = num1 * num2;
                break;
            //没哟除法是因为很难计算
        }

        //拼接算数表达式
        String calc = num1 + "" + fuhaostr + "" + num2 + " = ?";
        //设置随机颜色
        g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
        //绘制表达式
        g.drawString(calc,5,25);
        //结束绘制
        g.dispose();
        try {
            //输出
            ImageIO.write(image, "JPEG", response.getOutputStream());
            return String.valueOf(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Color getRandomColor(int fc, int bc) {
        Random random = new Random();
        //随机颜色
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            fc = 255;
        }

        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static char randomChar() {
        //定义数字和字母
        String string = "1234567890qwertyuiopasdfghjklzxcvbn";
        //random:定义随机对象
        Random random = new Random();
        //在范围内进行
        return string.charAt(random.nextInt(string.length()));
    }
}
