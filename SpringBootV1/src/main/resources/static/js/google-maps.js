/*<script type="text/javascript">*/

var map,i;
//var markers=[];
var marker;
var latitudeUpdate;
var gForce;
var infoWindow;
var temp = 'ABCDEFGHIJKLMNOPRSTUVWXYZ'

function createInfoWindow(marker, popupContent) {
	infoWindow = new google.maps.InfoWindow();
    google.maps.event.addListener(marker, 'click', function () {
        infoWindow.setContent(latitudeUpdate);
//        infoWindow.open(pointMap.map, this);
    });
}

function doSomething() {
//    alert('Longitude: '+globalVariableLongitude.example_attribute+' Latitude: '+ globalVariableLongitude);
    
    latitudeUpdate =  globalVariableLatitude.example_attribute;
    var longitudeUpdate = globalVariableLongitude.example_attribute;
    var location = new google.maps.LatLng(latitudeUpdate,longitudeUpdate);
    gForce = globalVariableGForce.example_attribute;
//    gForce = gForce.toFixed(2);
   // createInfoWindow(marker, latitudeUpdate);

/*    marker = new google.maps.Marker({
//        position: myLatlng,
    	map: map,
    	title:"Marker 1",
//        label:{
//        	text:''+latitudeUpdate
//        }
        
      });*/

   marker.setPosition(location);
   marker.setIcon('http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=' + gForce+ '|FF6633|000000');

}

function initialize() {
    var mapOptions = {
      center: new google.maps.LatLng(52.1792836, 21.5721057),
      zoom: 12
    };
    
    map = new google.maps.Map(document.getElementById("map-canvas"),
    		mapOptions);

    //Dodanie markera na mapie
    
    var myLatlng = new google.maps.LatLng(52.17935,21.5725057);
    marker = new google.maps.Marker({
//      position: myLatlng,
      map: map,
      id: 3,
//      icon: 'http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=' + gForce + '|FF0000|000000',
      title:"Marker 1"
      
    });
//    marker.setValues({type: 'point', id: ''});
//    setInterval(doSomething(),5000);
    
  }
  
  $(window).load(
		  function(){
			  google.maps.event.addDomListener(window, 'load', initialize);
		  });
  //MInsk tatrzanska ->  52.1792836, 21.5721057
function createMarker(){
	
}