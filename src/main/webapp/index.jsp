<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
	word=''; //Blank word
	partialUrl = '/GhostGame/game/word/'; //Partial url
	gameOver = false; //Flag indicating whether game is over or not
	waitingForResult = false; //Flag indicating whether waiting for server result or not
  	$("#b1").hide(); //Hide button
  	$("#b1").click(function(){ //Reset values on button click
  		word='';
  		gameOver = false;
  		waitingForResult = false;
  		$("#s2").text('');
  		$("#s1").text('Your turn, please press a valid key to enter your alphabet');
  		$("#b1").hide();
  	});
  	$(document).keypress(function(event){ //Any key is present
		if(gameOver == false && waitingForResult == false && 
       		event.which >= 65 && event.which <= 122) { //If key pressed is an alphabet
       		$("#b1").hide(); //Hide button
    		waitingForResult = true; //Waiting for result
    		word += String.fromCharCode(event.which).toLowerCase(); //Add alphabet to the word
    		$("#s2").text(word); //Update word string
     		url = partialUrl + word; //Create url
     		$("#s1").text('Processing...'); //Indicate processing
     		setTimeout(function (){ //Put a dealy of 1 second for server request
	         	$.getJSON(url, function(data) { //Get JSON result after posting to given url
					$.each(data, function(i, field) { //For each data of jSON result
						if(i == 'newWordString') { //If it is newWordString
							word = field; //Set word as newWordString
							$("#s2").text(word); //Update word string
						}
						else if(i == 'resultText') { //If it is resultText
							$("#s1").text(field); //Update message
				 		}
				 		else if(i == 'gameOver') { //If it is gameOver
							gameOver = field; //set gameOver flag
				 		}		
					});
					waitingForResult = false; //Waiting over
					if(gameOver) { //Change button text for starting a new game
		 				$("#b1").text('Start a new game');	
		 			}
		 			else { //Change button text for stopping and starting a new game
		 				$("#b1").text('Stop and start a new game');
		 			}
		 			$("#b1").show(); //Show button
		 		});
		 	}, 1000);
		}
  	}); 
});

</script>
</head>
<body>
<div><h1>Welcome to the game of Ghost</h1></div>
<p><i><span id="s1">Your turn, please press a valid key to enter your alphabet</span></i></p>
<p>Word string: <b><span id="s2"></span></b></p>
<button id="b1">Start a new game</button>

</body>
</html>