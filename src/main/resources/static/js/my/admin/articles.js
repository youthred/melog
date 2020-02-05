window.onload = function() {
    const vue = new Vue({
        el: '#app',
        data: {
            articles: '',
            page: {
                index: 1,
                size: 10
            }
        },
        methods: {
            pageInfo() {
                $.get('/article/findByPage', {'pageIndex': this.page.index, 'pageSize': this.page.size, 'isSignIn': false}, (result) => {
                    this.articles = result.resultObj
                })
            },
            prev() {
                this.page.index--;
                this.pageInfo()
            },
            next() {
                this.page.index++;
                this.pageInfo()
            },
            del(id) {
                this.$confirm('删除后无法恢复，确定继续吗？', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    $.get('/article/delete/' + id, (result) => {
                        if (result.success) {
                            this.$message.success('删除成功');
                            vue.pageInfo()
                        } else {
                            this.$message.error('删除失败，因为\n\n' + result.msg)
                        }
                    })
                }).catch(() => {
                    // this.$message({
                    //     type: 'info',
                    //     message: '已取消删除'
                    // })
                })
            }
        },
        created: function () {
            nickname();
            this.pageInfo()
        }
    });
};

function nickname() {
    $.get('/nickname', function (result) {
        $('.nickname').text(result)
    })
}