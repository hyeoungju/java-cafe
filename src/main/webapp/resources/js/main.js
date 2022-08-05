$('.category_name').on('click', function(){
       var categoryId = $(this).attr('value')
       console.log(categoryId)
       $(".category_name").each(function(index, el){
          $(el).removeClass("active")
          $(".menuItem_ul").empty()
       })
       $(this).addClass("active")
       if($(this).hasClass("active") == true){
         $.ajax({
             url: "requestObject",
             type: "POST",
             contentType: "application/json; charset=utf-8", 
             dataType: "text",
             data: JSON.stringify({
          'categoryId': categoryId
          }),
            success: function(data){
             var html = ""
          $.each(JSON.parse(data), function(index, el){
             html = "<li class='menuItem'><a class='modal-btn' data-toggle='modal' data-target='#exampleModal'>"
             html += "<img src=/java-cafe/resources/menuImg/" + el.menuImgName + ">"
             html += "<p class='menu_text'>" + el.menuName + "</p><p class='menu_text'>" + el.menuPrice + "원</p></a><li>"
             $(".menuItem_ul").append(html)
          })   
           },
           error: function(){
               alert("simpleWithObject err");
           }
       });         
	 }
	});
   
   $(document).on('click', '.modal-btn', function() {
	   console.log($(this))
	   let menuImgName = $(this).find('img').attr('src').split('/')[4]
	   console.log(menuImgName)
	   $(".modal-body").empty();
	  $.ajax({
	               url: "requestForModal",
	               type: "POST",
	               contentType: "application/json; charset=utf-8",
	               dataType: "text",
	               data: JSON.stringify({
	            'menuImgName': menuImgName
	            }),
	              success: function(data){
	            
	               console.log(JSON.parse(data))
	               var data = JSON.parse(data)
	              var html = '<form name="form" class="modal-form"><img src=/java-cafe/resources/menuImg/' + data.menuImgName + '>'
	            html += '<input type="hidden" name="menuImgName" value="' + data.menuImgName + '">'
	            html += '<div class="text-area"><span class="menu_name">'+ data.menuName+'</span>'
	            html += '<input type="hidden" name="menuItemName" value="' + data.menuName + '">'
	            html += '<span class="menu_price">' + data.menuPrice + '원</span>'
	            html += '<input type="hidden" name="menuPrice" value="' + data.menuPrice + '">'
	            html += '<input type="number" class="numberInput" name="purchaseQuantity" value="1" />'
	            html += '<div class="text-area_btngrp"><button type="submit" formaction="view_menuItemList" formmethod="post">카트담기</button>'
	            html += '<button type="submit" formaction="buyMenu" formmethod="post">바로구입</button></div></div></form>'
	            $(".modal-body").append(html)
	            
	             },
	             error: function(){
	                 alert("simpleWithObject err");
	             }
	         });
	})
	
	window.onload = function(){
	   var total = $(".total_price")
	   var sum = 0
	   $(".cart_menuPrice").each(function(index, el){
	      let money = $(el).text().split("원")[0]
	      console.log(money)
	      sum += Number(money)
	   })
	   total.text("총액 : " + sum + "원")
	   
	};