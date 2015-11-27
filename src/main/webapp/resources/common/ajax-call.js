/**
 * 
 */

var ajaxParams= {url:"", data:"", formType: ""};

function ajaxRequest(){
	$.ajax({
		async: false,
		url: ajaxParams.url,
		type: "POST",
		data: ajaxParams.data,
		success: function(response){
			setResponse(response);
		},
		error: function(){
			
		}
	});
}

function setResponse(response){
	alert(response);
	switch(ajaxParams.formType){
	
	case "module":{
		if(response == true){
			$("[name='moduleName']").parent().append('Module Already Exist');
			return false;
		}else{
			return true;
		}
	}
	}
}