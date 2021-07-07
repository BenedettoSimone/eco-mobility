function chilometriObserver() {

    var chilometri = $('#chilometri_input');
    var chilometri_l= $('#chilometri_label')
    var chilometri_text = chilometri.val();

    var reg = new RegExp(/^[0-9]*$/);

    if (!reg.test(chilometri_text)) {
        chilometri.css('border-color', 'red');
        chilometri_l.text("Inserisci un valore numerico!");
        chilometri_l.css('color', 'red');

        return false;
    } else {
        chilometri.css('border-color', '#707070');
        chilometri_l.text("");


        return true;
    }

}

$(document).on("submit", "#fSpostamenti", function (event) {
    let kmObs = chilometriObserver();

    if (kmObs){

        return true;
    } else {
        return false;
    }
});

