let total_cases = document.querySelector("#total-cases");

function getCoordinates(){

 return axios
     .get('/get-coordinates')
     .then(function(result){
        return result.data;
     });

};

function getReports(){

 return axios
     .get('/reported-data')
     .then(function(result){
        return result.data;
     });

}

function getStats(){

 return axios
     .get('/total-count')
     .then(function(result){
     total_cases.innerHTML = result.data;
        return null;
     });
}

getStats();