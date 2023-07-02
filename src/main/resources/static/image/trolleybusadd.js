
function postDelete() {
    axios({
        url:``,
        method:post,
        data:{

        }
    })
}
function getGoods(){
    axios({
        url: `http://localhost:8080/Cart/user/${}`,
        method: get,
    }).then(result=>{
        for (let i = 0; i < result.length; i++) {

        }
    })

}