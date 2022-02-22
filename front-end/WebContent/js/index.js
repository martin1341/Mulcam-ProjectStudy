window.onload = function () {
    let banner = $("#banner-list");
    let first = $("#banner-list li:first-child").clone();
    banner.append(first);
    let last = $("#banner-list li:last-child").clone();
    banner.prepend(last);

    let current = 1;
    let width = first.width();
    banner.css("transform", "translateX(" + -width * current + "px)");

    function slide() {
        setInterval(function () {
            banner.css("transition", "2s");
            banner.css("transform", "translateX(-" + width * current + "px)");
            current++;

            if (current === 3) {
                setTimeout(function () {
                    banner.css("transition", "0s");
                    banner.css("transform", "translate3d(0px, 0px, 0px");
                }, 2001)
                current = 0;
            }
        }, 5000);
    }

    $(document).ready(slide);
}