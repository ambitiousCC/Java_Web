*	TRUNCATE [TABLE] tbl_name;彻底清空数据表：会清楚表中所有记录；重置AUTO_INCREMENT值

*	查询
```SELECT select_expr,... FROM tbl_name
[WHERE 条件]
[GROUP BY {col_naem|position} HAVING 二次筛选]
[ORDER BY {col_naem|position|expr} [ASC|DESC]]
[LIMIT 限制结果集的显示条数]

给表起别名--用于多表查询
SELECT 字段名称,... FROM tbl_name [AS] 别名；

WHERE 会筛选出符合条件的记录

检测NULL值：
WHERE xx<=> NULL;
WHERE xx IS NULL;
=不能检测NULL

指定范围
BETWEEN ... AND ...

NOT BETWEEN .. AND ..

指定集合 IN
不在NOT IN

逻辑运算符
AND 与
OR 或

匹配
[NOT] LIKE
默认忽视大小写
统配
%任意长度
_一个--这个可以用来查询三位字符

GROUP BY
只会看到组中一个信息
配合GROUP_CONCAT() 显示组中对应被函数执行的详细信息
分组时可以使用数字对应SELECT的对象

聚合函数需要GROUP BY
COUNT
如果直接写字段会忽略NULL的字段，而*会统计NULL值
SUM
MAX
MIN
AVG

HAVING
将分组结果再次筛选
...
HAVING COUNT(*) >=3;

ORDER BY
排序 默认升序ASC
ORDER BY id DESC;

随机记录
RAND();
ORDER BY RAND();

LIMIT限制
LIMIT显示结果集的前n条记录
LIMIT n;
显示一个范围，注意偏移量offset从零开始
LIMIT offset,row_count
```

多表查询
```
内连接
SELECT e.id,e.username,e.age,d.depName
FROM emp AS e
INNER JOIN dep AS d
ON e.depId = d.id;

外连接
连接
SELECT e.id,e.username,e.age,e.addr,
d.id,d.depName,d.depDesc
FROM dep AS d
JOIN emp AS e
ON d.id=e.depId;
左连接
SELECT e.id,e.username,e.age,d.depName,d.depDesc
FROM emp AS e
LEFT [OUTER] JOIN dep AS d
ON e.depId = d.id;
右连接：右边的为主表，就是右边的都能看到
SELECT e.id,e.username,e.age,d.depName,d.depDesc
FROM emp AS e
RIGHT [OUTER] JOIN dep AS d
ON e.depId = d.id;

多表可以提高性能


常用函数
数学函数：查询文档
TRUNCATE();//截取小数点后几位
MOD();//取余数
ABS();//取绝对值
POWER();//幂运算
PI();//圆周率
RAND();||RAND(X);//0~1随机数
SIGN(X);//得到数字符号
EXP(X);e的x次方
字符数函数
CHAR_LENGTH();//受到字符类型的影响：得到的是字符串的字符数
LENGTH();//返回字符串长度
CONCAT;//拼接字符串，有NULL返回NULL
CONCAT_WS(x,s1,s2,...)//以指定分割符拼接字符
UPPER();//小写转大写
UCASE();//小写转大写
LOWER();
LCASE();
REVERSE();//字符串反转
LEFT();//前段
RIGHT();//后端
LPAD(str,len,p);//右端填充
RPAD(str,len,p);//左端填充
TRIM();去掉空格
LTRIM();RTRIM();前后
SUBSTRING(STR,START,END);//切割时



