
$(document).ready(function(e){
   
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
   
});