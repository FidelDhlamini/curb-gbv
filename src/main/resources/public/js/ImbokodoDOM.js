let usefulLinksContainer = document.querySelector(".usefulLinksContainer");
let statsContainer = document.querySelector(".statsContainer");
let overviewContainer = document.querySelector(".overviewContainer");

function resetTab(){
        overviewContainer.setAttribute('style', 'display:none');
                statsContainer.setAttribute('style', 'display:none');
                usefulLinksContainer.setAttribute('style', 'display:none');
                }

function hashTemplate() {
    let hash = location.hash;
    let getHash = hash.split('#');
    resetTab();

    if(getHash[1] === "overview"){
            overviewContainer.setAttribute('style', 'display:block');
    }
        if(getHash[1] === "stats"){
                statsContainer.setAttribute('style', 'display:block');
        }

    if(getHash[1] === "links"){
            usefulLinksContainer.setAttribute('style', 'display:block');
    }


    }

window.addEventListener("hashchange", function () {
    hashTemplate()
});

