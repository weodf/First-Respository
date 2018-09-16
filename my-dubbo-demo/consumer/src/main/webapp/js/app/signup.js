
var app = new Vue({
    el: '#app',
    data: {

    },

    methods: {

        getValiCode:function  () {


            $("#btn_sendcode").attr('disabled', 'disabled').html('发送中');

            //请求获取验证码
            var loginName = $("#loginName").val();
            if (!loginName){
                alert("请输入邮箱");
                return;
            }
            $.ajax({
                type: 'post', //默认get
                url: "/user/getValiCode.do",
                data: {'loginName': loginName},
                async: true,   //是否异步（默认true：异步）
                dataType: "json",//定义服务器返回的数据类型
                success: function (data) {//data服务器返回的json字符串
                    if (data.success) {
                        app.codeCont(10);//读秒
                    } else {
                        alert(data.errorMsg)
                    }

                }
            });

        },
        codeCont: function (c) {

            if (c === 0) {
                $("#btn_sendcode").removeAttr('disabled').html('发送验证码');
                return;
            }

            $("#btn_sendcode").html(c--);

            setTimeout(function () {
                app.codeCont(c);
            }, 1000);
        },


        signup:function () {

            //进入注册阶段
            var loginName = $("#loginName").val();

            $.ajax({
                type: 'post', //默认get
                url: "/user/signup.do",
                data: $("#form1").serialize(),
                async: true,   //是否异步（默认true：异步）
                dataType: "json",//定义服务器返回的数据类型
                success: function (data) {//data服务器返回的json字符串
                    if (data.success) {
                        alert("注册成功");
                    } else {
                        alert(data.errorMsg)
                    }

                }
            });


        }
    }

});
