$("#bt-login").click(function()
	{
		$.ajax(
		{
			type: "POST",
			url: "rest/user/login",
			dataType: "applcation/json",
			data: {
				username: $("#username").val(),
				password: $("#password").val()
			},
			success: function(result,status,xhr){
				console.log(result);
				window.location = "www.baidu.com";
			},
			error: function(xhr,status,error){
				console.log(status);
				console.log(error);
			}
		}
		);
	}
);