function getData(){

axios
     .get('/reported-data')
     .then(function(result){
        console.log(result)
     })


}