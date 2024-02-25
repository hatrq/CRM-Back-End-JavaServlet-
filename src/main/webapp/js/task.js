$(document).ready(function (){
    $(".btn-deleteJob").click(function (){
        let id = $(this).attr("id-Job");
        let This = $(this);
        console.log(id);
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/MY_CRM_PROJECT/api/task/delete?id="+id,
        })
            .done(function (result){
                if (result.data === true){
                    alert("Delete Job Success!");
                    This.closest("tr").remove();
                }
                console.log(result.data)
            })
    })
})