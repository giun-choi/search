'use strict';

//문자날짜의 형식을 변경
function fn_dateFomat(str) {
	
    const year = str.substr(0, 4);
    const month = str.substr(4, 2);
    const day = str.substr(6, 2);
    
    return year + '-' + month + '-' + day;
}

//날짜 형식 변경
function fn_dateToStr(format) {

    let year = format.getFullYear();
    let month = format.getMonth() + 1;
    let date = format.getDate();
    
    let hour = format.getHours();
    let min = format.getMinutes();
    let sec = format.getSeconds();
    
    if(month < 10) month = '0' + month;
    if(date < 10) date = '0' + date;

    if(hour < 10) hour = '0' + hour;
    if(min < 10) min = '0' + min;
    if(sec < 10) sec = '0' + sec;

    return year + "-" + month + "-" + date + " " + hour + ":" + min + ":" + sec;
}

//마지막 문자 짜름
function fn_trimLastChar(str) {
	
	return str.substring(0, str.length-1);
}

String.prototype.replaceAll = function(org, dest) {
    return this.split(org).join(dest);
}
