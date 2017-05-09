document.getElementById("form").addEventListener("submit", ajax, false);

function ajax() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("qrcode").src = URL.createObjectURL(this.response);
        }
    };

    xhr.open("POST", "ajax");
    xhr.responseType = "blob";
    xhr.send(document.getElementById("contents").value);
}
