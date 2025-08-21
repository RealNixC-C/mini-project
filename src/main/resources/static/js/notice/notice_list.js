console.log("board_list")

const pn = document.querySelectorAll(".pn");
const pn2 = document.getElementsByClassName("pn");
const frmSearch = document.getElementById("frm-search");
const pageNum = document.querySelector("#pageNum");

console.log(pn);
console.log(pn2);
console.log(frmSearch);
console.log(pageNum);

pn.forEach(function (el) {
	el.addEventListener("click", ()=> {
		let n = el.getAttribute("data-pn");
		pageNum.value=n;
		console.log(n)
		frmSearch.submit();
	})
})