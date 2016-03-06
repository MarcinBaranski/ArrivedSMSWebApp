/*<script type="text/javascript">*/
  function initialize() {
    var mapOptions = {
      center: new google.maps.LatLng(52.1792836, 21.5721057),
      zoom: 12
    };
    var map = new google.maps.Map(document.getElementById("map-canvas"),
      mapOptions);
  }
  
  $(window).load(
		  function(){
			  google.maps.event.addDomListener(window, 'load', initialize);
		  });
  //MInsk tatrzanska ->  52.1792836, 21.5721057