$(document).ready(function (){
    $(".btn-deleteProject").click(function (){
        let id = $(this).attr("id-project");
        let This = $(this);
        $.ajax({
            method: "GET",
            url: `http://localhost:8080/MY_CRM_PROJECT/api/project/delete?id=${id}`,
        })
            .done(function (result){
                if (result.data === true){
                    alert("Delete Project Success!");
                    This.closest("tr").remove();
                }
                console.log(result.data)
            })
    })
})