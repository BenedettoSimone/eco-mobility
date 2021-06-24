
/* cosa succede quando premo registrati */
function selectRegi(){
    /*il form di login non si vede più*/
    document.getElementById("fLogin").style.display="none";
    /*il form di registrazione diventa visibile*/
    document.getElementById("fRegi").style.display="block";



    /*cambio i colori al bottone cliccato*/
    document.getElementById("selectRegi").style.color="#5a87e8"
    document.getElementById("selectRegi").style.backgroundColor="#f1f6ff"
    document.getElementById("selectRegi").style.borderRadius="15px";

    /*cambio i colori al bottone non cliccato*/
    document.getElementById("selectLogin").style.color="#494848"
    document.getElementById("selectLogin").style.backgroundColor="#fff"
    document.getElementById("selectLogin").style.borderRadius="0px";


    document.getElementById("message").style.visibility="hidden";

}



/* cosa succede quando premo registrati */
function selectLogin(){
    /*il form di login diventa visibile*/
    document.getElementById("fLogin").style.display="block";
    /*il form di registrazione non si vede più*/
    document.getElementById("fRegi").style.display="none";


    /*cambio i colori al bottone cliccato*/
    document.getElementById("selectLogin").style.color="#5a87e8"
    document.getElementById("selectLogin").style.backgroundColor="#f1f6ff"
    document.getElementById("selectLogin").style.borderRadius="15px";

    /*cambio i colori al bottone non cliccato*/
    document.getElementById("selectRegi").style.color="#494848"
    document.getElementById("selectRegi").style.backgroundColor="#fff"
    document.getElementById("selectRegi").style.borderRadius="0px";

    document.getElementById("message").style.visibility="hidden";

}


var emailGlobal = false;


function emailObserver() {

    var email = $('#email');
    var label = $('#email_l');

    var email_text = email.val()

    var reg = new RegExp(/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/);

    if (!reg.test(email_text) || email_text.length < 10 || email_text.length > 40) {
        email.css('border-color', 'red');
        label.css('color', 'red');
        label.text("Inserire email corretta!");

        emailGlobal = false;

    } else {
        label.text("Email");
        label.css('color', '#707070');
        email.css('border-color', '#707070');



        emailGlobal=  true;
    }
}

function nomeObserver() {

    var nome = $('#nome');
    var label = $('#nome_l');

    var nome_text = nome.val();

    var reg = new RegExp(/^[a-zA-Z ]{1,20}$/);

    if (!reg.test(nome_text)) {
        nome.css('border-color', 'red');
        label.css('color', 'red');
        label.text("Nome non valido!");

        return false;

    } else {
        label.text("Nome");
        label.css('color', '#707070');
        nome.css('border-color', '#707070');

        return true;
    }
}


function cognomeObserver() {

    var cognome = $('#cognome');
    var label = $('#cognome_l');

    var cognome_text = cognome.val();

    var reg = new RegExp(/^[a-zA-Z ]{1,20}$/);

    if (!reg.test(cognome_text)) {
        cognome.css('border-color', 'red');
        label.css('color', 'red');
        label.text("Cognome non valido!");

        return false;
    } else {
        label.text("Cognome");
        label.css('color', '#707070');
        cognome.css('border-color', '#707070');


        return true;
    }

}

function passwordObserver() {

    var password = $('#password');
    var label = $('#password_l');
    var password_text = password.val();

    var reg = new RegExp(/^[a-zA-Z0-9!@#%*)(+=._-]{8,20}$/g);

    if (!reg.test(password_text)) {
        password.css('border-color', 'red');
        label.css('color', 'red');
        label.text("Password non valida, mimino 8 caratteri!");


        return false;

    } else {
        label.text("Password");
        label.css('color', '#707070');
        password.css('border-color', '#707070');

        return true;

    }

}


$(document).on("submit", "#fRegi", function (event) {

    emailObserver();
    let nome = nomeObserver();
    let cognome = cognomeObserver();
    let password = passwordObserver();

    if (emailGlobal && nome && cognome && password){

        return true;
    } else {
        return false;
    }
});




