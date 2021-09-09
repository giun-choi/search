'use strict';

function fn_methodSelection(page, tagInfo) {
	
	let tag = '';
	
	switch(page) {
		case 'blog': 
			tag = fn_createBlogTag(tagInfo);
			break;
		case 'book': 
			tag = fn_createBookTag(tagInfo);
			break;
		case 'cafearticle': 
			tag = fn_createCafeTag(tagInfo);
			break;
		case 'doc': 
			tag = fn_createDocTag(tagInfo);
			break;
		case 'encyc': 
			tag = fn_createEncycTag(tagInfo);
			break;			
		case 'image': 
			tag = fn_createImageTag(tagInfo);
			break;
		case 'kin': 
			tag = fn_createKinTag(tagInfo);
			break;			
		case 'movie': 
			tag = fn_createMovieTag(tagInfo);
			break;
		case 'news': 
			tag = fn_createNewsTag(tagInfo);
			break;
		case 'webkr': 
			tag = fn_createWebkrTag(tagInfo);
			break;
		default: 
			throw new Error('함수 선택이 잘못되었습니다.');
			break;	
	}
	
	return tag;
}

//블로그 태그 생성
function fn_createBlogTag(tagInfo) {
	
	return	'<div class="panel panel-default card">' +	
				'<div class="panel-heading">' +	
					'<p><span class="glyphicon glyphicon-time"></span>&nbsp;&nbsp;<b>' + fn_dateFomat(tagInfo.postdate) + '</b></p>' +					
					'<span class="glyphicon glyphicon-share-alt"></span>' +					
					'<a class="link" href="' + tagInfo.bloggerlink + '" target="_blank" title="블로그 들어가보기">&nbsp;&nbsp;' + tagInfo.bloggername + '</a>' +					
				'</div>' +				
				'<div class="panel-body card-body">' +			
					'<p><a class="link" href="' + tagInfo.link + '" target="_blank">' + tagInfo.title + '</a></p>' +			
					'<hr />' +					
					'<a class="link" href="' + tagInfo.link + '" target="_blank">' +					
						tagInfo.description +					
					'</a>' +				
				'</div>' +		
			'</div>';
}

//책 태그 생성
function fn_createBookTag(tagInfo) {
	
	return	'<div class="media" style="border: 1px solid #5cb85c; padding: 5px; border-radius: 5px;">' +					
				'<div class="media-left">' +								
					'<a class="link" href="' + tagInfo.link + '" target="_blank">' +									
						'<img class="media-object" src="' + tagInfo.image + '" alt="책 이미지">' +										
					'</a>' +									
				'</div>' +								
				'<div class="media-body">' +								
					'<p><b>책 제목 : </b>' + tagInfo.title + '</p>'	 +								
					'<p><b>저자 : </b>' + tagInfo.author + '</p>' +									
					'<p><b>출판 : </b>' + tagInfo.publisher + '&nbsp;&nbsp;|&nbsp;&nbsp;' + fn_dateFomat(tagInfo.pubdate) + '</p>' +									
				'</div>' +								
				'<p style="margin-top: 5px;">' + tagInfo.description + '</p>' +								
			'</div>';					
}

//카페글 태그 생성
function fn_createCafeTag(tagInfo) {
	
	return	'<div class="panel panel-default card">' +	
				'<div class="panel-heading">' +	
					'<span class="glyphicon glyphicon-share-alt"></span>' +					
					'<a class="link" href="' + tagInfo.cafeurl + '" target="_blank" title="카페 들어가보기">&nbsp;&nbsp;' + tagInfo.cafename + '</a>' +					
				'</div>' +				
				'<div class="panel-body card-body">' +			
					'<p><a href="' + tagInfo.link + '" target="_blank">' + tagInfo.title + '</a></p>' +			
					'<hr />' +					
					'<a class="link" href="' + tagInfo.link + '" target="_blank">' +					
						tagInfo.description +					
					'</a>' +				
				'</div>' +		
			'</div>';
}

//전문자료 태그 생성
function fn_createDocTag(tagInfo) {
	
	const _description = (tagInfo.description !== '' ? tagInfo.description : '내용없음');
	
	return	'<div class="panel panel-default card">' +	
				'<div class="panel-heading">' +	
					'<span class="glyphicon glyphicon-bookmark"></span>' +					
					'<a class="link" href="' + tagInfo.link + '" target="_blank" title="문서 들어가보기">&nbsp;&nbsp;' + tagInfo.title + '</a>' +					
				'</div>' +				
				'<div class="panel-body description">' +			
					'<a class="link" href="' + tagInfo.link + '" target="_blank">' +					
						_description +					
					'</a>' +				
				'</div>' +		
			'</div>';
}

