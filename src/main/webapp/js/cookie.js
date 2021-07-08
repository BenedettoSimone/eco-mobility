/*vedo se ci vuole la dark mode*/
window.onload = function provaDark(){
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


            return;
        }
    }

    //alert("cookie non recuperato");
    body.className="light-mode";




}