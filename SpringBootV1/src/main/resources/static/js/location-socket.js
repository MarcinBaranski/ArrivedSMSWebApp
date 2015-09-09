        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            var socket = new SockJS('/locationUpdate', null, 
            		{
            			debug: true,
            			protocols_whitelist: ['websocket', 'xdr-streaming', 'xhr-streaming', 'xdr-polling', 'xhr-polling', 'iframe-eventsource', 'jsonp-polling']
            		});
            console.log("trying to connect...");
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                //setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/updates', function(greeting){
                	console.log("!!!!!!!!!!!!!! got it!!!!!!!!");
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        function sendName() {
            var name = document.getElementById('name').value;
            stompClient.send("/app/locationUpdate", {}, JSON.stringify({ 'name': name }));
        }

        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }