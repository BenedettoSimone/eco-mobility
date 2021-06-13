
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
}