<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function() {
	
	$('#add-btn').click(function() {
		
		const page = '${page}';
		const api_url = sessionStorage.getItem('api_url');
		
		params.start = (params.start + params.display);
		
		XHR(api_url, params, function(data) {
			
			const total = data.total;
			const display = data.display;
			if(total === ((display + params.start) - 1)) $('#add-btn').hide();
			
			$.each(data.searchList, function(index, item) {
				
				$('#contents-menu').append(fn_methodSelection(page, item));
			});
			
		});
	});
	
});
</script>

<div class="container footer">
	<div class="row">
		<div class="col-sm-2">
			<!-- 로고 밑에 공백 -->
		</div>
		<div class="col-sm-6 contents-menu" style="margin-bottom: 20px;">
			<button id="add-btn" type="button" class="btn btn-default btn-lg btn-block">더보기</button>
		</div>
	</div>
</div>