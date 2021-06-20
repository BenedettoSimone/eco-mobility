
var url = window.location.href;


if (url.includes("home")) {
    document.getElementById("home").setAttribute('id', 'clicked');

} else if (url.includes("index")) {
    document.getElementById("spostamenti").setAttribute('id', 'clicked');

} else if (url.includes("spesa")) {

    document.getElementById("spesa").setAttribute('id', 'clicked');
}
else if (url.includes("obiettivi")) {

    document.getElementById("obiettivi").setAttribute('id', 'clicked');
}
else if (url.includes("premi")) {

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
