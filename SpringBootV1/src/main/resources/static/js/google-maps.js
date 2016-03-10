/*<script type="text/javascript">*/

var map;
var marker;

function doSomething() {
//    alert('Longitude: '+globalVariableLongitude.example_attribute+' Latitude: '+ globalVariableLongitude);
    
    var latitudeUpdate =  globalVariableLatitude.example_attribute;
    var longitudeUpdate = globalVariableLongitude.example_attribute;
    var location = new google.maps.LatLng(latitudeUpdate,longitudeUpdate);
    
    marker.setPosition(location);
}

function initialize() {
    var mapOptions = {
      center: new google.maps.LatLng(52.1792836, 21.5721057),
      zoom: 12
    };
    
    map = new google.maps.Map(document.getElementById("map-canvas"),
    		mapOptions);

    //Dodanie markera na mapie
    
    
    //setInterval(function(){ alert(""+globalVariable),200);
    
    var myLatlng = new google.maps.LatLng(52.17935,21.5725057);
    marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title:"Marker 1"
    });
    setInterval(doSomething(),7000);
    
  }
  
  $(window).load(
		  function(){
			  google.maps.event.addDomListener(window, 'load', initialize);
		  });
  //MInsk tatrzanska ->  52.1792836, 21.5721057