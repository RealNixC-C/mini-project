console.log("pet-add");
const imgDelete = document.getElementById("img_delete");

if(imgDelete) {
	imgDelete.addEventListener("click", ()=>{
		
		let flag = confirm("정말 삭제하시겠습니까?");
		if(!flag) return;
	
		const attachNo = imgDelete.getAttribute("data-attach-no");
		const petNo = document.getElementById("petNo").value;
		let params = new URLSearchParams();
		params.append("attachNo", attachNo);
		fetch(`./fileDelete`, {
			method : "post",
			body : params
		})
		.then(r=>r.text())
		.then(r=>{
			if(r==1){
				alert('삭제 성공');
				location.href="./update?petNo=" + petNo
			} else {
				alert('삭제 실패');
			}
		})
	})
}