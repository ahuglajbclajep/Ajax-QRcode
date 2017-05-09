document.getElementById("submit_button").addEventListener("click", ajax, false);

function ajax(event) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("qrcode_image").src = URL.createObjectURL(this.response);
        }
    };

    xhr.open("POST", "ajax");
    xhr.responseType = "blob";
    xhr.send(document.getElementById("input_text").value);
}
