function test_index() {
    $("#spanone").html(sessionStorage.getItem("username")+",&nbsp;&nbsp;");
    $.get("http://localhost:8080/selectByHot",function (data) {
        console.log(data);
        $.each(data.articles,function (index,item) {
            // console.log("++++++" + item.goods_name);
            $(".pro_list:first").append(

                "<li data-id='" + item.goods_id + "'>" +
                    "<a href='#'>" +
                        "<div class='pro_pic'>" +
                            "<img src='" + item.file_id + "'/>" +
                            "<p class='pro_title'>" + item.goods_name + "</p>" +
                        "</div>" +
                        "<div class='pro_info'>" +
                            "<span class='xj'>￥" + item.price +
                                "<span class='yj'>￥" + item.discount + "</span>" +
                            "</span>" +
                            "<span class='sczg'></span>" +
                        "</div>" +
                    "</a>" +
                "</li>"
            );

            $(".fl_list li").each(function () {
                $(this).click(function () {
                    console.log(this.dataset.type);
                    sessionStorage.setItem("type",this.dataset.type);
                    // window.location="pro_list.html"
                    window.location="http://localhost:8080/pro_list"
                })
            });

            $(".pro_list:first li").on("click",function () {
                console.log("dddddd"+sessionStorage.goods_id);
                sessionStorage.goods_id=this.dataset.id;
                // window.location="pro_detail.html"
                window.location="http://localhost:8080/pro_detail"
            })
        });

    });
    $(".nav_dd a").click(function () {
        if (sessionStorage.getItem("username")==null){
            alert("请先登录");
        }else {
            window.location="http://localhost:8080/wddd"
        }
    });
}

function test_detail() {
    $.get("http://localhost:8080/selectById",{id:(Number)(sessionStorage.goods_id)},function (data) {
        // console.log("6++++++"+data.articles[0].goods_id);
        $("#mySwipe").append(
            "<div class='swipe-wrap'>"+
            "<div>" +
            "<img src='"+data.articles[0].file_id+"' height='180px' width='100%'/>" +
            "</div>"+
            "</div>"
        );
        $(".main").append(
            "<div class='jj_title'>"+data.articles[0].goods_name+"</div>" +
            "     <ul class='jj_list' style='margin-bottom:48px;'>" +
            "        <li data-id='"+data.articles[0].goods_id+"'>" +
            "           <ul class='jj_info'>" +
            "              <li><span class='label'>商品售价：</span><span class='red'>￥"+data.articles[0].price+"</span></li>" +
            "              <li><span class='label'>商品原价：</span><span style=' color:#ccc; text-decoration:line-through'>￥"+data.articles[0].discount+"</span></li>" +
            "              <li style='padding:4px 3px; overflow:hidden' class='numbar'><span class='label'>选购数量：</span>" +
            "               <input value='—' type='button' class='plus'/><input value='1' type='text' class='in' id='setnum'/>" +
            "               <input value='+' type='button' class='add'/></li>" +
            "              <li><span class='label'>赞助商：</span><span>"+data.articles[0].sponsor+"</span></li>" +
            "              <li><span class='label'>商品数量：</span><span>"+data.articles[0].goods_count+"</span></li>" +
            "           </ul>\n" +
            "        </li>\n" +
            "     </ul>"
        );
        var d =parseInt($("#setnum").val());
        $(".plus").click(function () {
            if(d<=1){
                alert("不能在减了")
            }else {
                console.log(d);
                d-=1;
                $("#setnum").val(d)
            }
        });
        $(".add").click(function () {
            d+=1;
            $("#setnum").val(d)
        });

        $(".b_nav a").on("click",function () {

            $.get("http://localhost:8080/insertOrder",{
                    aname:(data.articles[0].goods_name),acount:(data.articles[0].goods_count),price:(data.articles[0].price),uid:(Number)(sessionStorage.getItem("uid")),count:d},
                function (data) {
                    alert(data.message + "\n去购物车查看");
                    window.location="http://localhost:8080/gwc"
                })
        })
    })

}

function test_pro_list() {
    $.get("http://localhost:8080/selectByType",{type:(Number)(sessionStorage.getItem("type"))},function (data) {
        // console.log("+++"+data.articles[0].goods_id);
        $.each(data.articles,function (index,item) {
            console.log(item.goods_name);
            $(".pro_list").append(
                "<li data-id='"+item.goods_id+"'>"+
                "<a href='#'>"+
                "<div class='pro_pic'>"+
                "<img src='"+item.file_id+"' height='180px' width='100%'/>"+
                "<p class='pro_title'>"+item.goods_name+"</p>"+
                "</div>"+
                "<div class='pro_info'>"+
                "<span class='xj'>￥"+item.price+"" +
                "<span class='yj'>￥"+item.discount+"</span>" +
                "</span>"+
                "<span class='sczg'> </span>"+
                "</div>"+
                "</a>"+
                "</li>"
            )
        });
        $(".pro_list:first li").on("click",function () {
            console.log("dddddd"+sessionStorage.goods_id);
            sessionStorage.goods_id=this.dataset.id;
            window.location="http://localhost:8080/pro_detail"
        })
    })
}

