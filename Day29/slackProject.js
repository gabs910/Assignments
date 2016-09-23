var slackToken = getSlackToken();

$(document).ready(function(){
var msg=" ";


   $.ajax("https://slack.com/api/groups.list", {
	   data: {
		   token: slackToken
		   
	   },
   method: "POST"
   }).then(function(groupsList){
       for(var count = 0; count < groupsList.groups.length; count++)
       {
           var newChannelBtn = $("<input type='radio' name='channel' value="+groupsList.groups[count].name+"> " + groupsList.groups[count].name + "</input><br>");
           $("#private").append(newChannelBtn);
       }
       console.log(groupsList);
   });



// GET CHANNEL NAMES
   $.ajax("https://slack.com/api/channels.list", {
	   data: {
		   token: slackToken
		   
	   },
   method: "POST"
   }).then(function(channelsList){
       for(var count = 0; count < channelsList.channels.length; count++)
       {
           var newChannelBtn = $("<input type='radio' name='channel' value="+channelsList.channels[count].name+"> " + channelsList.channels[count].name + "</input><br>");
           $("#public").append(newChannelBtn);
       }
       console.log(channelsList);
   });
	
function postButton(msg,channel){
$.ajax("https://slack.com/api/chat.postMessage", {
  data: {
     token: slackToken,
    channel: channel,
	username:"this-guy",
    text: msg
  },
   method: "POST"
})

}
$("#post").click(function() {
var text = $("#textbox").val();
var channel=$('input[name="channel"]:checked').val();
postButton(text,channel);
$("#textbox").val('');
})

$('#textbox').keypress(function (e) {
var key = e.which;
if(key == 13)  // the enter key code
 {
   $("#post").click();
   return false;  
 }
})

      jQuery('#min').on('click', function(event) {        
             jQuery('#private').toggle('show');
			 
        });
})



