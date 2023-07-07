
const axios=require(`axios`)
function goodsshow(){
    // userId=localStorage.getItem(`userId`)
    let content=document.querySelector(`.commodity_list`)
    console.log(content)
    axios({
        method:`get`,
        url:`http://localhost:8080/Cart/user/1`,

    }).then(result=>{
        console.log(result)
        console.log(result.data.data.length)
        for (let i = 0; i < result.data.data.length; i++) {

            let tem=document.createElement(`div`)
            tem.innerHTML=`
                <hr>
<!--                <br>-->
                <div class="commodity_box wrapper">
                    <div id="goodsname">
                        名称
                    </div>
                    <div class="goodpic">
                        <img src="../image/1.jpg">图片
                    </div>
                    <div id="nums">
                        <input  class="goodsnums" type="text" placeholder="最少一个">
                    </div>
                    <div class="totalprice">
                        总价
                    </div>
                </div>
                <hr>
`
            console.log(tem)
            content.appendChild(tem)
        }
    }).catch((error)=>{
        alert(`出现了一点小错误，请刷新页面尝试`)
    })

// const  http=new XMLHttpRequest()
// const  url=`http://localhost/Cart/user/1`
// http.open(`GET`,url)
// http.send()
//
// http.onreadystatechange=(e)=>{
//     console.log(http.responseText)
// }
}
function paying(){
    let paybox=document.querySelector(`.payment`)
    let confirm=document.querySelector(`.confirm`)
    let but=paybox.childNodes[3]
    console.log(but)
    but.addEventListener(`click`,()=>{
        confirm.style.display=`flex`
        let confirmagain=document.querySelector(`.confirm div`)
        confirmagain.addEventListener(`click`,()=>{
            alert(`支付成功`)
            window.location.href=`http://localhost:8080/html/shoppingtrolly.html`

        })
    })
}

goodsshow()
paying()