//백과사전 태그 생성
function fn_createEncycTag(tagInfo) {
	
	return	'<div class="panel panel-default card">' +	
				'<div class="panel-heading">' +	
					'<span class="glyphicon glyphicon-book"></span>' +					
					'<a class="link" href="' + tagInfo.link + '" target="_blank" title="백과사전 들어가보기">&nbsp;&nbsp;' + tagInfo.title + '</a>' +					
				'</div>' +				
				'<div class="panel-body description">' +			
					'<a class="link" href="' + tagInfo.link + '" target="_blank">' +					
						tagInfo.description +					
					'</a>' +				
				'</div>' +		
			'</div>';
}

//이미지 태그 생성
function fn_createImageTag(tagInfo) {
	
	return	'<div class="col-sm-6 col-sm-6 image-card">' +
				'<div class="thumbnail">' +
					'<a class="link" href="' + tagInfo.link + '" target="_blank">' +
						'<img src="' + tagInfo.thumbnail + '" alt="썸네일">' +
					'</a>' +
					'<p class="text-center" style="margin-top: 10px;">' + tagInfo.sizewidth + ' X ' + tagInfo.sizeheight + '</p>' +
					'<p class="text-center">' + tagInfo.title + '</p>' +
				'</div>' +
			'</div>';
}

//지식iN 태그 생성
function fn_createKinTag(tagInfo) {
	
	return	'<div class="panel panel-default">' +
				'<div class="panel-heading title"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;' + tagInfo.title + '</div>' +
				'<div class="panel-body description"><a class="link" href="' + tagInfo.link + '" target="_blank">' + tagInfo.description + '</a></div>' +
			'</div>';
}

//영화 태그 생성
function fn_createMovieTag(tagInfo) {
	
	let _director = tagInfo.director;
	let _actor = tagInfo.actor;
	let _userRating = tagInfo.userRating;
	
	if(_director !== '') _director = '<p style="margin-top: 5px;"><b>감독</b> : ' + fn_trimLastChar(tagInfo.director) + '</p>';
	if(_actor !== '') _actor = '<p style="margin-top: 5px;"><b>배우</b> : ' + fn_trimLastChar(tagInfo.actor) + '</p>';
	if(_userRating !== '') _userRating = '<p style="margin-top: 5px;"><b>평점</b> : ' + tagInfo.userRating + '</p>';	
	
	const _image = (tagInfo.image !== '' ? tagInfo.image : '/resources/img/no_image.png');
	
	return	'<div class="media" style="border: 1px solid #5cb85c; padding: 5px; border-radius: 5px;">' +
				'<div class="media-left">' +
					'<a class="link" href="' + tagInfo.link + '" target="_blank">' +
						'<img class="media-object" src="' + _image + '" alt="...">' +
					'</a>' +
				'</div>' +
				'<div class="media-body">' +
					'<p><span class="glyphicon glyphicon-time"></span>&nbsp;&nbsp;' + tagInfo.pubDate + '</p>' +
					'<p><b>영화 제목 : </b>' + tagInfo.title + '</p>' +
					_director +
					_actor +
					_userRating +
				'</div>' +
			'</div>';
}

//뉴스 태그 생성
function fn_createNewsTag(tagInfo) {
	
	return	'<div class="panel panel-default card">' +	
				'<div class="panel-heading">' +	
					'<span class="glyphicon glyphicon-time"></span>' +					
					'<span>&nbsp;&nbsp;' + fn_dateToStr(new Date(tagInfo.pubDate)) + '</span>' +
				'</div>' +				
				'<div class="panel-body card-body">' +			
					'<p><a class="link" href="' + tagInfo.link + '" target="_blank">' + tagInfo.title + '</a></p>' +			
					'<hr />' +					
					'<a class="link" href="' + tagInfo.originallink + '" target="_blank">' +					
						tagInfo.description +					
					'</a>' +				
				'</div>' +		
			'</div>';
}

//웹문서 태그 생성
function fn_createWebkrTag(tagInfo) {
	
	return	'<div class="panel panel-default card">' +	
				'<div class="panel-heading">' +	
					'<span class="glyphicon glyphicon-file"></span>' +					
					'<a class="link" href="' + tagInfo.link + '" target="_blank" title="문서 들어가보기">&nbsp;&nbsp;' + tagInfo.title + '</a>' +					
				'</div>' +				
				'<div class="panel-body description">' +			
					'<a class="link" href="' + tagInfo.link + '" target="_blank">' +					
						tagInfo.description +					
					'</a>' +				
				'</div>' +		
			'</div>';
}

//검색결과 없을 때 태그
function fn_noSearchTag(str) {
	
	return '<h2>' + str + '</h2>';
}
