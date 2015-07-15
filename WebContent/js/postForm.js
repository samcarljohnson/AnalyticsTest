/**
 * 
 * 
 */

var xmlstr = 
      "<reportExecutionRequest>"+
       "<reportUnitUri>/reports/userdata_files/main_jrxml</reportUnitUri>"+
       "<async>true</async>"+
       "<freshData>false</freshData>"+
       "<saveDataSnapshot>false</saveDataSnapshot>"+
       "<outputFormat>html</outputFormat>"+
       "<interactive>false</interactive>"+
       "<ignorePagination>false</ignorePagination>"+
       "<pages>1-5</pages>"+
       "<parameters>"+
           "<reportParameter name=\"someParameterName\">"+
               "<value>value 1</value>"+
               "<value>value 2</value>"+
           "</reportParameter>"+
           "<reportParameter name=\"someAnotherParameterName\">"+
               "<value>another value</value>"+
           "</reportParameter>"+
       "</parameters>"+
     "</reportExecutionRequest>";

var person = {
  name: "sam",
  age: 22,
  hometown: "Dallas",
  profession: "student",
};

var nested_person = {
    name: "TESTING",
    age: 22,
    address: {
      street: "6718 Windrock Rd",
      city: "Dallas",
      state: "Texas",
      zip: 75252
    },
    profession: "student",
  };






$(document).ready(function(){
  
  $("form").submit(function(event){
    $("#return").text("").show();
    var data = $("form").serialize();
    var postData = $.ajax({
      method: "POST",
      url: "http://localhost:8080/AnalyticsTest/login",
      data: data
    });
    postData.done(function(msg){
      $("#return").text(msg).show().fadeOut(2000);
    });
    event.preventDefault();
  });
  
  
  $(".working-post").click(function(event){
    $("#return").text("").show();
    var postData = $.ajax({
      method   : "POST",
      url      : "http://rest.learncode.academy/api/scjohnson/test",
      data: nested_person,
      success: function(data, textStatus, jqXHR) {
        console.log(data); //data - response from server
        $('#return').text(JSON.stringify(data));
      },
      error: function (jqXHR, textStatus, errorThrown) {
        console.log("There was an error somewhere.");
      }
    });
  });
  
  $(".jasper").click(function(event){
    $("#return").text("").show();
    var postData = $.ajax({
      method   : "POST",
      //url      : "http://127.0.0.1:5433/jasperserver/rest_v2/reportExecutions", //SEND 'xmlstr'
      url      : "http://127.0.0.1:8080/jasperserver/rest_v2/serverInfo",
      username: "jasperadmin",
      password: "jasperadmin",
      data: person,
      success: function(data, textStatus, jqXHR) {
        console.log(data); //data - response from server
        //$("#return").html(data).show();
      },
      error: function (jqXHR, textStatus, errorThrown) {
        console.log("There was an error somewhere.");
      }
    });
  });
  
  
  
// end of document ready function  
});
  
$(".button").click(function(event){
  $.getJSON(
    "router", 
    "id="+$(this).attr("id"),
    function(data) {
      var $table = $('<table>').appendTo($('#return'));
      $.each(data, function(idx, account) {
        $('<tr>').appendTo($table)
          .append($('<td>').text(account.name))
          .append($('<td>').text(account.industry))
          .append($('<td>').text(account.country))
          .append($('<td>').text(account.phone));
      });
    }
  );
});