document.getElementById("submit_button").addEventListener("click", submit, false);
var hash = location.hash.replace(/^#/, "");
if (hash !== "") {
    ajax(hash);
    document.getElementById("input_text").value = hash;
}

function submit() {
    var text = document.getElementById("input_text").value;
    ajax(text);
    location.hash = text;
}

function ajax(text) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("qrcode_image").src = URL.createObjectURL(this.response);
        }
    };

    xhr.open("POST", "ajax");
    xhr.responseType = "blob";
    xhr.send(text);
}
