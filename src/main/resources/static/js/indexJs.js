

function searchhot(){
 const searchhot=document.querySelector(`.hotrecommend`)
 const search=document.querySelector(`.search input`)
 search.addEventListener(`focus`,function (){
  searchhot.style.display=`block`
 })
 search.addEventListener(`blur`,function (){
  searchhot.style.display=`none`
  }
 )
}
searchhot()

function scorllImage() {
 let img;
 img = [{
  url: `www.baidu.com`,
  img: `./image/1.png`
 },
  {
  url: `www.bilibili.com`,
  img: `./image/2.png`
 }];
 let but1 = document.querySelector(`.goodsscroll button`)
 let but2 = document.querySelector(`.goodsscroll button:last-child`)
 let scro_num = 0
 let link = document.querySelector(`.goodsscroll a`)
 let photo = document.querySelector(`.goodsscroll a img`)
 but1.addEventListener(`click` , function (){
  scro_num--
  if(scro_num<0){
   scro_num=img.length-1}
  link.href = img[scro_num].url
  photo.src = img[scro_num].img
 })
 but2.addEventListener(`click`,function(){
  scro_num++
  if (scro_num >= img.length) {
   scro_num = 0
  }
  link.href = img[scro_num].url
  photo.src = img[scro_num].img
 })
 function countscroll() {
  link.href = img[scro_num].url
  photo.src = img[scro_num].img
  scro_num++;
  if (scro_num >= img.length) {
   scro_num = 0;
  }
 }
 let scroll_i=setInterval( countscroll,2000)
 let goodsscrollpage=document.querySelector(`.goodsscroll`)
 goodsscrollpage.addEventListener(`mouseenter`,function () {
  clearInterval(scroll_i)
 })
 goodsscrollpage.addEventListener(`mouseleave`,function () {
  scroll_i=setInterval(countscroll,2000)
 })


}
scorllImage()

function backtosomewhere() {
 let butback=document.querySelectorAll(`.rightscorll a`)
 const top=butback[0]
 const square=butback[1]
 const  goodsreco=butback[2]
 let Offset=document.querySelectorAll(`.midpagetitle`)
 const squareoffset=Offset[0]
 const goodsrecooffset=Offset[1]
  top.addEventListener(`click`,e=>{
   scrollTo(0,0)
   e.preventDefault()
  })
 console.log(squareoffset.offsetTop)
 square.addEventListener(`click`,e=>{
  e.preventDefault()
 scrollTo(0,squareoffset.offsetTop-200)
 })
 goodsreco.addEventListener(`click`,e=>{
  scrollTo(0,goodsrecooffset.offsetTop-200)
  e.preventDefault()
 })
}
backtosomewhere()



