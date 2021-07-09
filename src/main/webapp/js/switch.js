window.onresize = function myFunction() {

    div = document.getElementById("links_resp");
    list = document.getElementById("switchD");
    divrow=document.getElementById("user");
    if (window.innerWidth <= 1500) {

        div.appendChild(list);


    }

    if(window.innerWidth > 1500){


        divrow.appendChild(list);
        closeBar();
    }
}
window.onload = function myFunction() {
    div = document.getElementById("links_resp");
    list = document.getElementById("switchD");
    divrow=document.getElementById("user");
    if (window.innerWidth <= 1500) {

        div.appendChild(list);


    }


    if(window.innerWidth>1500){
        divrow.appendChild(list);


    }
}
