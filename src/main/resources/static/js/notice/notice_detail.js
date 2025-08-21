console.log("notice_detail");

const btnDelete = document.getElementById("btn_delete");
const frm = document.getElementById("frm");

btnDelete.addEventListener("click", (e)=>{
	e.preventDefault()
	
	if(confirm("정말 삭제하시겠습니까?")) {
		frm.submit();
	}
	``
})