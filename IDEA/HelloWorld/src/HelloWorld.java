public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
        String info = getInfo();
        test();
    }
    //常用的快捷键：shift+ctrl+enter
    //shift+ctrl+space
    //shift+ctrl+F10
    //常用短语sout=System.out.println
    //fori=for(int i = ; i < ; i++){}

    public static String getInfo() {
        return "sdf";
    }

    public static void test() {
        for (int i = 0; i < 12; i++) {
            System.out.println("hello IDEA");
        }
    }
}
