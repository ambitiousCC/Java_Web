public class Persion {
    //对文件名shift+f6 都可以起到全局替换的作用
    //对属性shift+f6
    String name;
    int id;

    //在类里面使用alt+insert：直接选择方法如toStirng
    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    //psvm主程序
    public static void main(String[] args) {
        Persion user = new Persion();
        user.name = "cc";
        user.id = 22;
        System.out.println(user);
    }

    //在方法体中选中部分代码ctrl+alt+m可以抽取重构一个独立方法
    public void print() {
        myMethod();
    }

    private void myMethod() {
        //直接抽取woc
        //重构方法md
        System.out.println("hello world");
        System.out.println("hello world");
    }
}
