
var url = window.location.href;

var title=document.title;

if (title=="Home") {
    document.getElementById("home").setAttribute('id', 'clicked');

} else if (title=="Spostamenti") {
    document.getElementById("spostamenti").setAttribute('id', 'clicked');

} else if (title=="Spese carburante") {
    document.getElementById("spesa").setAttribute('id', 'clicked');
}
else if (title=="Obiettivi") {
    document.getElementById("obiettivi").setAttribute('id', 'clicked');
}
else if (title=="Premi") {
    document.getElementById("premi").setAttribute('id', 'clicked');
}


    function openNav() {
    document.getElementById("mySidenav").style.width = "100%";
    document.getElementById("HamburgerBTN").style.visibility="hidden";
}

    function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
        document.getElementById("HamburgerBTN").style.visibility="visible";
}
