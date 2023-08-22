let websocket = new WebSocket("ws://localhost:9090/group5/ContactChat");

websocket.onopen = function(event) {
	onOpen(event);
};
websocket.onmessage = function(event) {
	onMessage(event);
};
websocket.onclose = function(event) {
	onClose(event);
};
websocket.onerror = function(event) {
	onError(event);
};

function onOpen(event) {
	let p = document.createElement("p");
	p.append("관리자가 실시간 채팅에 입장하였습니다.");
	p.className("chat");
	$(".messageContainer").append(p);
}