window.onload = function () {
    let banner = $("#banner ul");
    let first = $("#banner li:first-child").clone();
    banner.append(first);
    let last = $("#banner li:last-child").clone();
    banner.prepend(last);

    let current = 1;
    let width = Math.ceil(first.width());
    banner.css("transform", "translateX(" + -width * current + "px)");

    function slide() {
        setInterval(function () {
            current++;
            banner.css("transition", "2s");
            banner.css("transform", "translateX(" + -width * current + "px)");

            if (current === 3) {
                setTimeout(function () {
                    banner.css("transition", "0s");
                    banner.css("transform", "translateX(" + -width + "px)");
                }, 2001)
                current = 1;
            }
        }, 5000);
    }

    $(document).ready(slide);
}