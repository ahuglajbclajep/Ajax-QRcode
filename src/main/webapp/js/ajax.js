document.getElementById("form").addEventListener("submit", ajax, false);

function ajax() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "ajax");
    xhr.send(document.getElementById("contents").value);
    return false;
}
