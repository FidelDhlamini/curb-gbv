function getCoordinates(){

 return axios
     .get('/get-coordinates')
     .then(function(result){
        return result.data;
     });

};