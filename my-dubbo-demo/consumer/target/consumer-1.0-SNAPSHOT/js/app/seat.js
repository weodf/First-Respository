var app = new Vue({
    el: '#app',
    data: {
        movie: {},
        selectedSeats: [],
        soldSeats: [],
        ticketInfo: {}
    },

    watch: {//侦听器（侦听unavailableSeats属性变化，即执行）
        // 如果 `question` 发生改变，这个函数就会运行
        soldSeats: function (newValue, oldValue) {
            $.each(newValue, function (index, value) {
                $("#" + value).removeClass("available").addClass("unavailable");//改成已售出
            })
        }
    },

    methods: {
        formatSeat: function (val) {
            var strs = val.split('_');
            return strs[0] + '排' + strs[1] + '列';
        },

        selectSeats: function (event) {
            var currentTargetDom = event.currentTarget;
            // var id = currentTargetDom.getAttribute("id");
            // this.selectedSeats.push(id);


            var jquery_currentTargetDom = $(currentTargetDom);//将原生js对象转为jquery对象
            var id = jquery_currentTargetDom.attr("id");//获取id属性

            if (this.soldSeats.includes(id)) {
                return;
            }

            if (!this.selectedSeats.includes(id)
            ) {
                jquery_currentTargetDom.removeClass("available").addClass("selected");//改成选中
                this.selectedSeats.push(id);//向数组尾部添加
            }
            else {
                jquery_currentTargetDom.removeClass("selected").addClass("available");//改成选中
                this.selectedSeats.splice(this.selectedSeats.indexOf(id), 1);//删除指定元素
            }
        },

        listSaledSeats: function (){
            var showTimeId = UrlParam.param("showTimeId");
            $.ajax({
            type: 'post',
            url: "/api/movie/unavaliableSeat.do",
            data: {showTimeId: showTimeId},
            async: true,
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    app.soldSeats = data.data;

                } else {
                    alert(data.errorMsg)
                }
            }
        })
},



    confirmBuy: function () {
    var showTimeId = UrlParam.param("showTimeId");
    $.ajax({
        type: 'post', //默认get
        url: "/api/order/confirmBuy.do",
        data: {
            movieId: this.movie.id,
            showTimeId: showTimeId,
            selectedSeats: this.selectedSeats
        },
        async: true,   //是否异步（默认true：异步）
        dataType: "json",//定义服务器返回的数据类型
        success: function (data) {//data服务器返回的json字符串
            if (data.success) {
                $("#app").html(data.data);
            } else {
                alert(data.errorMsg)

                if (data.errorCode === 600) {
                    //跳转到登录页面
                    window.location.href = "/login.html";
                }

                app.listSaledSeats();

                //清空已选择座位
                app.selectedSeats = [];
            }

        }
    });
}
},


mounted: function () {

    var showTimeId = UrlParam.param("showTimeId");

    this.listSaledSeats();


    //获取已售出的座位
    $.ajax({
        type: 'post',
        url: "/api/movie/unavaliableSeat.do",
        data: {showTimeId: showTimeId},
        async: true,
        dataType: "json",
        success: function (data) {
            if (data.success) {
                // app.soldSeats = data.data;
                // alert(app.soldSeats);
                // $.each(data.data, function (index, value) {
                //     $("#" + value).removeClass("available").addClass("unavailable");//改成已售出
                // });
                app.soldSeats = data.data;

            } else {
                alert(data.errorMsg)
            }
        }
    });

    //获取播放时间及其地点的详细信息
    $.ajax({
        type: 'post',
        url: "/api/order/ticketinfo.do",
        data: {showTimeId: showTimeId},
        async: true,
        dataType: "json",
        success: function (data) {
            if (data.success) {
                // app.soldSeats = data.data;
                // alert(app.soldSeats);
                // $.each(data.data, function (index, value) {
                //     $("#" + value).removeClass("available").addClass("unavailable");//改成已售出
                // });
                app.ticketInfo = data.data;

            } else {
                alert(data.errorMsg)
            }
        }
    });

    //获取电影信息
    $.ajax({
        type: 'post',
        url: "/api/movie/selectMovieBySTID.do",
        data: {showTimeId: showTimeId},
        async: true,
        dataType: "json",
        success: function (data) {
            if (data.success) {
                // app.soldSeats = data.data;
                // alert(app.soldSeats);
                // $.each(data.data, function (index, value) {
                //     $("#" + value).removeClass("available").addClass("unavailable");//改成已售出
                // });
                app.movie = data.data;

            } else {
                alert(data.errorMsg)
            }
        }
    });


}



});


