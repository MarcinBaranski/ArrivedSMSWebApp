/*<script type="text/javascript">*/

var map;
var markers = [];
var labels = [];
var mapMarkers = [];
var zalogowani = [];
var marker;
var idMarkera;
var licznikMarkerow = 0;
var image;
var f = 0;

var latitudeUpdate = '';
var longitudeUpdate = '';
var login;
var location;
var gForce, i;
var infoWindow;
var pomocniczaFlagaStworzeniaMarkera = 'false';
var temp = 0;

	function createInfoWindow(marker, popupContent) {
	infoWindow = new google.maps.InfoWindow();
	google.maps.event.addListener(marker, 'click', function() {
		infoWindow.setContent(latitudeUpdate);
		// infoWindow.open(pointMap.map, this);
	});
}

function doSomething() {
	// alert('Longitude: '+globalVariableLongitude.example_attribute+' Latitude:
	// '+ globalVariableLongitude);
	login = globalVariableLogin.example_attribute
	latitudeUpdate = globalVariableLatitude.example_attribute;
	longitudeUpdate = globalVariableLongitude.example_attribute;

	gForce = globalVariableGForce.example_attribute;

	//200 trzeba zmienic na rozmiar ktorejs z tablic przechowujacej markery aby nie iterowac 200 razy 
	// bo to strata czasu
	for (var i = 0; i < 200; i++) {
		if(zalogowani[i] == login) {
			updateMarker();
		}
		else if(zalogowani[i] != login){
			continue;
		}
	}
	createMarker()

	// for (i = 0; i < 500; i++) {
	// if (zalogowani[i] != login) {
	// createMarker();

	// } else {
	// updateMarker();
	// }
	// }
	// gForce = gForce.toFixed(2);
	// createInfoWindow(marker, latitudeUpdate);

	/*
	 * marker = new google.maps.Marker({ // position: myLatlng, map: map,
	 * title:"Marker 1", // label:{ // text:''+latitudeUpdate // }
	 * 
	 * });
	 */

	/*
	  marker.setPosition(location);
	 marker.setIcon('http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=' +
	  gForce + '|FF6633|000000');
	 */
}

function initialize() {
	var mapOptions = {
			center : new google.maps.LatLng(52.1792836, 21.5721057),
			zoom : 12
	};

	map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

	// Dodanie markera na mapie

	var myLatlng = new google.maps.LatLng(52.17935, 21.5725057);
	marker = new google.maps.Marker({
		map : map

	});
	// marker.setValues({type: 'point', id: ''});
	// setInterval(doSomething(),5000);

	$(window).load(function() {
		google.maps.event.addDomListener(window, 'load', initialize);
	});
}
//MInsk tatrzanska -> 52.1792836, 21.5721057

function createMarker() {

	var tmp = new google.maps.LatLng(latitudeUpdate, longitudeUpdate);
	markersPomocnicza[licznikMarkerow] = [ login, latitudeUpdate,
	                                       longitudeUpdate ];

	addMarker(tmp);

	zalogowani[licznikMarkerow] = login;
	licznikMarkerow++;
	i = 0;

}

var markersPomocnicza = [];

var ilRuch = 0;
var locationTempOldLatitude;
var locationTempOldLongitude;

