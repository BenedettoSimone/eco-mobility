var div = document.getElementById("mySidebar");
var list = document.getElementById("list");
var divrow=document.getElementById("myrow");
window.onresize = function myFunction() {

    if (window.innerWidth <= 1540) {

        div.appendChild(list);

    }

    if(window.innerWidth > 1540){


        divrow.appendChild(list);
    }
}
window.onload = function myFunction() {
    div = document.getElementById("mySidebar");
    list = document.getElementById("list");
    divrow=document.getElementById("myrow");
    if (window.innerWidth <= 1540) {

        div.appendChild(list);

    }


    if(window.innerWidth>1540){

        divrow.appendChild(list);
    }
}

function openBar() {
    document.getElementById("mySidebar").style.width = "50%";
    list.style.width="100%";
    list.style.backgroundColor="#5a87e8";
    list.style.padding="25px 30px 0 30px"


}

function closeBar() {
    document.getElementById("mySidebar").style.width = "0px";

    div = document.getElementById("mySidebar");
    list = document.getElementById("list");

    list.style.width="20%";
    list.style.backgroundColor="white";
    list.style.padding="130px 30px 0 30px"

    divrow.appendChild(list);
}
