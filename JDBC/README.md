*	遇到问题
>	*	字符编码问题，mysql包和数据库的编码不一样需要加上?useUnicode=true&characterEncoding=utf8

## 程序结构
*	注册驱动防止注册两次``Class.forName("com.mysql.jdbc.Driver");``
*	获得链接：``Connection getConnection(String url,String name,String password);``
*	url写法：
```
jdbc	:协议
mysql:	子协议
localhost:	主机名
3306:	端口号
```
Connection：连接对象
*	执行语句
```
创建对象
Statement createStatement()											:执行SQL语句
PreparedStatement prepareStatement(String sql) 		:预编译解决注入漏洞
CallableStatement prepareCall(String sql)					:执行存储过程

进行事务的管理
setAutoCommit(boolean autoCommit)								:设置事务是否自动提交
commit()																		:事务提交
rollback()																		:事务回滚
```
Statement:	执行SQL语句
*	主要作用
```
boolean execute(String sql)											:执行SQL，执行为真
ResultSet executeQuery(String sql)								:执行SQL中的SELECT
int executeUpdate(String sql)										:执行INSERT/UPDATE/DELETE，返回的是影响的行数
```
*	批处理一起执行语句
```
addBatch(String sql)														:添加到批处理
executeBatch()																:执行
clearBatch()																	:清空
```
ResultSet:		结果集
```
next()																			:移动光标,可以ResuletSet.next()判断是否还有
```
*	资源释放--有最大访问个数：尽量Connection的晚创，早建，把.close()放到finally中

##	CRUD
*	通过执行结果的行数来判断是否成功
*	熟悉了增删改查的用法，注意最优方法：PreparedStatement防止SQL语句渗透，使用数据库连接池提高数据库性能：即使配置不成功也要找其他的办法来使用他
PreparedStatement
prepareStatement

数据库连接池
从连接池中获得的链接与数据库通讯：创建链接消耗大量资源：连接池就会返回链接
*	遇到很多多多问题**尤其是连接池的问题，屁事真多**
>	*	配置.xml文件来设置是为了防止直接修改源码，但是问题太多了；
>>	*	第一个就是&amp;问题，xml文件中不能出现&
>>	*	第二个是版本的问题:当数据库版本过高就需要升级jar包，这个词真尼米高大上，搞得我半天没弄懂，需要就是重新将最新版的的jar导入即可
>	*	我没有解决配置xml文件的问题，报莫名其妙地错误，但是直接set设置属性可以，所以我就不闲麻烦的使用了.properties配置文件，解决









