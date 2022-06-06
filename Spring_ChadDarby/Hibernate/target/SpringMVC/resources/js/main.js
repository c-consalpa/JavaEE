console.log(111)
btnPurgeEvents = document.getElementById("purgeEvents");
btnPurgeEvents.addEventListener("click", function (){
    console.log(123);
    var mRequest = new XMLHttpRequest();
    mRequest.open("GET", "http://localhost:8080/Hibernate_war_exploded/dropEvents");

    mRequest.send();
})