
$(document).ready(function () {
    timer.start(3);
});

var timer = (function() {
    var timeoutRef;
    var divElement;
    var count;

    return {

        start : function(givenTime) {
            count = givenTime;
            divElement = document.getElementById('lamp_4');
            timer.run();
        },

        run: function() {
            if (timeoutRef) clearInterval(timeoutRef);
            if (count > 0) {
                timeoutRef = setTimeout(timer.run, 1000);
            }
            count--;
            if(count == 0){
                timer.fire_ajax()
                timer.start(3)
            }
        },

        fire_ajax : function() {
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: "/getNoiseLevel",
                cache: false,
                timeout: 600000,
                success: function (data) {

                    if(data > 500){
                        divElement.style.backgroundImage = "url('silence_red.PNG')"
                    }else if(data > 400 && data < 500){
                        divElement.style.backgroundImage = "url('silence_orange.PNG')"
                    }else{
                        divElement.style.backgroundImage = "url('silence_green.PNG')"
                    }
                }
            });
        }
    }

}());

