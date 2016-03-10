        var stompClient = null;
        var longitudeClient; 
        var latitudeClient;

        
        function setConnected(connected) {
//        	document.getElementById('connect').style.visibility = "hidden";
//        	document.getElementById('connect').disabled = connected;
//            document.getElementById('disconnect').style.visibility = "hidden";
//            document.getElementById('disconnect').disabled = !connected;
        }

        function connect() {
            var socket = new SockJS('/locationUpdate', null, 
            		{
            			protocols_whitelist: ['websocket', 'xdr-streaming', 'xhr-streaming', 'xdr-polling', 'xhr-polling', 'iframe-eventsource', 'jsonp-polling']
            		});
            console.log("trying to connect...");
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/updates', function(location){
                	console.log("!!!!!!!!!!!!!! got it!!!!!!!! ", location.body);
                    showGreeting(JSON.parse(location.body));
                });
            });
        }
        
        globalVariableLongitude={example_attribute:""}; 
        globalVariableLatitude={example_attribute:""};
        
        function showGreeting(message) {
//            var response = document.getElementById('response');
//            var p = document.createElement('p');
//            p.style.wordWrap = 'break-word';
//            p.appendChild(document.createTextNode(message.longitude));
            paragraph12.innerHTML = "" + message.longitude;
            paragraph21.innerHTML = "" + message.latitude;
            
            //globalne zmienne do przechowywania aktualizowanej lokalizacji
            globalVariableLatitude={example_attribute:"" + message.latitude};
            globalVariableLongitude={example_attribute:"" + message.longitude};
            
            //Interwal do odswiezania wspolrzednych markera 7000 = 7s
            setInterval(doSomething(),5000);


        }
 