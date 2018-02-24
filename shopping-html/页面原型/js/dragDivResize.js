(function ($) {
    $.fn.dragDivResize = function () {
        var deltaX, deltaY, _startX, _startY;
        var resizeW, resizeH;
        var size = 20;
        var minSize = 10;
        var scroll = getScrollOffsets();
        var _this = this;
        for (var i = 0; i < _this.length; i++) {
            var target = this[i];
            $(target).on("mouseover mousemove", overHandler);
        }
        function outHandler() {
            for (var i = 0; i < _this.length; i++) {
                target.style.outline = "none";
            }
            document.body.style.cursor = "default";
        }
        function overHandler(event) {
            target = event.target || event.srcElement;
            var startX = event.clientX + scroll.x;
            var startY = event.clientY + scroll.y;
            var w = $(target).width();
            var h = $(target).height();
            _startX = parseInt(startX);
            _startY = parseInt(startY);
            if ((0 < target.offsetLeft + w - _startX && target.offsetLeft + w - _startX < size) || (0 < target.offsetTop + h - _startY && target.offsetTop + h - _startY < size)) {
                target.style.outline = "1px solid #438eb9";
                if ((0 > target.offsetLeft + w - _startX || target.offsetLeft + w - _startX > size) && 0 < target.offsetTop + h - _startY && target.offsetTop + h - _startY < size) {
                    resizeW = false;
                    resizeH = true;
                    document.body.style.cursor = "s-resize";
                }
                if (0 < target.offsetLeft + w - _startX && target.offsetLeft + w - _startX < size && (0 > target.offsetTop + h - _startY || target.offsetTop + h - _startY > size)) {
                    resizeW = true;
                    resizeH = false;
                    document.body.style.cursor = "w-resize";
                }
                if (0 < target.offsetLeft + w - _startX && target.offsetLeft + w - _startX < size && 0 < target.offsetTop + h - _startY && target.offsetTop + h - _startY < size) {
                    resizeW = true;
                    resizeH = true;
                    document.body.style.cursor = "se-resize";
                }
                $(target).on('mousedown', downHandler);
            } else {
                resizeW = false;
                resizeH = false;
                $(target).off('mousedown', downHandler);
            }
        }
        function downHandler(event) {
            target = event.target || event.srcElement;
            var startX = event.clientX + scroll.x;
            var startY = event.clientY + scroll.y;
            _startX = parseInt(startX);
            _startY = parseInt(startY);
            if (document.addEventListener) {
                document.addEventListener("mousemove", moveHandler, true);
                document.addEventListener("mouseup", upHandler, true);
            } else if (document.attachEvent) {
                target.setCapture();
                target.attachEvent("onlosecapeture", upHandler);
                target.attachEvent("onmouseup", upHandler);
                target.attachEvent("onmousemove", moveHandler);
            }
            if (event.stopPropagation) {
                event.stopPropagation();
            } else {
                event.cancelBubble = true;
            }
            if (event.preventDefault) {
                event.preventDefault();
            } else {
                event.returnValue = false;
            }
        }
        function moveHandler(e) {
            if (!e) e = window.event;
            var w, h;
            var startX = parseInt(e.clientX + scroll.x);
            var startY = parseInt(e.clientY + scroll.y);
            target = target || e.target || e.srcElement;
            if (target == document.body) {
                return;
            }
            if (resizeW) {
                deltaX = startX - _startX;
                w = $(target).width() + deltaX < minSize ? minSize : $(target).width() + deltaX;
                target.style.width = w + "px";
                _startX = startX;
            }
            if (resizeH) {
                deltaY = startY - _startY;
                h = $(target).height() + deltaY < minSize ? minSize : $(target).height() + deltaY;
                target.style.height = h + "px";
                _startY = startY;
            }
            if (e.stopPropagation) {
                e.stopPropagation();
            } else {
                e.cancelBubble = true;
            }
        }
        function upHandler(e) {
            if (!e) {
                e = window.event;
            }
            resizeW = false;
            resizeH = false;
            target = e.target || e.srcElement;
            $(target).on("mouseout", outHandler);
            if (document.removeEventListener) {
                document.removeEventListener("mousemove", moveHandler, true);
                document.removeEventListener("mouseup", upHandler, true);
            } else if (document.detachEvent) {
                target.detachEvent("onlosecapeture", upHandler);
                target.detachEvent("onmouseup", upHandler);
                target.detachEvent("onmousemove", moveHandler);
                target.releaseCapture();
            }
            if (e.stopPropagation) {
                e.stopPropagation();
            } else {
                e.cancelBubble = true;
            }
        }
        function getScrollOffsets(w) {
            w = w || window;
            if (w.pageXOffset != null) {
                return { x: w.pageXOffset, y: w.pageYOffset };
            }
            var d = w.document;
            if (document.compatMode == "CSS1Compat") {
                return { x: d.documentElement.scrollLeft, y: d.documentElement.scrollTop };
            }
            return { x: d.body.scrollLeft, y: d.body.scrollTop };
        }
    }
}(jQuery));