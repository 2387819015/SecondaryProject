function searchhot(){
    const searchhot=document.querySelector(`.hotrecommend`)
    const search=document.querySelector(`.search input`)

    search.addEventListener(`focus`,function (){
        setTimeout(()=>{
            searchhot.style.display=`block`
        },400)

    })
    search.addEventListener(`blur`,function (){
            searchhot.style.display=`none`
        }
    )
}
searchhot()
function fillgoods(){
    if(localStorage.hasOwnProperty(`userinput`)){
        input=localStorage.getItem(`userinput`)
        localStorage.removeItem(`userinput`)
    }
    else {
        let input= document.querySelector(`.search input`)
    }
    let but =document.querySelector(`.search button`)
    but.addEventListener(`click`,event=> {
        let arr
        let row = document.querySelector(`.display`)
        axios({
            method: "post",
            url: `http://localhost:8080/Goods/select?goodsName=${input.value}`
        }).then(result => {
            arr = result

            let minlength=Math.floor(arr.data.length/2)>=1?2:1
            for (let i = 0; i < minlength; i++) {
                let child = document.createElement(`div`)
                for (let j = 0; j < 5; j++) {
                    let child_good = document.createElement(`div`)
                    child_good.innerHTML = `
                <div class="good_box">
                    <div class="pic">
                        <img src="${arr.data.data[j].facePic}">
                    </div>
                    <div>
                        这是一个超棒的商品
                    </div>
                </div>`
                    child.appendChild(child_good)
                }
                row.appendChild(child)
            }
        })
    })


}
fillgoods()