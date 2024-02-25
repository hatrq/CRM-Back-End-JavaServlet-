$(document).ready(function (){
    $(".btn-updateUser").click(function (){
        var id = $(this).attr("id-userUpdate1");
        var email = document.getElementById("email-update").value;
        var password = document.getElementById("password-update").value;
        var firstName = document.getElementById("firstName-update").value;
        var lastName = document.getElementById("lastName-update").value;
        var userName = document.getElementById("userName-update").value;
        var phoneNumber = document.getElementById("phoneNumber-update").value;
        var idRole = document.getElementById("idRole-update").value;
        $.ajax({
            method: "GET",
            url: `http://localhost:8080/api/user/update?id=${id}&email=${email}&password=${password}&firstName=${firstName}&lastName=${lastName}&userName=${userName}&phone=${phoneNumber}&idRole=${idRole}`,
        })
            .done(function (result){
                console.log(result.data);
            })
    })
})