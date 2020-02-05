window.onload = function() {
    new Vue({
        el: '#app',
        data: {
        },
        methods: {},
        created: function () {
            nickname();
        }
    })
};

function nickname() {
    $.get('/nickname', function (result) {
        $('.nickname').text(result)
    })
}