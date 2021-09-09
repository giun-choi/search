<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function() {
		
	const api_url = '/search/getBookList';
	params.query = '${query}';
			
	sessionStorage.setItem('api_url', api_url);
	
	XHR(api_url, params, function(data) {
		
		const list = data.searchList;
		const total = data.total;
		if(10 >= total) $('#add-btn').hide();
		
		$('#contents-menu').html('');
		if(list === null || list.length === 0) {
			
			$('#add-btn').hide();
			$('#contents-menu').append(fn_noSearchTag('검색결과가 존재하지 않습니다.'));
			return;
		}
		$.each(list, function(index, item) {
			
			$('#contents-menu').append(fn_createBookTag(item));
		});
	});
	
});

function fn_dateFomat(str) {
	
    const year = str.substr(0, 4);
    const month = str.substr(4, 2);
    const day = str.substr(6, 2);
    
    return year + '-' + month + '-' + day;
}
</script>

<div class="container contents">
	<div class="row">
		<div class="col-sm-2">
			<!-- 로고 밑에 공백 -->
		</div>
		<div id="contents-menu" class="col-sm-6 contents-menu">

		</div>
	</div>
</div>
