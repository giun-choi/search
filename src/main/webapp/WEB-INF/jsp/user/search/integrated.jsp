<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function() {
	
	let list = '';
	params.query = '${query}';

	/* 지식 iN */
	XHR('/search/getKinList', params, function(data) {

		list = data.searchList;
		
		$('#kin-body').html('');
		if(list === null || list.length === 0) {
			
			$('#kin-body').append(fn_noSearchTag('검색결과가 존재하지 않습니다.'));
			return;
		}
		$.each(list, function(index, item) {
			
			if(index > 2) return;
			$('#kin-body').append(fn_createKinTag(item));
		});
	});
	
	/* 블로그 */
	XHR('/search/getBlogList', params, function(data) {

		list = data.searchList;
		
		$('#blog-body').html('');
		if(list === null || list.length === 0) {
			
			$('#blog-body').append(fn_noSearchTag('검색결과가 존재하지 않습니다.'));
			return;
		}
		$.each(list, function(index, item) {

			if(index > 2) return;
			$('#blog-body').append(fn_createBlogTag(item));
			
		});
	});	
	
	/* 카페글 */
	XHR('/search/getCafeArticleList', params, function(data) {

		list = data.searchList;
		
		$('#cafearticle-body').html('');
		if(list === null || list.length === 0) {
			
			$('#cafearticle-body').append(fn_noSearchTag('검색결과가 존재하지 않습니다.'));
			return;
		}
		$.each(list, function(index, item) {
			
			if(index > 2) return;
			$('#cafearticle-body').append(fn_createCafeTag(item));
		});
	});	
	
	/* 뉴스 */
	XHR('/search/getNewsList', params, function(data) {

		list = data.searchList;
		
		$('#news-body').html('');
		if(list === null || list.length === 0) {
			
			$('#news-body').append(fn_noSearchTag('검색결과가 존재하지 않습니다.'));
			return;
		}
		$.each(list, function(index, item) {
			
			if(index > 2) return;
			$('#news-body').append(fn_createNewsTag(item));
		});
	});	
	
	/* 이미지 */
	XHR('/search/getImageList', params, function(data) {

		list = data.searchList;
		
		$('#image-body').html('');
		if(list === null || list.length === 0) {
			
			$('#image-body').append(fn_noSearchTag('검색결과가 존재하지 않습니다.'));
			return;
		}
		$.each(list, function(index, item) {

			if(index > 5) return;
			$('#image-body').append(fn_createImageTag(item));
		});
	});	
});
</script>

<div class="container contents">
	<div class="row">
		<div class="col-sm-2">
			<!-- 로고 밑에 공백 -->
		</div>
		<div id="contents-menu" class="col-sm-6 contents-menu">
			<!-- 지식 iN -->
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">지식 iN</h3>
				</div>
				<div class="panel-body" id="kin-body">

				</div>
			</div>
			<!-- 블로그 -->
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">블로그</h3>
				</div>
				<div class="panel-body" id="blog-body">

				</div>
			</div>
			<!-- 카페글 -->
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">카페글</h3>
				</div>
				<div class="panel-body" id="cafearticle-body">

				</div>
			</div>
			<!-- 뉴스 -->
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">뉴스</h3>
				</div>
				<div class="panel-body" id="news-body">

				</div>
			</div>
			<!-- 이미지 -->
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">이미지</h3>
				</div>
				<div class="panel-body" id="image-body">

				</div>
			</div>	
		</div>
	</div>
</div>
