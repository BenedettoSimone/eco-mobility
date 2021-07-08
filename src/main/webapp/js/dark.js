/*funzione associata al button*/
function darkMode(){

    /*creo il cookie della durata di un giorno*/
    const d = new Date();
    d.setTime(d.getTime() + (1*24*60*60));
    let expires = "expires="+ d.toUTCString();
    document.cookie = "darkmode" + "=" + "true" + ";" + expires;

    /*
    document.querySelector('.wave').classList.toggle('active');
    */
    var body = document.getElementById("body");
    var currentClass = body.className;

    if(currentClass== "dark-mode"){
        body.className="light-mode";

        /*cerco il cookie*/
        let name = "darkmode=";
        let decodedCookie = decodeURIComponent(document.cookie);
        let ca = decodedCookie.split(';');
        for(let i = 0; i <ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                /*se non voglio la dark mode distruggo il cookie*/
                document.cookie = "darkmode= ; expires = Thu, 01 Jan 1970 00:00:00 GMT"
            }
        }

    }
    else {
        body.className="dark-mode";
    }

}