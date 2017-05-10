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
    $.ajax({
        url: "ajax",
        type: "POST",
        data: text,
        xhr: function () {
            var xhr = new XMLHttpRequest();
            xhr.responseType = "blob";
            return xhr;
        }
    })
    .done(function (response) {
        document.getElementById("qrcode_image").src = URL.createObjectURL(response);
    })
    .fail(function () {
        alert("Connection failed.");
    });
}
