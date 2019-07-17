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
 * ��֤�빤����
 */
public class captcahCode {
    /**
     * ������֤��
     * @param response
     * @return
     */
    public static String drawImage(HttpServletResponse response) {
        //ƴ���ַ���
        StringBuilder builder = new StringBuilder();
        //׼�������
        for (int i = 0; i < 4; i++) {
            builder.append(randomChar());
        }
        String code = builder.toString();

        //����ͼƬ�Ŀ�Ⱥ͸߶�
        int width = 120;
        int height = 25;

        //��������������ָ��ͼƬ�ĳ��ȺͿ���Լ�ɫ��
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        //��ȡ�������������֤��
        Graphics2D g = bi.createGraphics();

        //��������ʹ�С
        Font font = new Font("΢���ź�", Font.PLAIN, 20);

        Color color = new Color(0, 0, 0);
        //��������
        g.setFont(font);
        //color
        g.setColor(color);
        //���ñ���
        g.setBackground(new Color(226, 226, 240));
        //��ʼ���ƶ���
        g.clearRect(0, 0, width, height);
        //���ƾ��ζ���
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        //�����ļ�������ͼ��
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        //��������
        g.dispose();
        //
        try {
            ImageIO.write(bi, "jpg", response.getOutputStream());
            //ˢ����Ӧ��
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * �������ʽ����֤��
     * ������ֵĲ���
     * ��ɫ���
     * ���������
     * @return
     */
    public static String drawImageVerificate(HttpServletResponse response) {
        //������֤��Ŀ�Ⱥ�����
        int width = 100, height = 30;
        //���ڴ��д���ͼƬ
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //����ͼƬ������
        Graphics2D g = image.createGraphics();
        //��������������������Ҫ�����������ʽ������
        Random random = new Random();
        //���ñ���
        g.setColor(getRandomColor(240, 250));
        //��������
        g.setFont(new Font("΢���ź�", Font.PLAIN, 22));
        //��ʼ����
        g.fillRect(0, 0, width, height);
        //��������
        g.setColor(getRandomColor(180, 230));
        //��Ҫ����ͼƬ��
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(60);
            int y1 = random.nextInt(60);
            //���Ƹ����ߣ�������
            g.drawLine(x, y, x1, y1);
        }

        //��ʼ���ж�������֤����ʽ��ƴ��
        //ע�⣬Math.random()��������0-1��С��*10��Զ��0
        int num1 = (int) (Math.random() * 10 + 1);
        int num2 = (int) (Math.random() * 10 + 1);
        int fuhao = random.nextInt(3);
        //��¼����
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
            //ûӴ��������Ϊ���Ѽ���
        }

        //ƴ���������ʽ
        String calc = num1 + "" + fuhaostr + "" + num2 + " = ?";
        //���������ɫ
        g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
        //���Ʊ��ʽ
        g.drawString(calc,5,25);
        //��������
        g.dispose();
        try {
            //���
            ImageIO.write(image, "JPEG", response.getOutputStream());
            return String.valueOf(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Color getRandomColor(int fc, int bc) {
        Random random = new Random();
        //�����ɫ
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
        //�������ֺ���ĸ
        String string = "1234567890qwertyuiopasdfghjklzxcvbn";
        //random:�����������
        Random random = new Random();
        //�ڷ�Χ�ڽ���
        return string.charAt(random.nextInt(string.length()));
    }
}
