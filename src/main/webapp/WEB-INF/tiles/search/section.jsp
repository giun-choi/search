<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function() {
	
	$('.page').click(function(event) {
		
		const selectedPage = $(event.currentTarget).data('page');
		window.location.href = '/search/' + selectedPage + '?query=' + '${query}';
	});
	
	fn_pcSelectMenu('${page}', '.p-menu-tab li');
	fn_mobileSelectMenu('${page}', '.m-menu-tab li');
	
	clientInfo.menu = '${page}';
	clientInfo.search_word = '${query}'.replaceAll('&', '_');
	XHR('/client/setSearchInfo', clientInfo, function(data) {
		
		console.log(data.result);
	});
	
	$(document).on('click', '.link', function(event) {
		
		let link = $(event.currentTarget).attr('href');
		clientInfo.click_link = link.replaceAll('&', '_');
		XHR('/client/setClickInfo', clientInfo, function(data) {
		
			console.log(data.result);
		});
	});
});

function fn_pcSelectMenu(page, selector) {
	
	fn_tagList(selector).filter(function(element, index, tagList) {
		
		if(index < 6 && page === $(element).data('page')) {
			
			$(element).addClass('active');
		}
		
		if(index > 6 && page === $(element).data('page')) {
			
			const data_page = $(tagList[5]).data('page');
			const text = $(tagList[5]).children('a').text();
			
			$(tagList[5]).data('page', $(element).data('page'));
			$(tagList[5]).children('a').html($(element).children('a').text());
			
			$(element).data('page', data_page);
			$(element).children('a').html(text);
			
			$(tagList[5]).addClass('active');
		}
	});
}

function fn_mobileSelectMenu(page, selector) {
	
	fn_tagList(selector).filter(function(element, index, tagList) {
		
		if(page === $(element).data('page')) {
			
			const offset = $(element).offset();
			$('.m-menu-tab').scrollLeft(offset.left -10);
			
			$(element).addClass('active');
		}
	});
}

function fn_tagList(selector) {
	
	const tagList = new Array();
	$(selector).map(function(index, element) {
		tagList.push(element);
	});
	return tagList;
}


</script>

<div class="container section">
	<div class="row">
		<div class="col-sm-2 blank">
			<!-- 로고 밑에 공백 -->
		</div>
		<div class="p-menu">
			<ul class="nav nav-pills p-menu-tab">
				<li class="page" role="presentation" data-page="integrated"><a>전체</a></li>
				<li class="page" role="presentation" data-page="kin"><a>지식 iN</a></li>
				<li class="page" role="presentation" data-page="blog"><a>블로그</a></li>
				<li class="page" role="presentation" data-page="cafearticle"><a>카페글</a></li>
				<li class="page" role="presentation" data-page="image"><a>이미지</a></li>
				<li class="page" role="presentation" data-page="news"><a>뉴스</a></li>
				<li role="presentation" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false"> 
						더보기 <span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li class="page" role="presentation" data-page="book"><a>책</a></li>
						<li class="page" role="presentation" data-page="movie"><a>영화</a></li>
						<li class="page" role="presentation" data-page="encyc"><a>백과사전</a></li>
						<li class="page" role="presentation" data-page="webkr"><a>웹문서</a></li>
						<li class="page" role="presentation" data-page="doc"><a>전문자료</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="m-menu">
			<ul class="nav nav-pills m-menu-tab">
				<li class="page" role="presentation" data-page="integrated"><a>전체</a></li>
				<li class="page" role="presentation" data-page="kin"><a>지식 iN</a></li>
				<li class="page" role="presentation" data-page="blog"><a>블로그</a></li>
				<li class="page" role="presentation" data-page="cafearticle"><a>카페글</a></li>
				<li class="page" role="presentation" data-page="image"><a>이미지</a></li>
				<li class="page" role="presentation" data-page="news"><a>뉴스</a></li>
				<li class="page" role="presentation" data-page="book"><a>책</a></li>
				<li class="page" role="presentation" data-page="movie"><a>영화</a></li>
				<li class="page" role="presentation" data-page="encyc"><a>백과사전</a></li>
				<li class="page" role="presentation" data-page="webkr"><a>웹문서</a></li>
				<li class="page" role="presentation" data-page="doc"><a>전문자료</a></li>
			</ul>
		</div>
	</div>
</div>
