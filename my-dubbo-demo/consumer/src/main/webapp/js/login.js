

function validate() {
    var cardNo = $("#cardNo").val();
    var pwd=$("#pwd").val();

    if(!cardNo){
        alert("请输入正确字符");
        return false;
    }

    if(isNaN(cardNo)){
        alert("请输入正确字符");
        return false;
    }

    if(!pwd){
        alert("请输入正确字符");
        return false;
    }

    if(isNaN(pwd)){
        alert("请输入正确字符");
        return false;
    }


    return true;
}


