var nav = document.getElementById("nav");
var navLi = nav.children;
for(var i = 0;i<navLi.length;i++){
	navLi[i].onmouseover = function(){
		this.className = "active";
	};
	navLi[i].onmouseout = function(){
		this.className = "";
	};
}