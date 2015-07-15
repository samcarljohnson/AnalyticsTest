/**
 * 
 */

$(document).ready(function(){
  $("form").submit(function(event){
    $("#return").text("").show();
    
    var data = $("form").serialize();

    var postData = $.ajax({
      method: "POST",
      url: "http://localhost:8080/AnalyticsTest/addData",
      data: data
    });
    
    postData.done(function(msg){
      $("#return").text(msg).show().fadeOut(2000);
    });
    
    event.preventDefault();
  });
});