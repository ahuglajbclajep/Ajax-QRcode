$("#submit_button").on("click", submit);
var hash = location.hash.replace(/^#/, "");
if (hash !== "") {
    ajax(hash);
    $("#input_text").val(hash);
}

function submit() {
    var text = $("#input_text").val();
    ajax(text);
    location.hash = text;
}

function ajax(text) {
    fetch("ajax", {
        method: 'POST',
        body: text
    })
    .then(response => {
        if (response.ok) response.blob().then(blob => $("#qrcode_image").attr("src", URL.createObjectURL(blob)));
    })
    .catch(() => alert("Connection failed."));
}
