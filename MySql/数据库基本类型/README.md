**my.ini是MySql是配置文件**
基本语法：已经学过了
顺便总结一下
```
登录
mysql -uroot -ppassword/mysql -uroot -p
退出
\q/quit/exit
 输出版本
mysql -uroot proot -V/version
登录就打开指定数据库
mysql -uroot -p -D databseName
select version();
select now()\g
\c可以取消当前命令执行
```
>	可以通过help或者\h
*	常用sql语句
```
select user();//得到登录用户
select version();//版本
select now();//当前日期时间
select database()//当前的日期时间
```
**关键名我们要大写，库名、表名、字段名称使用小写--为了跨平台**
(可以折行操作)
*	创建
```
CREATE DATABASE [IF NOT EXISTS] db_name;
**名称最好有意义**
SHOW DATABASES;/SHOW SHEMAS;
SHOW WARNINGS;//查看warings
CREATE DATABASE [IF NOT EXISTS] db_name DEFAULT CHARACTER SET [=] charset;//单引号
查看数据库的详细信息
SHOW CREATE DATABASE db_name;
修改指定数据库的编码方式
ALTER DATABASE db_name [DEFAULT] CHARACTER SET [=] charset;
打开数据库
USE db_name;
得到当前打开的数据库
SELECT DATABASE();
删除
DROP DATABASE [IF EXISTS] db_name;
```
*	注释方法
# 注释内容
--	注释内容

*	数据表是数据库的最重要的组成部分之一
*	数据表有行和列来组成
*	每个数据表中至少有一列，行可以有零行或者多行
*	表名要求唯一

*	创建数据表
```
CREATE TABLE [IF NOT EXISTS] tbl_name(
	字段名称 字段类型 [完整性约束条件],
	...
)ENGINE=存储引擎 CHARSET=字符类型;
查看表
SHOW [FULL] TABLES [{FROM|IN} db_name] [LIKE 'pattern'|WHERE expr]
SHOW CREATE TABLE tbl_name;
数据库详细信息
DESC tbl_name;
DESCRIBE tbl_name;
SHOW COLUMNS FROM tbl_name;
```
 *	约束条件
 >	unsigned 无符号
 >	zerofill 零填充
 >	NOT NULL 非空
 >	DEFAULT 默认值
 >>	可以直接指定默认值
 >PRIMARY KEY 主键，唯一性
 >>	复合主键primary key(a,b) 相当于主键形式 a-b
 >	UNIQUE [KEY] 一个表中可以是唯一的索引值
 >>	NULL不算重复，
 >	AUTO_INCREMENT 自动增长
 >>	对象可以设置为null,default但是不能为空''
 >>	一般与key组合使用
 >	FOREIGN KEY 外键约束
 >	COMMENT表示列名指定
**不是单引号而是反引号**
```
插入语句
INSERT [INTO] tbl_name(id,username,...) VALUES(1,'KING',...);
查询所有记录
SELECT * FROM tbl_name;
```
*	CHAR效率高于VARCHAR,CHAR相当于拿空间换时间，VARCHAR拿时间换空间：
*	CHAR默认存储数据的时候，后面会用空格填充到指定长度；而在检索的时候会去掉后面的空格；
*	VARCHAR则不会进行填充，尾部的空格会留下
```
*	枚举
ENUM('','',...)//只能从枚举值中选择，编号从1开始，自动过滤掉字符串中的空格，并且会循环数字65535
*	集合
SET('','',...)//同样可以按照编号来写
```
注意：**枚举和集合都只会插入已经定义的类型**TEXT列不能有默认值，检索的时候不存在大小写转换
对于日期格式
```
TIME
D HH:MM:SS D表示天数0~34
//默认插入从尾部开始，增加空格表示前面的数字代表的是天数
HHMMSS
//可以利用函数比如now()插入当前时间
DATE
YYYY-MM-DD YYYYMMDD
YY-MM-DD YYMMDD
YY:70~99:19;00~69:20
DATETIME
YYYY-MM-DD HH:MM:DD
YYYYMMDDHHMMDD
TIMESTAMP
CURRENT_TIMESTAMP
NULL或者什么都不写会得到当前系统的时间
YEAR
1901~2155
0插入的是0000
```

*	表结构的操作
```
ALTER TABLE tbl_name ADD 字段名称 字段属性 完整性约束条件 [AFTER|FIRST] 字段名称
ALTER TABLE tbl_name DROP zid字段名称
```
*	默认值
```
ALTER TABLE tbl_name ALTER 字段名称 ALTER 字段名称 SET DEFAULT 默认值;
ALTER TABLE tbl_name ALTER 字段名称 DROP DEFAULT;
```
*	动态修改字段类型和字段属性
```
ALTER TABLE tbl_name 
MODIFY 字段名称 字段类型 [字段属性] [FIRST|AFTER ] 字段名称
//没写的属性就去掉了
```
*`修改字段名称字段类型字段属性
```
ALTER TABLE tbl_name
CHANGE 原字段名称 新字段名称 字段类型 字段属性 [FIRST|AFTER ]字段
```
*	添加主键
>	ALTER TABLE 表名 ADD PRIMARY KEY();

*	删除主键
```
先去掉AUTO_INCREMENT
ALTER TABLE 表名 DROP PRIMARY KEY;
```
*	添加唯一性
```
ALTER TABLE tbl_name 
ADD UNIQUE KEY|INDEX [index_name](字段名称)--没有指明索引名称就会自动设置为字段名称
```
*	删除唯一性
```
ALTER TABLE tbl_name
DROP index_name;
```
*	修改数据表名称
```
ALTER TABLE tbl_name name 
RENAME [TO|AS] new_tbl_name

RENAME TABLE tbl_name TO new_tbl_name
```
*	存储引擎
MYISAM(5.5之前)
默认的表会在磁盘中产生3个文件
*	.frm表结构文件
*	.MYD数据文件
*	.MYI索引文件

>	可以在创建表的时候指定数据文件和索引文件的索引位置，只有这家伙支持
```
DATA DIR ECORY [=] 
INDEX DIR ECORY [=] 索引文件保存的绝对路径
```
*	最大的单标的数据量为2^64
*	每个表最多可以建立64个索引
*	如果是符合索引，每个索引最多包含16个列，索引值最大长度是1000B
对于存储格式：
*	(静态FIXED)定长--字段中不包含VARCHAR/TEXT/BLOB 速度最快
*	动态DYNAMIC--只要包含了上面的就是动态
*	压缩COMPRESSED--myisampack创建
*	InnoDB
*	设计遵循ACID模型，支持事务，具有从服务崩溃中恢复的能力，最大限度的保护用户的数据
*	支持行级锁，可以提升多用户并发时的读写性能
*	支持外键，保持数据的一致性和完整性
*	拥有自己独立的缓冲池，冲用的数据和索引都在缓存中
*	对于INSERT UPDATE DELETE 会有一种机制自动优化，大大提高性能
*	会产出
>	*	.frm表结构文文件
>	*	.ibd数据和索引存储到表空间中
>	*	**所有的表都需要创建主键，最好配合自动增长集合，放到经常查询的健作为主键**









