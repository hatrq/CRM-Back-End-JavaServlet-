$(document).ready(function (){
    $(".btn-deleteRole").click(function (){
        let id = $(this).attr("id-role");
        let This = $(this);
        $.ajax({
            method: "GET",
            url: `http://localhost:8080/MY_CRM_PROJECT/api/role/delete?id=${id}`,
        })
            .done(function (result){
                if (result.data === true){
                    alert("Delete Role Success!");
                    This.closest("tr").remove();
                }
                console.log(result.data)
            })
    })
})
