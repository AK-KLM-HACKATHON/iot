
$(document).ready(function () {
    timer.start(30);
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
            }
        },

        fire_ajax : function() {
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: "/getBaggageStatus",
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

