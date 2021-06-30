
var input = false;



function mezzoObserver() {

    var mezzo = $('#mezzo_input');
    var mezzo_l= $('#mezzo_label')
    var mezzo_text = mezzo.val();

    var reg = new RegExp(/^[0-9]*$/);

    if (!reg.test(mezzo_text)) {
        mezzo.css('border-color', 'red');
        mezzo_l.text("Inserisci un valore numerico!");
        mezzo_l.css('color', 'red');

        return false;
    } else {
        mezzo.css('border-color', '#707070');
        mezzo_l.text("");


        return true;
    }

}

function spesaObserver() {

    var spesa = $('#spese_input');
    var spesa_l= $('#spese_l')
    var spesa_text = spesa.val();

    var reg = new RegExp(/^[0-9]*$/);

    if (!reg.test(spesa_text)) {
        spesa.css('border-color', 'red');
        spesa_l.text("Inserisci un valore numerico!");
        spesa_l.css('color', 'red');

        return false;
    } else {
        spesa.css('border-color', '#707070');
        spesa_l.text("");


        return true;
    }

}

function kmObserver() {

    var km = $('#chilometri_input');
    var km_l= $('#km_l')
    var km_text = km.val();

    var reg = new RegExp(/^[0-9]*$/);

    if (!reg.test(km_text)) {
        km.css('border-color', 'red');
        km_l.text("Inserisci un valore numerico!");
        km_l.css('color', 'red');

        return false;
    } else {
        km.css('border-color', '#707070');
        km_l.text("");


        return true;
    }

}


$(document).on("submit", "#fChilometri", function (event) {
    let mezzo = mezzoObserver();

    if (mezzo){

        return true;
    } else {
        return false;
    }
});