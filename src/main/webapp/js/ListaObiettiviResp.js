var div = document.getElementById("myOb-bar");
var list = document.getElementById("list");
var divrow=document.getElementById("myrow");
window.onresize = function myFunction() {

    if (window.innerWidth <= 1790) {

        div.appendChild(list);


    }

    if(window.innerWidth > 1790){


        divrow.appendChild(list);
        closeBar();
    }
}
window.onload = function myFunction() {
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
}

function openBar() {
    document.getElementById("myOb-bar").style.width = "400px";
    list.style.width="100%";
    list.style.backgroundColor="#fff";
    list.style.padding="25px 25px 0 30px"


}

function closeBar() {
    document.getElementById("myOb-bar").style.width = "0px";

    div = document.getElementById("myOb-bar");
    list = document.getElementById("list");

    list.style.width="20%";
    list.style.backgroundColor="white";
    list.style.padding="130px 30px 0 30px"
}
