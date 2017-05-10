document.getElementById("submit_button").addEventListener("click", submit, false);
var hash = location.hash.replace(/^#/, "");
if (hash !== "") {
    ajax(hash);
    document.getElementById("input_text").value = hash;
}

function submit() {
    var text = document.getElementById("input_text").value;
    jAjax(text);
    location.hash = text;
}

function ajax(text) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("qrcode_image").src = URL.createObjectURL(this.response);
        }
    };
    xhr.responseType = "blob";

    xhr.open("POST", "ajax");
    xhr.send(text);
}

function jAjax(text) {
    $.ajax({
        url: "ajax",
        type: "POST",
        data: text,
        xhr: function () {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("qrcode_image").src = URL.createObjectURL(this.response);
                }
            };
            xhr.responseType = "blob";

            return xhr;
        }
    });
}
