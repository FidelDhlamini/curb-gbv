let getLocBtn = document.querySelector("#locationBtn");
let addressField = document.querySelector("#inputAddress");

getLocBtn.addEventListener("click", function () {

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else {
    addressField.value = "Geolocation is not supported by this browser, enter manually.";
  }
}

function showPosition(position) {
  addressField.value = position.coords.latitude +
  ";" + position.coords.longitude;
}

getLocation();
});