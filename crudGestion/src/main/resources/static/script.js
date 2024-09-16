function deleteProd(id){
	Swal.fire({
	  title: "Estas seguro de eliminar?",
	  text: "You won't be able to revert this!",
	  icon: "warning",
	  showCancelButton: true,
	  confirmButtonColor: "#3085d6",
	  cancelButtonColor: "#d33",
	  confirmButtonText: "Yes, delete it!"
	}).then((result) => {
	  if (result.isConfirmed) {
		$.ajax({
			url:"/delete/"+id,
			success: function(res) {
				console.log(res);
			}
		});
	    Swal.fire({
	      title: "Deleted!",
	      text: "Your file has been deleted.",
	      icon: "success"
	    }).then((ok)=>{
			if(ok){
				location.href="/listar";
			}
		});
	  }
	});
}/**
 * 
 */