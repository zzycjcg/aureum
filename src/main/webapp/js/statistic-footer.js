/*
	页脚时间计算
*/
if (pageStartMS && $) {
    $(document).ready(function() {
        console.log("Time until DOMready: ", Date.now() - pageStartMS);
    });
    $(window).load(function() {
        console.log("Time until everything loaded: ", Date.now() - pageStartMS);
    });
}
