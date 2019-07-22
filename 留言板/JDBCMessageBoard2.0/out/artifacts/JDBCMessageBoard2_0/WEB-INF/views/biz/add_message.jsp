<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>新建留言</title>
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../../css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/message/list.do">
                        小奏留言板
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${user.username}!</h1>
                <p>既然来了，就索索话吧</p>
            </div>
            <div class="page-header">
                <h3><small>新建留言</small></h3>
            </div>
            <form class="form-horizontal" action="/addMessage.do" method="post">
                <div class="form-group">
                    <label for="inputTitle" class="col-sm-2 control-label">标题 ：</label>
                    <div class="col-sm-8">
                        <input name="title" class="form-control" id="inputTitle" placeholder="title">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputContent" class="col-sm-2 control-label">内容 ：</label>
                    <div class="col-sm-8">
                        <textarea name="content"  class="form-control" rows="3" id="inputContent" placeholder="Content"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">发布留言</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <a class="btn btn-default" href="/message/list.do">查看留言</a>
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            <div class="container">
                <a href="https://github.com/ambitiousCC" target="_blank"  style="cursor: pointer"><button>小奏先生的传送门</button></a>
            </div>
        </footer>
    </body>
</html>