function test_pj() {
    $.get("http://localhost:8080/selectCommentById",{id:(Number)(sessionStorage.goods_id)},function (data) {
        $.each(data.comments,function (index,item) {
                console.log(item);
                $(".pjlist").append(
                    "<li>"+
                    "<p class='pjr'><span class='plr'>"+item.comment_user+":</span><span class='pjlx' style='display:none'>好评</span></p>"+
                    "<p class='pjnr'>"+item.content+"</p>"+
                    "<p class='plsj'>"+item.comment_time+"</p>"+
                    "</li>"
                )
            }
        )
    })
}

function test_detailc() {
    $.get("http://localhost:8080/selectById",{id:(Number)(sessionStorage.goods_id)},function (data) {
        console.log("+++"+data.articles[0].goods_id);
        console.log(data.articles[0].goods_name);

        $(".main").append(
            "<div class='images'>"+
            "<img src='"+data.articles[0].file_id+"'/>"+
            "</div>"
        )


    })
}


function test_gwc() {

    $(".name").html(sessionStorage.getItem("realName"));
    $(".tel").html(sessionStorage.getItem("phone"));
    $(".addr").html(sessionStorage.getItem("address"));

    $.get("http://localhost:8080/selectOrderByUid", {uid: (Number)(sessionStorage.getItem("uid"))}, function (data) {
        $.each(data.orders,function (index,item) {
            var b =item.price;
            var c= item.count;
            a += b*c;
            $(".gwc_list").append(
                "<li id='a' style='position:relative'>"+
                "<a href='#' class='sc' data-oid='"+item.oid+"'><img src='images/scdz.png'/></a>" +
                " <div class='gwc_title'>"+item.aname+"</div>\n" +
                " <ul class='gwc_info'>\n" +
                "        <li><span class='label'>当前售价：</span><span class='red'>￥"+item.price+"</span></li>" +
                "        <li><span class='label'>商品数量：</span><span>"+item.acount+"</span></li>" +
                "        <li style='border:none;overflow:hidden'>" +
                "        <span class='label' style='display:inline-block; float:left'>选购数量：</span>" +
                "        <input value='—' type='button' class='plus' data-count='"+item.count+"' data-oid='"+item.oid+"'/>" +
                "        <input value='"+item.count+"' type='text' class='in'/>" +
                "        <input value='+' type='button' class='add' data-count='"+item.count+"' data-oid='"+item.oid+"'/></li>" +
                " </ul></li>"+
                " <li style='position:relative'>" +
                "          <textarea style='min-height:80px; width:96%; line-height:22px; margin:4px auto; background:#fff; border:none' placeholder='请输入备注信息'></textarea>\n" +
                "</li>"
            )

        });
        $(".b_nav").append("<span class='gwc_zj'>总价：￥"+a+"元</span><span><a href='#' class='gwc_js'>结算</a></span>");
        //删除
        $("#a a").click(function () {
            $.get("http://localhost:8080/remove", {oid: (Number)(this.dataset.oid)}, function (data) {
                console.log(data);
                window.location="http://localhost:8080/gwc"
            })
        });

        //更新商品数量
        $(".add").click(function () {
            var ct=parseInt(this.dataset.count);
            ct+=1;

            console.log(ct);
            console.log(this.dataset.oid);
            $.get("http://localhost:8080/updataOrder",{count:ct,oid:this.dataset.oid},function (data) {
                window.location="http://localhost:8080/gwc"
            })
        });
        $(".plus").click(function () {
            var updateStatus = true;
            var oid=this.dataset.oid;
            var ct=parseInt(this.dataset.count);
            ct-=1;
            console.log(ct);
            $.get("http://localhost:8080/updataOrder",{count:ct,oid:oid},function (data) {
                if (data.message == "更新失败"){
                    updateStatus = false;
                }
                if(ct<1){
                    $.get("http://localhost:8080/remove", {oid: oid}, function (data) {
                        console.log("+++"+data);
                        window.location="http://localhost:8080/gwc"
                    })
                }else {
                    updateStatus?window.location="http://localhost:8080/gwc":"更新失败";
                }

            })
        })
    })
}
