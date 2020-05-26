$(document).ready(function () {
        var vue = new Vue({
            el: '#app',
            data: {
                user: {
                    userName: '',
                    password: ''
                }, userList: []
            }, methods: {
                login: function () {
                    $("#submit").click(function () {
                        var _this = this;
                        axios({
                            method: 'post',
                            url: '/work/login.do',
                            params: {
                                userName: $("#userName").val(),
                                password: $("#password").val()
                            }
                        }).then(function (response) {
                            var ii = layer.load();
                            //此处用setTimeout演示ajax的回调
                            setTimeout(function () {
                                layer.close(ii);
                            }, 2000);
                        })
                    })
                },
            }, mounted() {

            }
        });
        var add = vue.login();


    }
)
