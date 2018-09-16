var app = new Vue({
    el: '#app',
    data: {
        movie: {},
        showDays: [],
        showTimes: []
    },
    methods: {
        toBuyTicket: function (id) {
            window.location.href = '/buyticket.html?id=' + id;
        }
    },
    created: function () {
        //获取页面传值
        var id = UrlParam.param("id");
        $.ajax({
            type: 'post', //默认get
            url: "/api/movie/info.do",
            data: {id: id},
            async: true,   //是否异步（默认true：异步）
            dataType: "json",//定义服务器返回的数据类型
            success: function (data) {//data服务器返回的json字符串
                if (data.success) {
                    app.movie = data.data;
                } else {
                    alert(data.errorMsg)
                }

            }
        });


        //请求放映日期
        $.ajax({
            type: 'post', //默认get
            url: "/api/movie/ticket.do",
            data: {id: id},
            async: true,   //是否异步（默认true：异步）
            dataType: "json",//定义服务器返回的数据类型
            success: function (data) {//data服务器返回的json字符串
                if (data.success) {
                    app.showDays = data.data;
                } else {
                    alert(data.errorMsg)
                }

            }
        });


        //请求放映时间段
        $.ajax({
            type: 'post', //默认get
            url: "/api/movie/listShowTime.do",
            data: {id: id},
            async: true,   //是否异步（默认true：异步）
            dataType: "json",//定义服务器返回的数据类型
            success: function (data) {//data服务器返回的json字符串
                if (data.success) {
                    app.showTimes = data.data;
                } else {
                    alert(data.errorMsg)
                }

            }
        });

    }
});
