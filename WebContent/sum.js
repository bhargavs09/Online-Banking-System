/**
 * 
 */

var balance ;
var x;
var z;
var su;
function f1() {
  		//alert('fired: f1');
		x = document.getElementById("myNumber").value;
		z = x ;
		document.getElementById("demo").innerHTML = z;
	}
	
function f2(){

	document.getElementById("dem").innerHTML = myfunc(balance,z) ;
	
}

function myfunc(a,b){
	return  a+b;
	
}