(function(T,h,i,n,k,P,a,g,e)
{g=function(){P=h.createElement(i);a=h.getElementsByTagName(i)[0];
    P.src=k;P.charset="utf-8";P.async=1;a.parentNode.insertBefore(P,a)};
    T["ThinkPageWeatherWidgetObject"]=n;
    T[n]||(T[n]=function(){(T[n].q=T[n].q||[]).push(arguments)});
    T[n].l=+new Date();
    if(T.attachEvent){T.attachEvent("onload",g)
    }else{
        T.addEventListener("load",g,false)}}
(window,document,"script","tpwidget","//widget.seniverse.com/widget/chameleon.js"))
tpwidget("init", {
    "flavor": "slim",
    "location": "WX4FBXXFKE4F",
    "geolocation": "enabled",
    "language": "zh-chs",
    "unit": "c",
    "theme": "chameleon",
    "container": "tp-weather-widget",
    "bubble": "disabled",
    "alarmType": "badge",
    "color": "#FFFFFF",
    "uid": "U9EC08A15F",
    "hash": "039da28f5581f4bcb5c799fb4cdfb673"
});
tpwidget("show");

function getTime() {
    var date = new Date();
    var year = date.getFullYear(); //获取年份
    var month = date.getMonth() + 1; //获取月份
    var day = date.getDate(); //获取日期
    var hour = date.getHours(); //获取小时
    hour = hour < 10 ? '0' + hour : hour;
    var minute = date.getMinutes(); // 获取分
    minute = minute < 10 ? '0' + minute : minute;
    var seconds = date.getSeconds(); //获取秒
    seconds = seconds < 10 ? '0' + seconds : seconds;
    return year + '年' + month + '月' + day + '日&nbsp;' + hour + ':' + minute + ':' + seconds;
}
var element, layer, laydate, table, form;

$(function () {
    // 使用模块
    layui.use(['element', 'layer', 'laydate', 'table','form'], function () {
        element = layui.element;
        layer = layui.layer;
        laydate = layui.laydate;
        table = layui.table;
        form = layui.form;
    });

    laydate.render({
        elem:"#birthday",
        type: "date",
        format:"yyyy-MM-dd",
        value: ''
    });

    //第一个实例
    var userTable = table.render({
        elem: '#tb-user'
        , height: 515
        , url: 'http://localhost:8080/cxsy' //数据接口
        , page: true //开启分页
        , toolbar: '#toolbarDemo'
        /*, response: {
            statusName: 'code', //规定返回的状态码字段为code
            statusCode: 200 //规定成功的状态码味200
        }*/
        /* , parseData: function (res) {
             return {
                 "code": res.code, //解析接口状态
                 "msg": res.msg, //解析提示文本
                 "data": res.data //解析数据列表
             }
         }*/
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'sid', title: '姓名', width: 80, sort: true, fixed: 'left'}
            , {field: 'sname', title: '姓名'}
            , {field: 'spassword', title: '密码'}
            , {field: 'ssex', title: '性别'}
            , {field: 'sbirthday', title: '出生日期'}
            , {field: 'sidentitycode', title: '身份证号'}
            , {field: 'semail', title: '邮箱'}
            , {field: 'smobile', title: '电话'}
            , {field: 'saddress', title: '地址'}
            , {field: 'simgurl', title: '头像地址'}
            , {field: 'sclass', title: '班级'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 120}
        ]]
    });

    //监听表单提交
    // 修改
    form.on('submit(saveUser)', function(data){
        layer.alert(JSON.stringify(data.field));
        $.ajax({
            url: '/api/layui/user/save',
            type: 'POST',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data.field),
            success: function (result) {
                if (result.code == 200) {
                    // layer.msg("修改成功！", {icon: 6});
                    setTimeout(function () {
                        layer.closeAll();//关闭所有的弹出层
                        userTable.reload();
                    }, 300);
                } else {
                    layer.msg("操作失败！", {icon: 5});
                }
            }
        });

        return false;

    });

    //工具栏事件
    table.on('toolbar(tb-user)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        var checkData = checkStatus.data;
        var ids=[];
        switch (obj.event) {
            // 新增
            case 'add':
                $("#name").val('');
                $("#city").val('');
                $("#id").val('');
                $("#birthday").val('');

                layer.open({
                    type: 1,
                    offset: '10px',
                    title: "新增用户",
                    area: ['500px', '400px'],
                    content: $("#editUser")
                });


                break;
            // 删除
            case 'remove':
                if(checkData.length==0){
                    layer.alert('请选择要操作的行');
                }else{
                    layer.confirm('确定要删除吗？',function (index) {
                        for(var i=0; i<checkData.length;i++){
                            ids.push(checkData[i].id);
                        }
                        //layer.alert(JSON.stringify(ids));
                        $.ajax({
                            url: '/api/layui/user/remove',
                            type: 'POST',
                            contentType: "application/json",
                            dataType: "json",
                            data: JSON.stringify(ids),
                            success: function (result) {
                                if (result.code == 200) {
                                    setTimeout(function () {
                                        layer.closeAll();//关闭所有的弹出层
                                        userTable.reload();
                                    }, 300);
                                }
                            }
                        });
                    });
                }
                break;
            case 'getCheckData':

                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
                break;
        }
        ;
    });

    // 监听工具条
    table.on('tool(tb-user)', function (obj) {
        var data = obj.data;
        // 修改
        if (obj.event === 'edit') {
            $("#name").val(data.name);
            $("#city").val(data.city);
            $("#id").val(data.id);
            $("#birthday").val(data.birthday);

            layer.open({
                type: 1,
                offset: '10px',
                title: "修改用户",
                area: ['500px', '400px'],
                content: $("#editUser")
            });
        }
    });
});