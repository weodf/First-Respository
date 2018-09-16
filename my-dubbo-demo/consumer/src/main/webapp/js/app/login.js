function login() {
    $.ajax({
        type: 'post', //默认get
        url: "/user/login.do",
        data:$("#form1").serialize(),//关于序列化
        async: true,   //是否异步（默认true：异步）
        dataType: "json",//定义服务器返回的数据类型
        success: function (data) {//data服务器返回的json字符串
            if (data.success) {
                window.location.href="/index.html"
            } else {
                alert(data.errorMsg)
            }

        }
    });
}