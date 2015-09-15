        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
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

//        function disconnect() {
//            if (stompClient != null) {
//                stompClient.disconnect();
//            }
//            setConnected(false);
//            console.log("Disconnected");
//        }

//        function sendName() {
//            var name = document.getElementById('name').value;
//            stompClient.send("/app/locationUpdate", {}, JSON.stringify({ 'name': name }));
//        }

        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message.longitude));
            paragraph12.innerHTML = "" + message.longitude;
            paragraph21.innerHTML = "" + message.latitude;
        }