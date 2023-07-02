
axios({
    method:`get`,
    url:`http://localhost:8080/Cart/user/1`,

}).then(result=>{
    console.log(result)
}).catch(error=>{
    console.log(error)
})
// const  http=new XMLHttpRequest()
// const  url=`http://localhost/Cart/user/1`
// http.open(`GET`,url)
// http.send()
//
// http.onreadystatechange=(e)=>{
//     console.log(http.responseText)
// }