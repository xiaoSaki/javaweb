$(function(){
	$('#registerName').blur(function(){
		var oRegisterName = $('#registerName').val();
		var oRegisterPasswd = $('#registerPasswd').val();
		
		if(oRegisterName==''){
			$('#userCue').text('账号不能为空');
			$('.cue').css('color','red');
			//$('#reg').css({'background':'#d0d0d0','border-bottom':' 1px solid #999','cursor':'not-allowed'});
		}
		else{
			$('#userCue').text('快速注册账号密码不能为空');
			$('.cue').css('color','black');
		}
		
	//		if(oRegisterName!='' && oRegisterPasswd!=''){
	//			$('#reg').css({'background':'#2795dc','border-bottom':'3px solid #0078b3','cursor':'pointer'});
	//		}
	})
	
	
	$('#registerPasswd').blur(function(){
		var oRegisterPasswd = $('#registerPasswd').val();
		var oRegisterName = $('#registerName').val();
		if(oRegisterPasswd==''){
			$('#userCue').text('密码不能为空');
			$('.cue').css('color','red');
		}
		else{
			$('#userCue').text('快速注册账号密码不能为空');
			$('.cue').css('color','black');
		}
//		if(oRegisterName!='' && oRegisterPasswd!=''){
	//		$('#reg').css({'background':'#2795dc','border-bottom':'3px solid #0078b3','cursor':'pointer'});
//		}
	})
	
	
	$('.inputArea').click(function(){
		var oRegisterPasswd = $('#registerPasswd').val();
		var oRegisterName = $('#registerName').val();

		if(oRegisterName=='' || oRegisterPasswd==''){			
			$('.inputArea input').attr('type','button');
		}
		
		if(oRegisterName!='' && oRegisterPasswd!=''){
			$('.inputArea input').attr('type','submit');
		}
	})
	
});