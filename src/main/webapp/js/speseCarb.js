function euroObserver() {

    var euro = $('#euro_input');
    var euro_l= $('#euro_label')
    var euro_text = euro.val();

    var reg = new RegExp(/^[0-9]*$/);

    if (!reg.test(euro_text)) {
        euro.css('border-color', 'rgb(255, 119, 119)');
        euro_l.text("Inserisci un valore numerico!");
        euro_l.css('color', 'rgb(255, 119, 119)');

        return false;
    } else {
        euro.css('border-color', '#707070');
        euro_l.text("");


        return true;
    }

}

$(document).on("submit", "#fSpesa", function (event) {
    let euroObs = euroObserver();

    if (euroObs){

        return true;
    } else {
        return false;
    }
});

