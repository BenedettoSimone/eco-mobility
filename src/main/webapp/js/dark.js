/*funzione associata al button*/
function darkMode(){

    /*
    document.querySelector('.wave').classList.toggle('active');
    */
    var body = document.getElementById("body");
    var currentClass = body.className;

    /*se è impostata la dark mode allora già c'è il cookie quindi lo distruggo*/
    if(currentClass== "dark-mode"){
        body.className="light-mode";

        document.cookie = "darkmode= ; expires = Thu, 01 Jan 1970 00:00:00 GMT";

    }else {
        /*se la dark mode non è impostata allora creo il cookie*/
        body.className="dark-mode";

        /*creo il cookie della durata di un giorno*/
        const d = new Date();
        d.setTime(d.getTime() + (1*24*60*60));
        let expires = "expires="+ d.toUTCString();
        document.cookie = "darkmode" + "=" + "true" + ";" + expires;
    }

}