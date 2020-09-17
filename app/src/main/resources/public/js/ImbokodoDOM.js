let usefulLinksContainer = document.querySelector(".usefulLinksContainer");
let statsContainer = document.querySelector(".statsContainer");
let overviewContainer = document.querySelector(".overviewContainer");
let containerTab = document.querySelector(".containerTab")

function hashTemplate() {
    let hash = location.hash;
    let getHash = hash.split('#');
    containerTab.setAttribute('style', 'display:block; margin-top:5px');
    console.log(getHash);
    }

window.addEventListener("hashchange", function () {
    hashTemplate()
});

