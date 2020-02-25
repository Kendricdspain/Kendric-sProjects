// TODO(you): Write the JavaScript necessary to complete the problem.

// You can access the RESULTS_MAP from "constants.js" in this file since
// "constants.js" has been included before "script.js" in index.html.

var flag = false;
var FirstDivsFlag = false;
var SecondDivsFlag = false;
var ThirdDivsFlag = false;


function checkAllDivs(){
	if (FirstDivsFlag && SecondDivsFlag && ThirdDivsFlag){
		console.log("Quiz Complete!!!")

		var resultDiv = document.createElement("div");
		var mainTest = document.createElement("div");
		var btn = document.createElement("div");
		btn.id = "mydiv";
		btn.innerHTML = "Restart Quiz";
		var t = document.createTextNode("Quiz Complete! You are definitely a Dog person.");
		resultDiv.style.textAlign = "center";
		btn.style.textAlign = "center";
		document.body.appendChild(resultDiv);
		resultDiv.appendChild(mainTest);
		mainTest.appendChild(t);
		mainTest.appendChild(btn);
		mainTest.style.display = "inline-block";
		mainTest.style.width = "49%";
		mainTest.style.paddingTop = "15px";
		btn.style.marginTop = "30px";
		btn.style.marginBottom = "30px";
		btn.style.backgroundColor = "#cecece";


		document.getElementById("mydiv").onmouseover = function() 
		{
		    this.style.backgroundColor = "#e0e0e0";
		    this.style.cursor = "pointer";
		}

		document.getElementById("mydiv").onmouseout = function() 
		{
		    this.style.backgroundColor = "#cecece";
		    this.style.cursor = "default";
		}

		document.getElementById("mydiv").onclick = function() 
		{
		    window.top.location = window.top.location;
		}
	

	}
	else{
		console.log("Quiz Incomplete!!!")
	}
}

function check(obj){

		var cbs = document.getElementsByName("FirstDivs");
		var child = obj.lastElementChild;

		
			for(var i=0; i<cbs.length; i++){
					cbs[i].lastElementChild.src = "images/unchecked.png";
					cbs[i].style["opacity"] = "0.6";
				}
				
				child.src = "images/checked.png";
				obj.style["opacity"] = "1";
				FirstDivsFlag = true;
				checkAllDivs();
					 
}

function check2(obj){

		var cbs = document.getElementsByName("SecondDivs");
		var child = obj.lastElementChild;

		
			for(var i=0; i<cbs.length; i++){
					cbs[i].lastElementChild.src = "images/unchecked.png";
					cbs[i].style["opacity"] = "0.6";
				}
				
				child.src = "images/checked.png";
				obj.style["opacity"] = "1";
				SecondDivsFlag = true;
				checkAllDivs();
}

function check3(obj){

		var cbs = document.getElementsByName("ThirdDivs");

		var child = obj.lastElementChild;

		
			for(var i=0; i<cbs.length; i++){
					cbs[i].lastElementChild.src = "images/unchecked.png";
					cbs[i].style["opacity"] = "0.6";
				}
				
				child.src = "images/checked.png";
				obj.style["opacity"] = "1";
				var temp = document.getElementById("div1-1")
				console.log(temp);
				ThirdDivsFlag = true;
				checkAllDivs();
					 
}