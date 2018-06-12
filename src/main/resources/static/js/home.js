
$(document).ready(function () {
    timer.start(3);
});

var timer = (function() {
    var timeoutRef;
    var timerElement;
    var count;

    return {

        start : function(givenTime) {
            count = givenTime;
            timerElement = document.getElementById('timer-id');
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
                    if (timerElement) {
                        var html = "<progress value="+data+" max=\"100\"></progress>"
                        timerElement.innerHTML = html;
                    }

                }
            });
        }
    }

}());

