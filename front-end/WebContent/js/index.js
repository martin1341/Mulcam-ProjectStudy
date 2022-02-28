window.onload = function () {
    let banner = $("#banner ul");
    let first = $("#banner li:first-child").clone();
    banner.append(first);

    let current = 0;
    let width = Math.ceil(first.width());

    function slide() {
        setInterval(function () {
            banner.css("transition", "2s");
            banner.css("transform", "translateX(" + -width * (current + 1) + "px)");
            current++;

            if (current === 2) {
                setTimeout(function () {
                    banner.css("transition", "0s");
                    banner.css("transform", "translateX(0px)");
                }, 2000)
                current = 0;
            }
        }, 5000);
    }

    $(document).ready(slide);
}