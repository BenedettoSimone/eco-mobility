/*vedo se ci vuole la dark mode*/
window.onload = function provaDark(){

    div = document.getElementById("myOb-bar");
    list = document.getElementById("list");
    divrow=document.getElementById("myrow");
    if (window.innerWidth <= 1790) {

        div.appendChild(list);


    }


    if(window.innerWidth>1790){
        divrow.appendChild(list);
        closeBar();

    }

    var body = document.getElementById("body");
    let name = "darkmode=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');


    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            //alert(c.substring(name.length, c.length)+" cookie recuperato");

            body.className="dark-mode";
            document.getElementById('darkswitch').setAttribute("checked",true);
            document.getElementById('darkswitchD').setAttribute("checked",true);

            return;
        }
    }

    //alert("cookie non recuperato");
    body.className="light-mode";

}