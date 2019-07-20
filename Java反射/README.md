*	反射
>	运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
对于任意一个UI想，都能够调用它的任意方法和属性；
这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制
>	通过jvm中的classload将.class文件加入生成一个class对象，
然后再次获得进一步内容比如
Constructor方法(构造)、Field(属性)、Method(执行)
>	用来编写一些通用性较高的代码或者框架的时候使用
>>	*	已知类(.class)和对象(.getClass--Object类提供)的情况下
>>	*	未知Class.forName("报名.类名")(最常用)
>	Class类
>>	*	Class类代表某个类的字节码，提供了加载字节码的方法：
上面的forName方法用于加载类字节码到内存中，并封装成一个Class对象
>>	Class类的实例表示正在运行的Java应用程序中的雷和接口
```
Class c = Class.forName("XX.XX");
XX xx = (XX)c.newInstance();//实例化
```
>	Constructor类
>>	Constructor类的实例对象代表类的一个构造方法
**是关于类的单个构造方法的信息以及对应的访问权限**
>>	并且获得的是数组对象
```
//上下代码相接
Constructor[] c = Class.forName("").getConstructors();//有参数的直接传入参数类型比如.getConstructors(String.class)
String str = (String)constructor.newInstance(str);
//newInstance()方法用来调用类的默认构造方法
```
>	Field类
>>	代表某一个类中的成员变量，并提供动态的访问权限
```
Field[] fields = c.getFields();//未传参就是获得所有public属性包括父类继承，传参就是获得指定的成员变量.getFields("name");
Field[] fields = c.getDeclaredFieldes();//取得所有声明、这个方法无视私有和公有
//设置私有属性能否访问，所以在访问前需要设置一下
field.setAccessible(boolean);
//变量值的读取设置
field.get(obj)
//p.name="";相当于obj=p是一个实例;name是赋值，有点点逻辑不对。
field.set(obj,value)
```
>>	重要的就是**反射私有的属性**
>Method类
>>	Method类代表的是某个类中的一个成员方法
>>	Method对象的获得
```
//所有
getDeclaredMethodes()
getMethods()
//指定name是方法名，后面是参数类型
getDeclaredMethodes(String name,Class<?>...parameterTypes)
getMethods(String name,Class<?>...parameterTypes)
//反射执行：前面的obj也是一个实例需要传入对象，后面的是执行参数没有传null
invoke(Object obj,Object ....args)
```
**别忘记设置访问权限**


