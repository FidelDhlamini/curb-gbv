
var map;
async function map(){
         mapboxgl.accessToken = 'pk.eyJ1IjoiaW5jcmVkaWJsZWphZ3VyIiwiYSI6ImNrOTJwM2FsNzAyM2szbW9hdWR2OXBqZjUifQ.6H9790vEmqomFGSu0Q8M0g';
                map = new mapboxgl.Map({
                container: 'map',
                style: 'mapbox://styles/incrediblejagur/ck7xs2kdu00ot1ilpid6krvs7', // stylesheet location
                center: [24.991639, -28.8166236],
                zoom: 4.2 // starting zoom
})
  map.addControl(new mapboxgl.NavigationControl());
 await addPoints();

};

async function addPoints(){


map.on('load', async function () {
map.addImage('pulsing-dot', pulsingDot, { pixelRatio: 2 });

let coordinate_data = await getCoordinates();
for(let z = 0; z < coordinate_data.length; z++){
let coord = coordinate_data[z];
let longitude = Number(coord.split(';')[0]);
let latitude = Number(coord.split(';')[1]);
map.addSource('points'+z, {
'type': 'geojson',
'data': {
'type': 'FeatureCollection',
'features': [
{
'type': 'Feature',
'geometry': {
'type': 'Point',
'coordinates': [longitude, latitude]
}
}
]
}
});
let _id = "pointer"+z;
map.addLayer({
'id': _id.toString(),
'type': 'symbol',
'source': 'points'+z,
'layout': {
'icon-image': 'pulsing-dot'
}
});
}
});

}



var size = 70;
var pulsingDot = {
width: size,
height: size,
data: new Uint8Array(size * size * 4),

// get rendering context for the map canvas when layer is added to the map
onAdd: function () {
var canvas = document.createElement('canvas');
canvas.width = this.width;
canvas.height = this.height;
this.context = canvas.getContext('2d');
},

// called once before every frame where the icon will be used
render: function () {
var duration = 1000;
var t = (performance.now() % duration) / duration;

var radius = (size / 2) * 0.3;
var outerRadius = (size / 2) * 0.7 * t + radius;
var context = this.context;

// draw outer circle
context.clearRect(0, 0, this.width, this.height);
context.beginPath();
context.arc(
this.width / 2,
this.height / 2,
outerRadius,
0,
Math.PI * 2
);
context.fillStyle = 'rgba(255, 200, 200,' + (1 - t) + ')';
context.fill();

// draw inner circle
context.beginPath();
context.arc(
this.width / 2,
this.height / 2,
radius,
0,
Math.PI * 2
);
context.fillStyle = 'rgba(255, 100, 100, 1)';
context.strokeStyle = 'white';
context.lineWidth = 2 + 4 * (1 - t);
context.fill();
context.stroke();

// update this image's data with data from the canvas
this.data = context.getImageData(
0,
0,
this.width,
this.height
).data;

// continuously repaint the map, resulting in the smooth animation of the dot
map.triggerRepaint();

// return `true` to let the map know that the image was updated
return true;
}
};

map();