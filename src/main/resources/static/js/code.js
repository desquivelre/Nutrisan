$(document).ready(function() {




	$('#exampleModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget)
		var id = button.data('id');
		var price = button.data('price');
		var name = button.data('name');

		var modal = $(this)
		modal.find('.modal-title').text('Plataforma de Pago')
		modal.find('#pagar').text('Total: S/ ' + price)
		modal.find('#planelegido').text('Nutrisan: ' + name + ' Plan')


	})


});   