function updateMarker() {
	var dlugosc = markers.length;
	var locationTmp;
	var k;
	ilRuch = ilRuch + 1;
	for (var h = 0; h < markersPomocnicza.length; h++) {
//Sprawdzenie czy tablica jest juz zainicjowana
		if (typeof markersPomocnicza[h][0] != 'undefined' ) {
			//Przeszukanie tablicy w celu odnalezienia rekordu z loginem takim samym jak w nowo odebranym requescie
			if (markersPomocnicza[h][0] == login) {
				for (var k = 0; k < markers.length; k++) {
					//Po odnalezieniu odpowiedniego markera(z odpowiednim loginem przypisanym do pola Title, trzeba 
					//skasowac marker z mapy)
					if (markers[k].getTitle() == login || labels[k]==login ) {
						markers[k].setMap(null);
						labels[k].setMap(null);
					}
				}
				//Utworzenie zmiennej przechowujacej lokalizacje akceptowalna przez markery google maps i 
				//przypisanie zaaktualizowanej lokalizacji
				
				locationTempOldLatitude  = markersPomocnicza[h][1];
				locationTempOldLongitude = markersPomocnicza[h][2];
				var locationTemp = new google.maps.LatLng(latitudeUpdate,
						longitudeUpdate);
				//Ponowne wyswietlenie zaaktualizowanego markera na mapie
				if(temp==0){
					temp = 1;
			
				}
				addMarker(locationTemp);
				
			}
			
		} else {
			continue;
		}

	}


	var line = new google.maps.Polyline({
	    path: [
	        //new google.maps.LatLng(markersPomocnicza[h][1],
			//		markersPomocnicza[h][2]), 
	        new google.maps.LatLng(locationTempOldLatitude,
					locationTempOldLongitude),
	        new google.maps.LatLng(latitudeUpdate,
					longitudeUpdate)
	    ],
	    strokeColor: "#FF0000",
	    strokeOpacity: 1.0,
	    strokeWeight: 3,
	    map: map
	});
}
function setMapOnAll(map) {
	for (var j = 0; j < markersPomocnicza.length; j++) {
		markersPomocnicza[j].setMap(map);
	}
}

function addMarker(location) {
//	var image = new google.maps.MarkerImage('http://i.imgur.com/M5zM4mZ.png?2' + gForce);
//	createIcon(gForce);
	
	var markerSciezka='';
	if(f==0){
		markerSciezka = '/resources/images/Arrow_blue.png';
		f=1;
	}else if(f == 1){
		markerSciezka = '/resources/images/Arrow_orange.png';
		f=2;
	}else if(f == 2){
		markerSciezka = '/resources/images/Arrow_red.png';
		f=3;
	}else if(f == 3){
		markerSciezka = '/resources/images/Arrow_green.png';
		f=4;
	}else if(f == 4){
		markerSciezka = '/resources/images/Arrow_pink.png';
		f=5;
	}else if(f == 5){
		markerSciezka = '/resources/images/Arrow_darkBlue.png';
		f=0;
	}
	var marker = new google.maps.Marker({
		position : location,
		map : map,
		//icon: ('http://i.imgur.com/M5zM4mZ.png?3'),//trzeba zmienic grafike na rozne kolory i pobieranie z folderu a nie z imgur.com
		icon: markerSciezka,
		title : login
	});
	
	
	var pozycjaPionowo = parseFloat(latitudeUpdate);
	var pozycjaPoziomo = parseFloat(longitudeUpdate) ;
	//var loginNewLineGforce = mystr;
	var mapLabel = new MapLabel({
        text: login+'{'+gForce+'}',
        title:login,
        position: new google.maps.LatLng(latitudeUpdate,pozycjaPoziomo),
        map: map,
        fontSize: 13,
     
      });
	
	labels.push(mapLabel);
	markers.push(marker);

}


function addLine(){
	
	var line = new google.maps.Polyline({
	    path: [
	        new google.maps.LatLng(37.4419, -122.1419), 
	        new google.maps.LatLng(37.4519, -122.1519)
	    ],
	    strokeColor: "#FF0000",
	    strokeOpacity: 1.0,
	    strokeWeight: 10,
	    map: map
	});
}




function createIcon(GForce){
	var imageObj = new Image();
	imageObj.setAttribute('crossOrigin', 'anonymous');
//    imageObj.src = 'http://i.imgur.com/M5zM4mZ.png?2'; 
    imageObj.src =  '/images/Arrow_6.png';
    
	var canvas = document.createElement('canvas');
	var context = canvas.getContext("2d");
	context.drawImage(imageObj, 0, 0);
    
    context.font = "22px Arial";
    Gforce = login+GForce
    context.fillText(''+login+GForce, 17, 55);
    
    image = {
    	    url: canvas.toDataURL(),
    	 };
    
    
}
