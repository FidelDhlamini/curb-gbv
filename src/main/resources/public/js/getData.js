let total_cases = document.querySelector("#total-cases");

function getCoordinates(){

 return axios
     .get('/api/get-coordinates')
     .then(function(result){
        return result.data;
     });

};

function getReports(){

 return axios
     .get('/api/reported-data')
     .then(function(result){
        return result.data;
     });

}

function getStats(){

 return axios
     .get('/api/total-count')
     .then(function(result){
     total_cases.innerHTML = result.data;
        return null;
     });
}

getStats();