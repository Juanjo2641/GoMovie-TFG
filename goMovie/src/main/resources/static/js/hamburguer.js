		//MENU HAMBURGUESA
		
		var menu = document.querySelector('.hamburger');

	// method
		function toggleMenu (event) {
  		this.classList.toggle('is-active');
  		document.querySelector( ".nav-links" ).classList.toggle("is_active");
  		event.preventDefault();
	}

	// event
		menu.addEventListener('click', toggleMenu, false);
	
