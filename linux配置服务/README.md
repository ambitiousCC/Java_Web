位于
/etc/profile文件
配置
井号代表注释
配置如下
```
JAVA_HOME=/存放jdk的路径
CLASSPATH=.:$JAVA_HOME/lib
PATH=$PATH:$JAVA_HOME/bin

export JAVA_HOME CLASSPATH PATH
```
需要source profile命令导入配置到系统
查看tomcat是否在进行中
ps -ef|grep tomcat


webapps下面是.war包移动的地方
先设置读写权限
然后在/bin目录下面通过
./start.sh
启动
可以查看状态
.war会自动解压
然后可以访问项目路径
http://localhost:8080/项目名/index














