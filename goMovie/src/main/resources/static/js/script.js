
    //NAVBAR
    const body = document.querySelector("body"),
          nav = document.querySelector("nav"),
          modeToggle = document.querySelector(".dark-light"),
          searchToggle = document.querySelector(".searchToggle"),
          sidebarOpen = document.querySelector(".sidebarOpen"),
          siderbarClose = document.querySelector(".siderbarClose");

    //search box
    searchToggle.addEventListener("click" , () =>{
    searchToggle.classList.toggle("active");
    });

    //sidebar
    sidebarOpen.addEventListener("click" , () =>{
        nav.classList.add("active");
    });

    body.addEventListener("click" , e =>{
        let clickedElm = e.target;

        if(!clickedElm.classList.contains("sidebarOpen") && !clickedElm.classList.contains("menu")){
            nav.classList.remove("active");
        }
    });




    //SLIDESHOW
    let slideIndex = 1;
    let autoPlayInterval = 5000;
    let isAutoPlaying = true;
    let autoPlayTimer;

    function showSlide(n) {

      const slides = document.querySelectorAll("#slideshow img");
      const currentSlide = slides[n - 1];
      slides.forEach((slide) => (slide.style.opacity = "0"));
      currentSlide.style.opacity = "1";

    }

    function nextSlide(direction) {

        const slides = document.querySelectorAll("#slideshow img");
        slideIndex += direction;

        if (slideIndex > slides.length) {

            slideIndex = 1;

        }

        if (slideIndex < 1) {

            slideIndex = slides.length;

        }

        showSlide(slideIndex);

    }

    function autoSlide() {

        if (isAutoPlaying) {
            nextSlide(1);
            autoPlayTimer = setTimeout(autoSlide, autoPlayInterval);
        }
    }

    autoSlide();

	// ANCLAJE
	window.onload = function() {
		var currentPage = window.location.pathname;
		var pagesToScroll = ["/fantasia", "/drama", "/romantico", "/comedia", "/infantil", "/accion", "/todas"];
	
		if (pagesToScroll.includes(currentPage)) {
			var element = document.getElementById("separador");
			
			if (element) {
				element.scrollIntoView({ behavior: 'smooth' });
			}
		}
	};
	
		