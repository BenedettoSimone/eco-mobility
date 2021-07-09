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


            return;
        }
    }

    //alert("cookie non recuperato");
    body.className="light-mode";



    div1 = document.getElementById("links_resp");
    list1 = document.getElementById("switchD");
    divrow1=document.getElementById("user");
    if (window.innerWidth <= 1080) {

        div1.appendChild(list1);


    }


    if(window.innerWidth>1080) {
        divrow1.appendChild(list1);


    }




}

window.onresize = function myFunction() {

    div2 = document.getElementById("links_resp");
    list2 = document.getElementById("switchD");
    divrow2=document.getElementById("user");
    if (window.innerWidth <= 1080) {

        div2.appendChild(list2);


    }

    if(window.innerWidth > 1080){


        divrow2.appendChild(list2);
        closeBar();
    }




}