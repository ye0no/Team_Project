  function readURL(input)
  {
	  if(input.files && input.files[0]){
		  var reader=new FileReader();
		  reader.onload=function(e){
			  document.getElementById('food_img').src=e.target.result;
							
		  };
		  reader.readAsDataURL(input.files[0]);
		  
	  }else{
		  document.getElementById('food_img').src="";
	  }
  }
  
  
  function readURL2(input)
  {
	  if(input.files && input.files[0]){
		  var reader=new FileReader();
		  reader.onload=function(e){
			  document.getElementById('food_img2').src=e.target.result;
							
		  };
		  reader.readAsDataURL(input.files[0]);
		  
	  }else{
		  document.getElementById('food_img2').src="";
	  }
  }
  
  

  function readURL3(input)
  {
	  if(input.files && input.files[0]){
		  var reader=new FileReader();
		  reader.onload=function(e){
			  document.getElementById('food_img3').src=e.target.result;
							
		  };
		  reader.readAsDataURL(input.files[0]);
		  
	  }else{
		  document.getElementById('food_img3').src="";
	  }
  }