function createEmp() {
    var x = document.getElementById("empData");
    var text = "";
    var i;
    var val ='value'
    var jsonObj = {};
    for (i = 0; i < x.length - 1 ;i++) { // minus one use to remove submit value from form
        if (x.elements[i].name) {
            jsonObj[x.elements[i].name] = x.elements[i].value;
        }
    }
    text = JSON.stringify(jsonObj);
    console.log(text);


    $.ajax({

        url: 'http://localhost:8080/employees',
        method : 'POST',
        contentType: "application/json; charset=utf-8",
        dataType : "json",
        data: text,
        success : function(result) {}
    })
    Redirect();
    return false;
}

function getEmployees(){

     $.getJSON("http://localhost:8080/employees", function(data){
        //console.log(data);
        loadEmployees(data);
        //console.log(employeeList);
        // $.each(data, function (index, value) {
        //     employeeList = data;
        //     console.log(value);
        // });
    });
}

function loadEmployees(data) {
    var empList = data;
    //console.log(empList);

    createTable(empList);



}


function Redirect() {
    //setting variable for redirected page
    var name = document.getElementById('empData');
    localStorage.setItem("name", name.firstname.value);
    console.log("name is: -->" + name.firstname.value);

    window.location="http://localhost:8080/submit.html";

}

function loadName(){

    var name = localStorage.getItem("name");

    var message = document.getElementById("fname");

    message.innerText = name;

}

function createTable(data){
    var empDetails = data;

    console.log(empDetails[2].length);
    //console.log(empDetails[3].firstname);
    var myTableDiv = document.getElementById("tableDiv");
    var table = document.createElement('TABLE');
    var tableBody = document.createElement('TBODY');
    var div = document.getElementById("myTable");

    table.border = '1'
    table.appendChild(tableBody);

    var tr = document.createElement('TR');
    var td = document.createElement('TD');

    for(var i = 0; i < empDetails.length; i++){
        // var btn = document.createElement("BUTTON");
        // btn.onclick(function(){
        //
        //
        //
        // });

        var tr = document.createElement('TR');
        var td = document.createElement('TD');
        var td2 = document.createElement('TD');
        td.appendChild(document.createTextNode(empDetails[i].firstname));
        td2.appendChild(document.createTextNode(empDetails[i].lastname));
        tr.appendChild(td);
        tr.appendChild(td2);

        tableBody.appendChild(tr);
    }

    div.append(tableBody)
    //myTableDiv.appendChild(table)


}


