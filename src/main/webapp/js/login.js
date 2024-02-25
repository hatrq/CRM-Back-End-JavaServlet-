$(document).ready(function (){
    $(".btn-submitLogin").click(function (){
        let email = $(this).attr($(".btn-emailInput"));
        let pass = $(this).attr($(".btn-passwordInput"));
        $.ajax({
            method: "POST",
            url: `http://localhost:8080/MY_CRM_PROJECT/login?email=${email}&password=${pass}`,
        })
            .done(function (result){
                if (result.data === true){
                    alert("Login Success!");
                } else {
                    alert("Email or Password is not correct!");
                }
                console.log(result.data);
            })

    })

})