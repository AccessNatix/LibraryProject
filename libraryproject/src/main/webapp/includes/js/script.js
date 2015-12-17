$(document).ready(function(e){
    
    $(document).on('keyup', '#s', function(e){
        if(e.keyCode==13)
            $('form#searchForm').submit();
    });
    
    $(document).on('click', '.edit', function(e){
        if(!$(this).hasClass('change-page')){
            $(this).addClass('hidden');
            $(this).parent().find('.btn').removeClass('hidden');
            $(this).parent().parent().find('.span-text').addClass('active');
            return false;
        }
    });
   
   $(document).on('click', '.menuOption', function(e){
       var id = $(this).attr('id');
       $('.menuOption').removeClass('active');
       $(this).addClass('active');
       if(id === "content"){
           $('#updownload').addClass('hidden').fadeOut(100);
           $('#contentmanager').removeClass('hidden').fadeIn(1000);
           
       }else if(id === "loader"){
           $('#contentmanager').addClass('hidden').fadeOut(100);
           $('#updownload').removeClass('hidden').fadeIn(1000);
       }
   });
   
   
   $('.relativeContainer').height($('#signup').height());
   
   if(getUrlParameter("signin")===true && getUrlParameter("string")===undefined){
       $('#signup').css('right', "100%");
       $('#signin').css('display: block');
       switchToSingin();
   }
   if(getUrlParameter("string")==="ERROR_SIGNIN"){
       $('#error-signin-msg').css('display', 'block').text("Invalid username/password !");
   }else if(getUrlParameter("string")==="ERROR_REGISTER_EXISTS"){
       $('#error-signup-msg').css('display', 'block').text("Username or Email alreay exists!");
   }else if(getUrlParameter("string")==="ERROR_REGISTER_PASSWORD"){
       $('#error-signup-msg').css('display', 'block').text("Please enter the same password in the repeat password field!");
   }else if(getUrlParameter("string")==="ERROR_NO_STOCK"){
       $('#error-msg').css('display', 'block').text("No stock anymore");
   }else if(getUrlParameter("string")==="ERROR_FULL_BORROW"){
       $('#error-msg').css('display', 'block').text("Return one book before borrowing a new one");
   }else if(getUrlParameter("string")==="ERROR_SAME_BOOK"){
       $('#error-msg').css('display', 'block').text("You already borrowed this book!");
   }
   
   $(document).on('click', 'a#signinlnk', function(e){
        var pathname = window.location.pathname;
        if($.trim(pathname)==="/libraryproject/register"){
            switchToSingin();
            return false;
        }
   });
   $(document).on('click', 'a#signuplnk', function(e){
        $('#signin').fadeOut();
        $('#signup').animate({right: "0%"}, 1000);
        return false;
   });
   
   function switchToSingin(){
       $('#signup').animate({right: "100%"}, 1000);
       $('#signin').fadeIn();
   };
   
    function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;

        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');

            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };
    
    $('#stock').hover(function(e){
        $('#bull').css('margin-top',$('#stock').height()*3).show();
    }, function(e){
        $('#bull').hide();
    });
    
   $( "#contentmanager" ).accordion({
      collapsible: true, 
      icons : null,
      heightStyle: "content"
    });
   
});