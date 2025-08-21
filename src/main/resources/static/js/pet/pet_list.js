console.log("pet_list")

const pn = document.querySelectorAll(".pn");
const pageNum = document.querySelector("#pageNum");

console.log(pn);
console.log(pageNum);

pn.forEach(function (el) {
	el.addEventListener("click", ()=> {
		let n = el.getAttribute("data-pn");
		console.log(n)
		location.href="./list?pageNum=" + n;
	})
})