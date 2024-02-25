$(document).ready(function (){
    $(".btn-deleteUser").click(function (){
        var id = $(this).attr("id-user");
        var This = $(this)
        $.ajax({
            method: "GET",
            url: `http://localhost:8080/MY_CRM_PROJECT/api/user/delete?id=${id}`,
        })
            .done(function (result){
                if (result.data === true){
                    alert('Deleted User Success!');
                    This.closest("tr").remove();
                }
                console.log(result.data)
            });
    })
})